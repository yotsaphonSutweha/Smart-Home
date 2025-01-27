package io.grpc.project.smarthome.tv;

import io.grpc.*;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.stub.StreamObserver;
import objects.TV;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;

public class TVServer extends TvServiceImplBase {
    public TV tv = new TV();
    private static final Logger logger = Logger.getLogger(TVServer.class.getName());
    private static SpeakersServiceGrpc.SpeakersServiceBlockingStub speakersServiceBlockingStub;
    private static SpeakersServiceGrpc.SpeakersServiceStub speakersServiceAsyncStub;
    private ArrayList<String> deviceList = new ArrayList<>();


    /*
        The listener class for TV server. The implementation is the same on the client but it is used for discovering speakers service.
     */
    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceRemoved(ServiceEvent serviceEvent) {
            System.out.println("Service removed: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent serviceEvent) {
            System.out.println("Service resolved: " + serviceEvent.getInfo());
            try {
                ManagedChannel speakerChannel = ManagedChannelBuilder.forAddress("localhost", serviceEvent.getInfo().getPort()).usePlaintext().build();
                speakersServiceBlockingStub = SpeakersServiceGrpc.newBlockingStub(speakerChannel);
                speakersServiceAsyncStub = SpeakersServiceGrpc.newStub(speakerChannel);
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect PORT for Speakers server");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        /*
            Registering the service information with jmDNS. And also add the speaker service for discovery.
         */
        try {
            int PORT = 8003;
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_tvserver._tcp.local.", "tv", PORT, "This is TV server");
            jmdns.registerService(serviceInfo);
            jmdns.addServiceListener("_speakerserver._tcp.local.", new TVServer.Listener());
            TVServer smServer = new TVServer();
            Server server = ServerBuilder.forPort(PORT)
                    .addService(smServer)
                    .build()
                    .start();
            System.out.println("TV server started, listening on " + PORT);
            server.awaitTermination();
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public void threadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /*
        The server side of the TV gRPC server.
     */
    @Override
    public StreamObserver<io.grpc.project.smarthome.tv.StringRequest> liveContent(StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
        return new StreamObserver<io.grpc.project.smarthome.tv.StringRequest>() {
            @Override
            public void onNext(StringRequest value) {
                StringBuilder sb = new StringBuilder(value.getStringRequestValue());
                StringResponse res = StringResponse.newBuilder().setStringResponseValue(sb.toString()).build();
                responseObserver.onNext(res);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void displayChannelList(io.grpc.project.smarthome.tv.StringRequest request, StreamObserver<StringResponse> responseObserver) {
        StringBuilder sb = new StringBuilder(request.getStringRequestValue());
        if (sb.toString().equalsIgnoreCase("Display channels")) {
            ArrayList<String> channels = tv.channelList();
            for (String c : channels) {
                responseObserver.onNext(io.grpc.project.smarthome.tv.StringResponse.newBuilder().setStringResponseValue(c).build());
            }
            responseObserver.onCompleted();
        }
    }

    @Override
    public void turnOn(io.grpc.project.smarthome.tv.BooleanRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving message");
        boolean turnOn = request.getBooleanRequestValue();
        String result = "";
        String speakersStatus = "";
        if (turnOn) {
            result = tv.turnOn();
            /* Also invoking the turnOnSpeakers method for making the request to the speakers server. This
                is also a part of implementation where the TV service invokes the Speakers service for the GUI client.
             */
            speakersStatus = turnOnSpeakers();
        } else {
            result = tv.turnOff();
            /* Also invoking the turnOffSpeakers method for making the request to the speakers server This
                is also a part of implementation where the TV service invokes the Speakers service for the GUI client.
            */
            speakersStatus = turnOffSpeakers();
        }
        StringResponse response = io.grpc.project.smarthome.tv.StringResponse.newBuilder().setStringResponseValue(result).setStringResponseValue2(speakersStatus).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<io.grpc.project.smarthome.tv.IntRequest> increaseVolume(StreamObserver<io.grpc.project.smarthome.tv.IntResponse> responseObserver) {
        return new StreamObserver<io.grpc.project.smarthome.tv.IntRequest>() {
            int currentVolume = 0;
            @Override
            public void onNext(IntRequest value) {
                System.out.println("Receiving volume -> " + value.getNumInput());
                currentVolume += value.getNumInput();
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                int speakersVolume = setSpeakersVolume(currentVolume);
                io.grpc.project.smarthome.tv.IntResponse res = IntResponse.newBuilder().setNumOutput(speakersVolume).build();
                responseObserver.onNext(res);
                responseObserver.onCompleted();
            }
        };
    }

    /*
        displayInputsSpeakersCommand and musicStreamingSpeakersCommand are used for accepting the command from the GUI client and invoke
        the functions within the speakers server. This is part of the implementation where TV service acts like a middle man for the GUI client to use the
        speakers service.
     */
    @Override
    public void displayInputsSpeakersCommand(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String command = request.getStringRequestValue();
        StringResponse response;
        ArrayList<String> speakersInputs = new ArrayList<>();
        // Accepting the command from GUI client
        if (command.equalsIgnoreCase("Display available inputs for speakers")) {
            // Make the request to the speakers server to get the speakers inputs.
            displayAvailableSpeakersInputs();
            // From the tv object the the array of speakers' available inputs
            speakersInputs = tv.getSpeakersAvailableInputs();
            response = StringResponse.newBuilder().setStringResponseValue(speakersInputs.get(0) + " " + speakersInputs.get(1) + " " + speakersInputs.get(2)).build();
            responseObserver.onNext(response);
            speakersInputs.clear();
        } else {
            response = StringResponse.newBuilder().setStringResponseValue("Please provide correct input!").build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }


    @Override
    public void musicStreamingSpeakersCommand(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String command = request.getStringRequestValue();
        StringResponse response;
        if (command.equalsIgnoreCase("Play Get Down on Saturday night")) {
            // Music streaming method is a speaker's gRPC client side methods, returning an arrayList.
            ArrayList<String> lyrics = musicStreaming();
            // Use the arrayList to build the response for the GUI client.
            String strLyrics = lyrics.get(0) + "," + lyrics.get(1) + "," + lyrics.get(2) + "," + lyrics.get(3) + "," + lyrics.get(4) + "," + lyrics.get(5) + "," + lyrics.get(6) + "," + lyrics.get(7);
            response = StringResponse.newBuilder().setStringResponseValue(strLyrics).build();
            responseObserver.onNext(response);
        } else {
            response = StringResponse.newBuilder().setStringResponseValue("Please provide correct response").build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
    /*
        End of the server side of the TV gRPC server.
     */

    /*
        The client side of the speakers gRPC server. These methods are used to invokes the functions on the speakers gRPC server. These methods are invoked by
        the TV server in order to deliver contents to the GUI client. These are the implementations for a service that invokes another implemented service.
    */
    public String turnOnSpeakers() {
        io.grpc.project.smarthome.speakers.BooleanRequest request = io.grpc.project.smarthome.speakers.BooleanRequest.newBuilder().setBooleanRequestValue(true).build();
        try {
            io.grpc.project.smarthome.speakers.StringResponse response = speakersServiceBlockingStub.turnOnSpeakers(request);
            System.out.println("Speaker " + response.getStringResponseValue());
            return response.getStringResponseValue();
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            JOptionPane.showMessageDialog(null, "Speakers server error: Unable to process the request");
            e.printStackTrace();
        }
        return "RPC failed";
    }

    public String turnOffSpeakers() {
        io.grpc.project.smarthome.speakers.BooleanRequest request = io.grpc.project.smarthome.speakers.BooleanRequest.newBuilder().setBooleanRequestValue(false).build();
        try {
            io.grpc.project.smarthome.speakers.StringResponse response = speakersServiceBlockingStub.turnOnSpeakers(request);
            System.out.println("Speaker " + response.getStringResponseValue());
            return response.getStringResponseValue();
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            JOptionPane.showMessageDialog(null, "Speakers server error: Unable to process the request");
            e.printStackTrace();
        }
        return "RPC failed";
    }

    public void displayAvailableSpeakersInputs() {
        // Making the request.
        io.grpc.project.smarthome.speakers.BooleanRequest request = io.grpc.project.smarthome.speakers.BooleanRequest.newBuilder().setBooleanRequestValue(true).build();
        // Use responseStreamObserver for the response
        StreamObserver<io.grpc.project.smarthome.speakers.StringResponse> responseStreamObserver = new StreamObserver<io.grpc.project.smarthome.speakers.StringResponse>() {
            String input = "";
            @Override
            public void onNext(io.grpc.project.smarthome.speakers.StringResponse value) {
                // Use the tv object and store the responses inside the array by using setSpeakersAvailableInputs method
                tv.setSpeakersAvailableInputs(value.getStringResponseValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("On completed");
            }
        };
        try {
            speakersServiceAsyncStub.displayInputs(request, responseStreamObserver);
            threadSleep(3000);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            JOptionPane.showMessageDialog(null, "Speakers server error: Unable to process the request");
            e.printStackTrace();
        }
    }

    public int setSpeakersVolume(int volume) {
        try {
            io.grpc.project.smarthome.speakers.IntRequest request = io.grpc.project.smarthome.speakers.IntRequest.newBuilder().setNumInput(volume).build();
            io.grpc.project.smarthome.speakers.IntResponse response = speakersServiceBlockingStub.setVolume(request);
            return response.getNumOutput();
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            JOptionPane.showMessageDialog(null, "Speakers server error: Unable to process the request");
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String> musicStreaming() {
        ArrayList<String> musicLyrics = new ArrayList<>();
        StreamObserver<io.grpc.project.smarthome.speakers.StringRequest> request = speakersServiceAsyncStub.musicStreaming(new StreamObserver<io.grpc.project.smarthome.speakers.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.speakers.StringResponse value) {
                System.out.println(value.getStringResponseValue());
                musicLyrics.add(value.getStringResponseValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Music has stopped");
            }
        });

        try {
            System.out.println("Playing Get Down Saturday night song...");
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Saturday morning").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Friday's enemy").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Housework is calling").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("But where to begin").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Kids are out of school").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Trying to find a friend").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Everybody's busy").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setStringRequestValue("Can't wait for the night to begin").build());
            threadSleep(3000);
        } catch (RuntimeException e) {
            System.out.println("RPC failed: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Speakers server error: Unable to process the request");
            e.printStackTrace();
            request.onError(e);
            throw e;
        }
        request.onCompleted();
        return  musicLyrics;
    }
    /*
        End of client side for speakers gRPC service.
     */
}
