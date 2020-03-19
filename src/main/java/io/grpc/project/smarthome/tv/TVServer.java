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
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class TVServer extends TvServiceImplBase {
    private TV tv = new TV();
    private static final Logger logger = Logger.getLogger(TVServer.class.getName());
    private static SpeakersServiceGrpc.SpeakersServiceBlockingStub speakersServiceBlockingStub;

    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            if(serviceEvent.getName().equals("localhost")) {
                ManagedChannel channel2 = ManagedChannelBuilder.forAddress(serviceEvent.getName(), 8001).usePlaintext().build();
                speakersServiceBlockingStub = SpeakersServiceGrpc.newBlockingStub(channel2);
                turnOnSpeakers();
            }
        }

        @Override
        public void serviceRemoved(ServiceEvent serviceEvent) {
            System.out.println("Service removed: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent serviceEvent) {
            System.out.println("Service resolved: " + serviceEvent.getInfo());
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

    public static void turnOnSpeakers() {
        io.grpc.project.smarthome.speakers.StringRequest request = io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Turn on").build();
        io.grpc.project.smarthome.speakers.StringResponse response1 = speakersServiceBlockingStub.turnOnSpeakers(request);
        System.out.println(response1.getVal());
    }

    public void turnOn(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving message");

        StringBuilder sb = new StringBuilder(request.getVal());
        String output = sb.toString();

        System.out.println("Command: " + output);
        String result = "";

        if (output.equalsIgnoreCase("Turn on")) {
            result = tv.turnOn();
            tv.connnected(true);
        }

        StringResponse response = StringResponse.newBuilder().setVal(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
