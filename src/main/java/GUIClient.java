import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.project.smarthome.curtain.CurtainServiceGrpc;
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
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

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
    private JButton liveShowBtn;
    private JTextField volumeTextField;
    private JButton changeVolumeBtn;
    private JTextPane channelListTextPane;
    private JButton displaySpeakersInputsBtn;
    private JButton playMusicBtn;
    private JLabel volumeLabel;
    private static int tvPort  = 0;
    private static String tvServerHost = "";
    private static int lightsPort  = 0;
    private static String lightsServerHost = "";
    private static TvServiceGrpc.TvServiceBlockingStub blockingStub;
    private static TvServiceGrpc.TvServiceStub asyncStub;
    private static TvServiceGrpc.TvServiceFutureStub futureStub;
    private static LightsServiceGrpc.LightsServiceBlockingStub lightsServiceBlockingStub;
    private static LightsServiceGrpc.LightsServiceStub lightsServiceAsyncStub;
    private static LightsServiceGrpc.LightsServiceFutureStub lightsServiceFutureStub;
    private static CurtainServiceGrpc.CurtainServiceBlockingStub curtainServiceBlockingStub;
    private static int pythonCurtainPort = 0;
    private static String pythonCurtainServerHost = "";
    private SpeakersGUI speakersGUI;
    private LightsGUI lightsGUI;
    private CurtainGUI curtainGUI;



    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceRemoved(ServiceEvent serviceEvent) {
            System.out.println("Service removed: " + serviceEvent.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent serviceEvent) {
            System.out.println("Service resolved: " + serviceEvent.getInfo());
            if (serviceEvent.getName().equals("tv")) {
                tvPort = serviceEvent.getInfo().getPort();
                tvServerHost = "localhost";
            } else if (serviceEvent.getName().equals("lights")) {
                lightsPort = serviceEvent.getInfo().getPort();
                lightsServerHost = "localhost";
            } else if (serviceEvent.getName().equals("curtain")){
                pythonCurtainPort = serviceEvent.getInfo().getPort();
                pythonCurtainServerHost = "localhost";
            }
        }
    }

    public GUIClient () {
        registerJmdns();
        threadSleep();

        System.out.println("TV Port: " + tvPort);
        System.out.println("Lights Port: " + lightsPort);
        System.out.println("Curtain Port: " + pythonCurtainPort);

        add(rootPanel);
        setTitle("TV GUI");
        setSize(500, 500);

        // Display speakers GUI
        speakersGUI = new SpeakersGUI();
        lightsGUI = new LightsGUI();
        curtainGUI = new CurtainGUI();
        lightsGUI.setVisible(true);
        curtainGUI.setVisible(true);

        turnOffButton.setVisible(false);
        displayChannelList.setVisible(false);
        liveShowBtn.setVisible(false);
        volumeTextField.setVisible(false);
        changeVolumeBtn.setVisible(false);
        displaySpeakersInputsBtn.setVisible(false);
        playMusicBtn.setVisible(false);

        try {
            ManagedChannel tvChannel = manageChannel(tvServerHost, tvPort);
            blockingStub = TvServiceGrpc.newBlockingStub(tvChannel);
            asyncStub = TvServiceGrpc.newStub(tvChannel);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect PORT for Tv server");
        }

        try {
            ManagedChannel lightsChannel = manageChannel(lightsServerHost, lightsPort);
            lightsServiceBlockingStub = LightsServiceGrpc.newBlockingStub(lightsChannel);
            lightsServiceAsyncStub = LightsServiceGrpc.newStub(lightsChannel);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect PORT for Lights server");
            e.printStackTrace();
        }

        try {
            ManagedChannel curtainChannel = manageChannel(pythonCurtainServerHost, pythonCurtainPort);
            curtainServiceBlockingStub = CurtainServiceGrpc.newBlockingStub(curtainChannel);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect PORT for Curtain server");
            e.printStackTrace();
        }

        turnOnBtn();
        turnOffBtn();
        displayChannels();
        liveShowContentBtn();
        changeVolume();
        displaySpeakersInputs();
        playMusicBtn();
        lightSwitch();
        displayLightsModeBtn();
        lightsCombinerBtn();
        lightsModeBtn();
        openCurtainBtn();
        closeCurtainBtn();
        adjustCurtainWidthHeightBtn();

//        turnOnBtn()
    }

    //----------jmdns and grpc registration-------------

    public void registerJmdns(){
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_tvserver._tcp.local.", new GUIClient.Listener());
            jmdns.addServiceListener("_lightserver._tcp.local.", new GUIClient.Listener());
            jmdns.addServiceListener("_curtainserver._tcp.local.", new GUIClient.Listener());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
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


    public void turnOnBtn() {
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOn();
                displayChannelList.setVisible(true);
                liveShowBtn.setVisible(true);
                volumeTextField.setVisible(true);
                changeVolumeBtn.setVisible(true);
                speakersGUI.setVisible(true);
                displaySpeakersInputsBtn.setVisible(true);
                playMusicBtn.setVisible(true);
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
                displaySpeakersInputsBtn.setVisible(false);
                playMusicBtn.setVisible(false);
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

    public void displaySpeakersInputs() {
        displaySpeakersInputsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAvailableSpeakersInputs();
            }
        });
    }

    public void playMusicBtn() {
        playMusicBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicStreaming();
            }
        });
    }

    public void lightSwitch() {
        lightsGUI.getSwitchBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lightsGUI.getLightsSwitchTextPane().getText().equalsIgnoreCase("Lights are off")) {
                    turnOnLights();
                    setLightsMode("LIGHT");
                } else if (lightsGUI.getLightsSwitchTextPane().getText().equalsIgnoreCase("Lights are on")) {
                    turnOffLights();
                }
            }
        });
    }

    public void displayLightsModeBtn() {
        lightsGUI.getDisplayLightsModesBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLightsMode();
            }
        });
    }

    public void lightsCombinerBtn() {
        lightsGUI.getCombineLightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String color1 = lightsGUI.getLightColorTextField1().getText();
                String color2 = lightsGUI.getLightColorTextField2().getText();
                if (color1.isEmpty() || color2.isEmpty()) {
                    lightsGUI.getLightsColorTextPane().setText("Color: White (Please provide two colors to use this functionality)");
                } else {
                    lightCombiner(color1, color2);
                }
            }
        });
    }

    public void lightsModeBtn() {
        lightsGUI.getSetLightsModeBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = lightsGUI.getLightsModeComboBox().getSelectedItem().toString();
                setLightsMode(value);
            }
        });
    }

    public void openCurtainBtn() {
        curtainGUI.getOpenCurtainBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCurtain();
            }
        });
    }

    public void closeCurtainBtn() {
        curtainGUI.getCloseCurtainBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeCurtain();
            }
        });
    }

    public void adjustCurtainWidthHeightBtn() {
        curtainGUI.getAdjustWidthHeightBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!curtainGUI.getWidthTextField().getText().isEmpty() && !curtainGUI.getHeightTextField().getText().isEmpty()) {
                        float width = Float.parseFloat(curtainGUI.getWidthTextField().getText());
                        float height = Float.parseFloat(curtainGUI.getHeightTextField().getText());
                        if ((width > 100.00) || (height > 100.00)) {
                            JOptionPane.showMessageDialog(null, "The width and height of the curtain should be below 100.00 cm.");
                        } else {
                            adjustWidthAndHeightOfCurtain(width, height);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Width and height must be provided!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }

    //---------------------- Curtain commands ------------------------------

    public void openCurtain() {
        io.grpc.project.smarthome.curtain.StringRequest request = io.grpc.project.smarthome.curtain.StringRequest.newBuilder().setStringRequestValue("Open").build();
        io.grpc.project.smarthome.curtain.StringResponse response = curtainServiceBlockingStub.open(request);
        System.out.println(response.getStringResponseValue());
        curtainGUI.getCurtainStatusTextPane().setText(response.getStringResponseValue());
        curtainGUI.getWidthTextPane().setText("Width: 100.00 cm.");
        curtainGUI.getHeightTextPane().setText("Height: 100.00 cm.");
    }

    public void closeCurtain() {
        io.grpc.project.smarthome.curtain.StringRequest request = io.grpc.project.smarthome.curtain.StringRequest.newBuilder().setStringRequestValue("Close").build();
        io.grpc.project.smarthome.curtain.StringResponse response = curtainServiceBlockingStub.close(request);
        System.out.println(response.getStringResponseValue());
        curtainGUI.getCurtainStatusTextPane().setText(response.getStringResponseValue());
        curtainGUI.getWidthTextPane().setText("Width: 0.00 cm.");
        curtainGUI.getHeightTextPane().setText("Height: 0.00 cm.");
    }

    public void adjustWidthAndHeightOfCurtain(float width, float height) {
        io.grpc.project.smarthome.curtain.HeightAndWidth request = io.grpc.project.smarthome.curtain.HeightAndWidth.newBuilder().setWidth(width).setHeight(height).build();
        io.grpc.project.smarthome.curtain.StringResponse response = curtainServiceBlockingStub.adjustHeightAndWidth(request);
        String[] msg = response.getStringResponseValue().split(",");
        curtainGUI.getCurtainStatusTextPane().setText("Curtain: Open");
        curtainGUI.getWidthTextPane().setText("Width: " + msg[0] + " cm.");
        curtainGUI.getHeightTextPane().setText("Height: " + msg[1] + " cm.");
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
               System.out.println("Error: " + t.getMessage());
               t.printStackTrace();
           }

           @Override
           public void onCompleted() {
               System.out.println("Live content stream completed");
           }
       };
       StreamObserver<StringRequest> request = asyncStub.liveContent(responseObserver);
        try {
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil is 19").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil is a good student").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil becomes the greatest engineer").build());
            request.onNext(StringRequest.newBuilder().setStringRequestValue("Bil marries with a girl named Sandra").build());
            threadSleep();
        } catch (RuntimeException e) {
            // Cancel RPC
            System.out.println("RPC failed: " + e.getMessage());
            e.printStackTrace();
            request.onError(e);
            throw e;
        }
        request.onCompleted();
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
                speakersGUI.getVolumeTextPane().setText("Current Volume: " + value.getNumOutput());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Increase volume stream completed");
            }
        };
        StreamObserver<IntRequest> request = asyncStub.increaseVolume(responseObserver);
        try {
            request.onNext(IntRequest.newBuilder().setNumInput(volume).build());
            threadSleep();
        } catch (RuntimeException e) {
            // Cancel RPC
            System.out.println("RPC failed: " + e.getMessage());
            e.printStackTrace();
            request.onError(e);
            throw e;
        }
        request.onCompleted();
    }


    public void turnOn() {
        BooleanRequest request = BooleanRequest.newBuilder().setBooleanRequestValue(true).build();
        try {
            StringResponse response = blockingStub.turnOn(request);
            System.out.println("TV" + response.getStringResponseValue());
            onText.setText("TV: " + response.getStringResponseValue());
            speakersGUI.getSpeakOn().setText("Speakers " + response.getStringResponseValue2());
            turnOnButton.setVisible(false);
            turnOffButton.setVisible(true);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }

    }

    public void turnOff() {
        BooleanRequest request = BooleanRequest.newBuilder().setBooleanRequestValue(false).build();
        try {
            StringResponse response = blockingStub.turnOn(request);
            System.out.println(response.getStringResponseValue());
            onText.setText("TV: " + response.getStringResponseValue());
            speakersGUI.getSpeakOn().setText("Speakers " + response.getStringResponseValue2());
            speakersGUI.getMusicStreamingTextPane().setText("");
            speakersGUI.getMusicStreamingTextPane2().setText("");
            speakersGUI.getMusicStreamingTextPane3().setText("");
            speakersGUI.getMusicStreamingTextPane4().setText("");
            speakersGUI.getMusicStreamingTextPane5().setText("");
            speakersGUI.getMusicStreamingTextPane6().setText("");
            speakersGUI.getMusicStreamingTextPane7().setText("");
            speakersGUI.getMusicStreamingTextPane8().setText("");
            speakersGUI.getMusicStreamingTextPane9().setText("");
            speakersGUI.getVolumeTextPane().setText("");
            turnOnButton.setVisible(true);
            turnOffButton.setVisible(false);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
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
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("On completed");
            }
        };
        try {
            asyncStub.displayChannelList(request, responseObserver);
            threadSleep();
            String channelDisplay = "Available channels include: " + ch.get(0) + ", " + ch.get(1) + ", and " + ch.get(2);
            System.out.println(channelDisplay);
            channelListTextPane.setText(channelDisplay);
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }
    //----------------End of TV commands-----------------------------------


    // Lights server functions

    public void turnOnLights() {
        io.grpc.project.smarthome.lights.BooleanRequest request = io.grpc.project.smarthome.lights.BooleanRequest.newBuilder().setBooleanValue(true).build();
        try {
            io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.lightSwitch(request);
            System.out.println(response.getStringResponseValue());
            lightsGUI.getLightsSwitchTextPane().setText(response.getStringResponseValue());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }

    public void turnOffLights() {
        io.grpc.project.smarthome.lights.BooleanRequest request = io.grpc.project.smarthome.lights.BooleanRequest.newBuilder().setBooleanValue(false).build();
        try {
            io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.lightSwitch(request);
            System.out.println(response.getStringResponseValue());
            lightsGUI.getLightsSwitchTextPane().setText(response.getStringResponseValue());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }

    public void displayLightsMode() {
        ArrayList<String> arr = new ArrayList<>();
        io.grpc.project.smarthome.lights.StringRequest request = io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue("Display lights modes").build();
        StreamObserver<io.grpc.project.smarthome.lights.StringResponse> responseStreamObserver = new StreamObserver<io.grpc.project.smarthome.lights.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.lights.StringResponse value) {
                System.out.println(value.getStringResponseValue());
                arr.add(value.getStringResponseValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Lights mode on completed");
            }
        };

        try {
            lightsServiceAsyncStub.displayLightModes(request, responseStreamObserver);
            threadSleep();
            if (arr.size() > 0) {
                String tmp = "Available lights modes: " + arr.get(0) + ", "+ arr.get(1) + ", " + arr.get(2);
                lightsGUI.getAvailableLightsMode().setText(tmp);
            } else {
                String tmp = "No available lights mode";
                lightsGUI.getAvailableLightsMode().setText(tmp);
            }
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }

    public void lightCombiner(String color1, String color2) {
        StreamObserver<io.grpc.project.smarthome.lights.StringRequest> requestStreamObserver = lightsServiceAsyncStub.lightCombiner(new StreamObserver<io.grpc.project.smarthome.lights.StringResponse>() {
            @Override
            public void onNext(io.grpc.project.smarthome.lights.StringResponse value) {
                System.out.println("Light is now set to" + value.getStringResponseValue());
                lightsGUI.getLightsColorTextPane().setText("Colors: " + value.getStringResponseValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Light combiner on completed");
            }
        });
        try {
            requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue(color1).build());
            requestStreamObserver.onNext(io.grpc.project.smarthome.lights.StringRequest.newBuilder().setStringRequestValue(color2).build());
            threadSleep();
        } catch (RuntimeException e) {
            // Cancel RPC
            System.out.println("RPC failed: " + e.getMessage());
            e.printStackTrace();
            requestStreamObserver.onError(e);
            throw e;
        }
        requestStreamObserver.onCompleted();
    }

    public void setLightsMode(String value) {
        io.grpc.project.smarthome.lights.Modes request = io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Mode.LIGHT).build();
        if (value.equalsIgnoreCase("DISCO")) {
            request =  io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Mode.DISCO).build();
        } else if (value.equalsIgnoreCase("DARK")) {
            request =  io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Mode.DARK).build();
        } else {
            request =  io.grpc.project.smarthome.lights.Modes.newBuilder().setDetail(Mode.LIGHT).build();
        }
        try {
            io.grpc.project.smarthome.lights.StringResponse response = lightsServiceBlockingStub.setLightMode(request);
            System.out.println("Light mode " + response.getStringResponseValue());
            lightsGUI.getLightsModeTextPane().setText("Mode: " + response.getStringResponseValue());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }

    //---------------Speakers server functions------------------
    public void displayAvailableSpeakersInputs() {
        StringRequest request = StringRequest.newBuilder().setStringRequestValue("Display available inputs for speakers").build();
        try {
            StringResponse responses = blockingStub.displayInputsSpeakersCommand(request);
            System.out.println("Available speakers inputs " + responses.getStringResponseValue());
            speakersGUI.getAvailableInputs().setText("Available speakers inputs " + responses.getStringResponseValue());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }

    public void musicStreaming() {
        StringTokenizer st;
        ArrayList<String> arr = new ArrayList<>();
        StringRequest request = StringRequest.newBuilder().setStringRequestValue("Play Get Down on Saturday night").build();
        try {
            StringResponse response = blockingStub.musicStreamingSpeakersCommand(request);
            st = new StringTokenizer(response.getStringResponseValue(),  ",");
            while (st.hasMoreElements()) {
                arr.add(st.nextToken());
            }
            speakersGUI.getMusicStreamingTextPane().setText("Playing Get Down on Saturday night...");
            speakersGUI.getMusicStreamingTextPane2().setText(arr.get(0));
            speakersGUI.getMusicStreamingTextPane3().setText(arr.get(1));
            speakersGUI.getMusicStreamingTextPane4().setText(arr.get(2));
            speakersGUI.getMusicStreamingTextPane5().setText(arr.get(3));
            speakersGUI.getMusicStreamingTextPane6().setText(arr.get(4));
            speakersGUI.getMusicStreamingTextPane7().setText(arr.get(5));
            speakersGUI.getMusicStreamingTextPane8().setText(arr.get(6));
            speakersGUI.getMusicStreamingTextPane9().setText(arr.get(7));
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
            e.printStackTrace();
        }
    }
    //---------------End of Speakers server functions------------------
}
