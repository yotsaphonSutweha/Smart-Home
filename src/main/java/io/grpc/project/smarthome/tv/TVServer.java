package io.grpc.project.smarthome.tv;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.stub.StreamObserver;
import objects.TV;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class TVServer extends TvServiceImplBase {
    private static TV tv = new TV();
    private static final Logger logger = Logger.getLogger(TVServer.class.getName());
    private static SpeakersServiceGrpc.SpeakersServiceBlockingStub speakersServiceBlockingStub;
    private static SpeakersServiceGrpc.SpeakersServiceStub speakersServiceAsyncStub;
    private ArrayList<String> deviceList = new ArrayList<>();

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
            ManagedChannel speakerChannel = ManagedChannelBuilder.forAddress(serviceEvent.getName(), serviceEvent.getInfo().getPort()).usePlaintext().build();
            speakersServiceBlockingStub = SpeakersServiceGrpc.newBlockingStub(speakerChannel);
            speakersServiceAsyncStub = SpeakersServiceGrpc.newStub(speakerChannel);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            int PORT = 8000;
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "localhost", PORT, "TV server");
            jmdns.registerService(serviceInfo);
            jmdns.addServiceListener("_speakers._tcp.local.", new TVServer.Listener());
            TVServer smServer = new TVServer();
            Server server = ServerBuilder.forPort(PORT)
                    .addService(smServer)
                    .build()
                    .start();
            logger.info("Server started, listening on " + PORT);
            server.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public StreamObserver<io.grpc.project.smarthome.tv.StringRequest> liveContent(StreamObserver<io.grpc.project.smarthome.tv.StringResponse> responseObserver) {
        return new StreamObserver<io.grpc.project.smarthome.tv.StringRequest>() {
            @Override
            public void onNext(StringRequest value) {
                StringBuilder sb = new StringBuilder(value.getVal());
                StringResponse res = StringResponse.newBuilder().setVal(sb.toString()).build();
                responseObserver.onNext(res);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void displayChannelList(io.grpc.project.smarthome.tv.StringRequest request, StreamObserver<StringResponse> responseObserver) {
        StringBuilder sb = new StringBuilder(request.getVal());

        if (sb.toString().equalsIgnoreCase("Display channels")) {
            ArrayList<String> channels = tv.channelList();
            for (String c : channels) {
                responseObserver.onNext(io.grpc.project.smarthome.tv.StringResponse.newBuilder().setVal(c).build());
            }
            responseObserver.onCompleted();
        }
    }

    @Override
    public void turnOn(io.grpc.project.smarthome.tv.BooleanRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving message");
        boolean turnOn = request.getVal();
        String result = "";
        if (turnOn) {
            result = tv.turnOn();
        }
        StringResponse response = io.grpc.project.smarthome.tv.StringResponse.newBuilder().setVal(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        // Speakers features
//        turnOnSpeakers();
//        displayAvailableSpeakersInputs();
        speakersDeviceDetecting();
//        musicStreaming();
    }

    @Override
    public StreamObserver<io.grpc.project.smarthome.tv.IntRequest> increaseVolume(StreamObserver<io.grpc.project.smarthome.tv.IntResponse> responseObserver) {
        return new StreamObserver<io.grpc.project.smarthome.tv.IntRequest>() {
            int currentVolume = 0;
            @Override
            public void onNext(IntRequest value) {
                System.out.println("Receiving volumn -> " + value.getNumInput());
                currentVolume += value.getNumInput();

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                io.grpc.project.smarthome.tv.IntResponse res = IntResponse.newBuilder().setVolume(currentVolume).build();
                responseObserver.onNext(res);
                responseObserver.onCompleted();
            }
        };
    }

    public void turnOnSpeakers() {
        io.grpc.project.smarthome.speakers.BooleanRequest request = io.grpc.project.smarthome.speakers.BooleanRequest.newBuilder().setVal(true).build();
        io.grpc.project.smarthome.speakers.StringResponse response = speakersServiceBlockingStub.turnOnSpeakers(request);
        System.out.println("Speaker is " + response.getVal());
    }

    public void displayAvailableSpeakersInputs() {
        io.grpc.project.smarthome.speakers.BooleanRequest request = io.grpc.project.smarthome.speakers.BooleanRequest.newBuilder().setVal(true).build();
        StreamObserver<io.grpc.project.smarthome.speakers.StringResponse> responseStreamObserver = new StreamObserver<io.grpc.project.smarthome.speakers.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.speakers.StringResponse value) {
                System.out.println("Speaker's" + value.getVal() + " is ready");
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("On completed");
            }
        };

        speakersServiceAsyncStub.displayInputs(request, responseStreamObserver);
        threadSleep();
    }

    public void threadSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void speakersDeviceDetecting() {

        deviceList.add("TV");
        deviceList.add("Curtains");
        deviceList.add("Lights");

        StreamObserver<io.grpc.project.smarthome.speakers.StringRequest> request = speakersServiceAsyncStub.deviceDetection(new StreamObserver<io.grpc.project.smarthome.speakers.IntResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.speakers.IntResponse value) {
                System.out.println("The amount of available connected devices are " + value.getNum());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Device detection on completed");
            }
        });

        try {
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal(deviceList.get(0)).build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal(deviceList.get(1)).build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal(deviceList.get(2)).build());
            threadSleep();
            request.onCompleted();

        } catch (RuntimeException e) {
            // Cancel RPC
            request.onError(e);
            throw e;
        }
    }

    public void musicStreaming() {

        StreamObserver<io.grpc.project.smarthome.speakers.StringRequest> request = speakersServiceAsyncStub.musicStreaming(new StreamObserver<io.grpc.project.smarthome.speakers.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.speakers.StringResponse value) {
                System.out.println(value.getVal());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Music has stopped");
            }
        });

        try {
            System.out.println("Playing Get Down Saturday night song...");
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Saturday morning,").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Friday's enemy").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Housework is calling,").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("But where to begin").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Kids are out of school,").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Trying to find a friend").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Everybody's busy,").build());
            request.onNext(io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Can't wait for the night to begin").build());
            threadSleep();
            request.onCompleted();
        } catch (RuntimeException e) {
            request.onError(e);
        }
    }
}
