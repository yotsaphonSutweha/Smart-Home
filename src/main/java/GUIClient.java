import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.project.smarthome.tv.*;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class GUIClient extends JFrame {

    private JPanel rootPanel;
    private JButton turnOnButton;
    private JPanel buttons;
    private JButton turnOffButton;
    private JPanel channel;
    private JTextField channelTextField;
    private JPanel tvStatus;
    private JLabel statusLabel;
    private JLabel channelLabel;
    private JLabel volumnLabel;
    private JLabel Mode;
    private JButton changeChannelBtn;
    private JTextField volumnTextField;
    private JButton changeVolumnButton;
    private JPanel status;
    private JTextPane onText;
    private static int port  = 0;
    private static String name = "";
    private static TvServiceGrpc.TvServiceBlockingStub blockingStub;
    private static TvServiceGrpc.TvServiceStub asyncStub;
    private static TvServiceGrpc.TvServiceFutureStub futureStub;


    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            port = serviceEvent.getInfo().getPort();
            name = serviceEvent.getName();
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

    public GUIClient () {
        registerJmdns();

        threadSleep();

        System.out.println("Port" + port);

        add(rootPanel);
        setTitle("Control");
        setSize(500, 500);

        ManagedChannel channel = manageChannel(name, port);
        blockingStub = TvServiceGrpc.newBlockingStub(channel);
        asyncStub = TvServiceGrpc.newStub(channel);
        turnOnBtn();
        displayChannelList();
        increaseVolume();
        showLiveContent();
    }

    public void turnOnBtn() {
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOn();
            }
        });
    }

    public void showLiveContent() {
       StreamObserver<StringResponse> responseObserver = new StreamObserver<StringResponse>() {
           @Override
           public void onNext(StringResponse value) {
               System.out.println(value.getVal());
           }

           @Override
           public void onError(Throwable t) {

           }

           @Override
           public void onCompleted() {

           }
       };

       StreamObserver<StringRequest> request = asyncStub.liveContent(responseObserver);
        try {

            request.onNext(StringRequest.newBuilder().setVal("Bil is 19").build());
            request.onNext(StringRequest.newBuilder().setVal("Bil is a good student").build());
            request.onNext(StringRequest.newBuilder().setVal("Bil becomes the greatest engineer").build());
            request.onNext(StringRequest.newBuilder().setVal("Bil marries with a girl named Sandra").build());
            request.onCompleted();

        } catch (RuntimeException e) {
            // Cancel RPC
            request.onError(e);
            throw e;
        }
    }

    public void increaseVolume() {
        StreamObserver<IntResponse> responseObserver = new StreamObserver<IntResponse>() {
            @Override
            public void onNext(IntResponse value) {
                System.out.println("The current volume is " + value.getVolume());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };

        StreamObserver<IntRequest> request = asyncStub.increaseVolume(responseObserver);

        try {

            request.onNext(IntRequest.newBuilder().setNumInput(1).build());
            request.onNext(IntRequest.newBuilder().setNumInput(3).build());
            request.onNext(IntRequest.newBuilder().setNumInput(5).build());
            request.onNext(IntRequest.newBuilder().setNumInput(2).build());
            request.onCompleted();
        } catch (RuntimeException e) {
            // Cancel RPC
            request.onError(e);
            throw e;
        }
    }


    public void turnOn() {
        BooleanRequest request = BooleanRequest.newBuilder().setVal(true).build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getVal());
        onText.setText("TV: " + response.getVal());
        turnOnButton.setVisible(false);

    }

    public void displayChannelList() {
        StringRequest request = StringRequest.newBuilder().setVal("Display channels").build();

        StreamObserver<StringResponse> responseObserver = new StreamObserver<StringResponse>() {
            @Override
            public void onNext(StringResponse value) {
                System.out.println(value.getVal());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("On completed");
            }
        };

        asyncStub.displayChannelList(request, responseObserver);

        threadSleep();
    }

    public void registerJmdns(){
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_http._tcp.local.", new GUIClient.Listener());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void threadSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ManagedChannel manageChannel(String name, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        return channel;
    }

}
