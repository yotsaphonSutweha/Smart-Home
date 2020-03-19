import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.project.smarthome.tv.StringRequest;
import io.grpc.project.smarthome.tv.StringResponse;
import io.grpc.project.smarthome.tv.TvServiceGrpc;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GUIClient extends JFrame {

    private JPanel rootPanel;
    private JButton turnOnButton;
    private JPanel buttons;
    private JButton turnOffButton;
    private JPanel channel;
    private JTextField channelTextField;
    private JPanel tvStatus;
    private JLabel statusLabel;
    private JRadioButton onButton;
    private JLabel channelLabel;
    private JLabel volumnLabel;
    private JLabel Mode;
    private JButton changeChannelBtn;
    private JTextField volumnTextField;
    private JButton changeVolumnButton;
    private static int port  = 0;
    private static String name = "";
    private static TvServiceGrpc.TvServiceBlockingStub blockingStub;
    //    private static SmartHomeServiceGrpc.SmartHomeServiceFutureStub asyncStub;
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Port" + port);

        add(rootPanel);
        setTitle("Control");
        setSize(500, 500);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        blockingStub = TvServiceGrpc.newBlockingStub(channel);

        turnOnBtn();
    }

    public void turnOnBtn() {
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOn();
            }
        });
    }


    public static void turnOn() {
        StringRequest request = StringRequest.newBuilder().setVal("Turn on").build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getVal());
    }

}
