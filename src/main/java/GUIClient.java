import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.project.smarthome.lights.LightsServiceGrpc;
import io.grpc.project.smarthome.lights.Modes;
import io.grpc.project.smarthome.tv.*;
import io.grpc.stub.StreamObserver;
import io.grpc.project.smarthome.lights.Modes.Mode;
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
    private static int tvPort  = 0;
    private static String tvServerName = "";
    private static int lightsPort  = 0;
    private static String lightsServerName = "";
    private static TvServiceGrpc.TvServiceBlockingStub blockingStub;
    private static TvServiceGrpc.TvServiceStub asyncStub;
    private static TvServiceGrpc.TvServiceFutureStub futureStub;
    private static LightsServiceGrpc.LightsServiceBlockingStub lightsServiceBlockingStub;
    private static LightsServiceGrpc.LightsServiceStub lightsServiceAsyncStub;
    private static LightsServiceGrpc.LightsServiceFutureStub lightsServiceFutureStub;


    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            if (serviceEvent.getType().equals("_http._tcp.local.")) {
                tvPort = serviceEvent.getInfo().getPort();
                tvServerName = serviceEvent.getName();
            } else if (serviceEvent.getType().equals("_lights._tcp.local.")) {
                lightsPort = serviceEvent.getInfo().getPort();
                lightsServerName = serviceEvent.getName();
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

    public GUIClient () {
        registerJmdns();

        threadSleep();

        System.out.println("TV Port " + tvPort);
        System.out.println("Lights Port " + lightsPort);
        add(rootPanel);
        setTitle("Control");
        setSize(500, 500);

//        ManagedChannel tvChannel = manageChannel(tvServerName, tvPort);
//        blockingStub = TvServiceGrpc.newBlockingStub(tvChannel);
//        asyncStub = TvServiceGrpc.newStub(tvChannel);

        ManagedChannel lightsChannel = manageChannel(lightsServerName, lightsPort);
        lightsServiceBlockingStub = LightsServiceGrpc.newBlockingStub(lightsChannel);
        lightsServiceAsyncStub = LightsServiceGrpc.newStub(lightsChannel);

//        turnOnBtn();
//        displayChannelList();
//        increaseVolume();
//        showLiveContent();

//        turnOnLights();
//        displayLightsMode();
//        lightCombiner();
        setLightsMode();
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
            jmdns.addServiceListener("_lights._tcp.local.", new GUIClient.Listener());
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

    // Lights server functions

    public void turnOnLights() {
        io.grpc.project.smarthome.lights.BooleanRequest request = io.grpc.project.smarthome.lights.BooleanRequest.newBuilder().setVal(true).build();
        io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.lightSwitch(request);
        System.out.println(response.getVal());
    }

    public void displayLightsMode() {
        io.grpc.project.smarthome.lights.StringRequest request = io.grpc.project.smarthome.lights.StringRequest.newBuilder().setVal("Display lights modes").build();
        StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseStreamObserver = new StreamObserver<io.grpc.project.smarthome.lights.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.lights.StringResponse value) {
                System.out.println(value.getVal());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Lights mode on completed");
            }
        };
        lightsServiceAsyncStub.displayLightModes(request, responseStreamObserver);
        threadSleep();
    }

    public void lightCombiner() {
        StreamObserver<io.grpc.project.smarthome.lights.StringRequest> requestStreamObserver = lightsServiceAsyncStub.lightCombiner(new StreamObserver<io.grpc.project.smarthome.lights.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.lights.StringResponse value) {
                System.out.println("Light is now set to" + value.getVal());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Light combiner on completed");
            }
        });

        requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setVal("Green").build());
        requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setVal("Red").build());
        threadSleep();
        requestStreamObserver.onCompleted();
    }

    public void setLightsMode() {
        io.grpc.project.smarthome.lights.Modes request =  io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Modes.Mode.LIGHT).build();
        try {
            io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.setLightMode(request);
            System.out.println("Light mode " + response.getVal());
        } catch (StatusRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}
