package io.grpc.project.smarthome.lights;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import objects.Lights;
import io.grpc.project.smarthome.lights.LightsServiceGrpc.LightsServiceImplBase;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LightsServer extends LightsServiceImplBase {
    private Lights lights = new Lights();
    private static final Logger logger = Logger.getLogger(LightsServer.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            int PORT = 8002;
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            ServiceInfo serviceInfo = ServiceInfo.create("_lights._tcp.local.", "localhost", PORT, "Lights server");
            jmdns.registerService(serviceInfo);
            LightsServer smServer = new LightsServer();
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
    public void lightSwitch(BooleanRequest request, StreamObserver<StringResponse> responseObserver) {
        boolean req = request.getBooleanValue();
        if (req) {
            lights.setSwitch(req);
            String isOn = "Light is on";
            StringResponse res = StringResponse.newBuilder().setStringResponseValue(isOn).build();
            responseObserver.onNext(res);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void displayLightModes(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        if(request.getStringRequestValue().equals("Display lights modes")) {
            ArrayList<String> lightsModes = lights.getLightModes();
            for (String mode : lightsModes) {
                responseObserver.onNext(StringResponse.newBuilder().setStringResponseValue(mode).build());
            }
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<StringRequest> lightCombiner(StreamObserver<StringResponse> responseObserver) {
        return new StreamObserver<StringRequest>() {
            String lightCombination = "";
            @Override
            public void onNext(StringRequest value) {
                lightCombination = lightCombination + " " + value.getStringRequestValue();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                lights.setLightColor(lightCombination);
                StringResponse response = StringResponse.newBuilder().setStringResponseValue(lights.getLightColor()).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void setLightMode(Modes request, StreamObserver<StringResponse> responseObserver) {
        System.out.println(request.getDetail());
        lights.setLightMode(request.getDetail().toString());
        StringResponse response = StringResponse.newBuilder().setStringResponseValue(lights.getLightMode()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
