package io.grpc.project.smarthome.speakers;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc.SpeakersServiceImplBase;
import io.grpc.stub.StreamObserver;
import objects.Speakers;

import java.io.IOException;
import java.net.InetAddress;
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

    public void turnOnSpeakers(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        System.out.println("Receiving message");

        StringBuilder sb = new StringBuilder(request.getVal());
        String output = sb.toString();

        System.out.println("Command: " + output);
        String result = "";

        if (output.equalsIgnoreCase("Turn on")) {
            result = speakers.turnOn();
        }

        StringResponse response = StringResponse.newBuilder().setVal(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
