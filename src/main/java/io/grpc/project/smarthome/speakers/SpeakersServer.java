package io.grpc.project.smarthome.speakers;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc.SpeakersServiceImplBase;
import io.grpc.stub.StreamObserver;
import objects.Speakers;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


public class SpeakersServer extends SpeakersServiceImplBase{
    private Speakers speakers = new Speakers();
    private static final Logger logger = Logger.getLogger(SpeakersServer.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            int PORT = 8001;
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_speakers._tcp.local.", "localhost", PORT, "Speakers server");
            jmdns.registerService(serviceInfo);
            SpeakersServer smServer = new SpeakersServer();
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
    public StreamObserver<StringRequest> musicStreaming(StreamObserver<StringResponse> responseObserver) {
        return new StreamObserver<StringRequest>() {
            @Override
            public void onNext(StringRequest value) {
                System.out.println("Receiving the lyrics");
                StringResponse res = StringResponse.newBuilder().setStringResponseValue(value.getStringRequestValue()).build();
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
    public void displayInputs(BooleanRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving commands from TV....");

        boolean displayInputs = request.getBooleanRequestValue();
        if (displayInputs) {
            ArrayList<String> availableInputs = speakers.availableInputs();
            for (String input : availableInputs) {
                responseObserver.onNext(StringResponse.newBuilder().setStringResponseValue(input).build());
            }
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<StringRequest> deviceDetection(StreamObserver<io.grpc.project.smarthome.speakers.IntResponse> responseStreamObserver) {
        System.out.println("This is device display");
        ArrayList<String> arr = new ArrayList<>();
        return new StreamObserver<StringRequest>() {
            @Override
            public void onNext(StringRequest value) {
                System.out.println(value.getStringRequestValue());
                arr.add(value.getStringRequestValue());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                speakers.setDeviceList(arr);
                int size = speakers.getDeviceList().size();
                System.out.println("Size of arr" + size);
                io.grpc.project.smarthome.speakers.IntResponse res = io.grpc.project.smarthome.speakers.IntResponse.newBuilder().setNumOutput(size).build();
                responseStreamObserver.onNext(res);
                responseStreamObserver.onCompleted();
            }
        };
    }



    public void turnOnSpeakers(BooleanRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving message");


        boolean turnOn = request.getBooleanRequestValue();

        String result = "";

        if (turnOn) {
            result = speakers.turnOn();
        }
        speakers.setConnectedToTv(true);
        StringResponse response = StringResponse.newBuilder().setStringResponseValue(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
