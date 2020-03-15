package io.grpc.project.smarthome.tv;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.stub.StreamObserver;
import objects.TV;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class TVServer extends TvServiceImplBase {
    private TV tv = new TV();
    private static final Logger logger = Logger.getLogger(TVServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            int PORT = 8000;
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "localhost", PORT, "path=index.html");
            jmdns.registerService(serviceInfo);
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
