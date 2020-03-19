package io.grpc.project.smarthome.tv;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceFutureStub;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceBlockingStub;
import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc.SpeakersServiceBlockingStub;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Logger;
public class TVClient {

    static Hashtable<String, Integer> services = new Hashtable<>();

    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            if (serviceEvent.getName().equals("localhost")) {
                System.out.println(serviceEvent.getName());
                ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceEvent.getName(), 8000).usePlaintext().build();
                blockingStub = TvServiceGrpc.newBlockingStub(channel);
                turnOn();
            }

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
            services.put(serviceEvent.getType(), serviceEvent.getInfo().getPort());

        }
    }


    private static Logger logger = Logger.getLogger(TVClient.class.getName());
    private static TvServiceBlockingStub blockingStub;
    //    private static SmartHomeServiceGrpc.SmartHomeServiceFutureStub asyncStub;
    private static TvServiceFutureStub futureStub;
    private static SpeakersServiceBlockingStub speakersServiceBlockingStub;

    public static void main(String[] args) throws Exception {
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_http._tcp.local.", new TVClient.Listener());
            jmdns.addServiceListener("_speakers._tcp.local.", new TVClient.Listener());
            System.out.println(services);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void turnOn() {
        StringRequest request = StringRequest.newBuilder().setVal("Turn on").build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getVal());
    }

    public static void turnOnSpeakers() {
        io.grpc.project.smarthome.speakers.StringRequest request = io.grpc.project.smarthome.speakers.StringRequest.newBuilder().setVal("Turn on").build();
        io.grpc.project.smarthome.speakers.StringResponse response1 = speakersServiceBlockingStub.turnOnSpeakers(request);
        System.out.println(response1.getVal());
    }

}
