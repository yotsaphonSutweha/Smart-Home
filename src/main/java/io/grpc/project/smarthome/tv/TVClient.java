package io.grpc.project.smarthome.tv;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceFutureStub;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceBlockingStub;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;
public class TVClient {

    public static class Listener implements ServiceListener{

        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            if (serviceEvent.getName().equals("localhost")) {
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000).usePlaintext().build();
                blockingStub = TvServiceGrpc.newBlockingStub(channel);
                makeConnection();
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


    private static Logger logger = Logger.getLogger(TVClient.class.getName());
    private static TvServiceBlockingStub blockingStub;
    //    private static SmartHomeServiceGrpc.SmartHomeServiceFutureStub asyncStub;
    private static TvServiceFutureStub futureStub;

    public static void main(String[] args) throws Exception {
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_http._tcp.local.", new TVClient.Listener());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeConnection() {
        StringRequest request = StringRequest.newBuilder().setVal("Turn on").build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getVal());
    }

}
