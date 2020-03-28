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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GUIClient extends JFrame {

    private JPanel rootPanel;
    private JButton turnOnButton;
    private JPanel buttons;
    private JButton turnOffButton;
    private JPanel channel;
    private JPanel tvStatus;
    private JLabel statusLabel;
    private JPanel status;
    private JTextPane onText;
    private JButton displayChannelList;
    private JTextPane channelsTextPane;
    private JButton liveShowBtn;
    private JTextField volumeTextField;
    private JButton changeVolumeBtn;
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
    private static int pythonClientPort = 0;
    private static String pythonClientAddress = "";



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
            if (serviceEvent.getType().equals("_curtain._tcp.local.")){
                pythonClientPort = serviceEvent.getInfo().getPort();
                pythonClientAddress = serviceEvent.getInfo().getHostAddresses()[0];
            }
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
        turnOffButton.setVisible(false);
        displayChannelList.setVisible(false);
        liveShowBtn.setVisible(false);
        volumeTextField.setVisible(false);
        changeVolumeBtn.setVisible(false);

        ManagedChannel tvChannel = manageChannel(tvServerName, tvPort);
        blockingStub = TvServiceGrpc.newBlockingStub(tvChannel);
        asyncStub = TvServiceGrpc.newStub(tvChannel);
//
//        ManagedChannel lightsChannel = manageChannel(lightsServerName, lightsPort);
//        lightsServiceBlockingStub = LightsServiceGrpc.newBlockingStub(lightsChannel);
//        lightsServiceAsyncStub = LightsServiceGrpc.newStub(lightsChannel);

        turnOnBtn();
        turnOffBtn();
        displayChannels();
        liveShowContentBtn();
        changeVolume();
//        turnOnBtn();
//        displayChannelList();
//        increaseVolume();
//        showLiveContent();

//        turnOnLights();
//        displayLightsMode();
//        lightCombiner();
//        setLightsMode();

//        System.out.println("Python client is running at " + pythonClientPort + " with address " + pythonClientAddress);
//
//        openCurtainCommand(pythonClientAddress, pythonClientPort);
//        closeCurtainCommand(pythonClientAddress, pythonClientPort);
//        adjustCurtainWidthAndHeight(pythonClientAddress, pythonClientPort);

    }

    public void turnOnBtn() {
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOn();
                displayChannelList.setVisible(true);
                liveShowBtn.setVisible(true);
                volumeTextField.setVisible(true);
                changeVolumeBtn.setVisible(true);
            }
        });
    }

    public void turnOffBtn() {
        turnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOff();
                displayChannelList.setVisible(false);
                liveShowBtn.setVisible(false);
                volumeTextField.setVisible(false);
                changeVolumeBtn.setVisible(false);
            }
        });
    }

    public void displayChannels() {
        displayChannelList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChannelList();
            }
        });
    }

    public void liveShowContentBtn() {
        liveShowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLiveContent();
            }
        });
    }

    public void changeVolume() {
        changeVolumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String volume = volumeTextField.getText();
                if (volume == null) {
                    JOptionPane.showMessageDialog(null, "Please provide the volume properly");
                } else {
                    increaseVolume(Integer.parseInt(volume));
                }
            }
        });
    }




    //---------------------- Curtain commands ------------------------------

    public void openCurtainCommand(String pythonClientAddress, int pythonClientPort) {
        try {
            Socket clientSocket = new Socket(pythonClientAddress, pythonClientPort);
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
            printWriter.write("Open");
            printWriter.flush();
            printWriter.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("Failed to establish connection");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed IO");
            e.printStackTrace();
        }
    }

    public void closeCurtainCommand(String pythonClientAddress, int pythonClientPort) {
        try {
            Socket clientSocket = new Socket(pythonClientAddress, pythonClientPort);
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
            printWriter.write("Close");
            printWriter.flush();
            printWriter.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("Failed to establish connection");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed IO");
            e.printStackTrace();
        }
    }

    public void adjustCurtainWidthAndHeight(String pythonClientAddress, int pythonClientPort) {
        try {
            Socket clientSocket = new Socket(pythonClientAddress, pythonClientPort);
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
            printWriter.write("4,7");
            printWriter.flush();
            printWriter.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("Failed to establish connection");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed IO");
            e.printStackTrace();
        }
    }

    //---------------------- End of Curtain commands ------------------------------


    //------------------------ TV Commands -------------------------
    public void showLiveContent() {
        ArrayList<String> liveContents = new ArrayList<>();
       StreamObserver<StringResponse> responseObserver = new StreamObserver<StringResponse>() {
           @Override
           public void onNext(StringResponse value) {
               System.out.println(value.getStringResponseValue());
               liveContents.add(value.getStringResponseValue());
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
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil is 19").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil is a good student").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil becomes the greatest engineer").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil marries with a girl named Sandra").build());
            threadSleep();
            request.onCompleted();
        } catch (RuntimeException e) {
            // Cancel RPC
            request.onError(e);
            throw e;
        }

        System.out.println("Live contents " + liveContents.size());

        for(String content : liveContents) {
            JOptionPane.showMessageDialog(null, content);
        }

    }

    public void increaseVolume(int volume) {
        StreamObserver<IntResponse> responseObserver = new StreamObserver<IntResponse>() {
            @Override
            public void onNext(IntResponse value) {
                System.out.println("The current volume is " + value.getNumOutput());
                JOptionPane.showMessageDialog(null, "Current TV volume is " + value.getNumOutput());
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
            request.onNext(IntRequest.newBuilder().setNumInput(volume).build());
            threadSleep();
            request.onCompleted();
        } catch (RuntimeException e) {
            // Cancel RPC
            request.onError(e);
            throw e;
        }
    }


    public void turnOn() {
        BooleanRequest request = BooleanRequest.newBuilder().setBooleanRequestValue(true).build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getStringResponseValue());
        onText.setText("TV: " + response.getStringResponseValue());
        turnOnButton.setVisible(false);
        turnOffButton.setVisible(true);
    }

    public void turnOff() {
        BooleanRequest request = BooleanRequest.newBuilder().setBooleanRequestValue(false).build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getStringResponseValue());
        onText.setText("TV: " + response.getStringResponseValue());
        turnOnButton.setVisible(true);
        turnOffButton.setVisible(false);
    }

    public void displayChannelList() {

        ArrayList<String> ch = new ArrayList<>();

        StringRequest request = StringRequest.newBuilder().setStringRequestValue("Display channels").build();

        StreamObserver<StringResponse> responseObserver = new StreamObserver<StringResponse>() {
            @Override
            public void onNext(StringResponse value) {
                System.out.println(value.getStringResponseValue());
                ch.add(value.getStringResponseValue());
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
        String channelDisplay = "Available channels include: " + ch.get(0) + ", " + ch.get(1) + ", and " + ch.get(2);
        channelsTextPane.setText(channelDisplay);
    }
    //----------------End of TV commands-----------------------------------

    //----------jmdns and grpc registration-------------

    public void registerJmdns(){
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_http._tcp.local.", new GUIClient.Listener());
            jmdns.addServiceListener("_lights._tcp.local.", new GUIClient.Listener());
            jmdns.addServiceListener("_curtain._tcp.local.", new GUIClient.Listener());
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

    //---------------------------------------------------------

    // Lights server functions

    public void turnOnLights() {
        io.grpc.project.smarthome.lights.BooleanRequest request = io.grpc.project.smarthome.lights.BooleanRequest.newBuilder().setBooleanValue(true).build();
        io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.lightSwitch(request);
        System.out.println(response.getStringResponseValue());
    }

    public void displayLightsMode() {
        io.grpc.project.smarthome.lights.StringRequest request = io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue("Display lights modes").build();
        StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseStreamObserver = new StreamObserver<io.grpc.project.smarthome.lights.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.lights.StringResponse value) {
                System.out.println(value.getStringResponseValue());
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
                System.out.println("Light is now set to" + value.getStringResponseValue());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Light combiner on completed");
            }
        });

        requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue("Green").build());
        requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue("Red").build());
        threadSleep();
        requestStreamObserver.onCompleted();
    }

    public void setLightsMode() {
        io.grpc.project.smarthome.lights.Modes request =  io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Modes.Mode.LIGHT).build();
        try {
            io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.setLightMode(request);
            System.out.println("Light mode " + response.getStringResponseValue());
        } catch (StatusRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAvailableSpeakersInputs() {
        StringRequest request = StringRequest.newBuilder().setStringRequestValue("Display available inputs for speakers").build();
        StringResponse responses = blockingStub.displayInputsSpeakersCommand(request);
        System.out.println("Available speakers inputs " + responses.getStringResponseValue());
    }

    public void musicStreaming() {
        StringRequest request = StringRequest.newBuilder().setStringRequestValue("Play Get Down on Saturday night").build();
        StringResponse response = blockingStub.musicStreamingSpeakersCommand(request);
        System.out.println(response);

    }
}
