import io.grpc.project.smarthome.speakers.SpeakersServiceGrpc;
import io.grpc.project.smarthome.tv.StringRequest;
import io.grpc.project.smarthome.tv.StringResponse;
import io.grpc.project.smarthome.tv.TVClient;
import io.grpc.project.smarthome.tv.TvServiceGrpc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceImplBase;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceFutureStub;
import io.grpc.project.smarthome.tv.TvServiceGrpc.TvServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class UserInterface extends Application {
    static int port  = 0;
    private static TvServiceBlockingStub blockingStub;
    //    private static SmartHomeServiceGrpc.SmartHomeServiceFutureStub asyncStub;
    private static TvServiceFutureStub futureStub;

    public static class Listener implements ServiceListener {
        @Override
        public void serviceAdded(ServiceEvent serviceEvent) {
            System.out.println("Service added: " + serviceEvent.getInfo());
            port = serviceEvent.getInfo().getPort();
//            if (serviceEvent.getName().equals("localhost")) {
//                System.out.println(serviceEvent.getName());
//                ManagedChannel channel = ManagedChannelBuilder.forAddress(serviceEvent.getName(), serviceEvent.getInfo().getPort()).usePlaintext().build();
//                blockingStub = TvServiceGrpc.newBlockingStub(channel);
//                turnOn();
//            }
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


    public static void main(String[] args) {
        try {
            // create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // add service listener
            jmdns.addServiceListener("_http._tcp.local.", new UserInterface.Listener());

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
        launch(args);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setHeight(500);
        primaryStage.setWidth(1000);

        VBox parent = new VBox();

        Label label1 = new Label("TV control");

        parent.getChildren().addAll(label1);

        Scene scene1 = new Scene(parent);

        scene1.getStylesheets().add("stylesheets/styles.css");

        primaryStage.setScene(scene1);

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void turnOn() {
        StringRequest request = StringRequest.newBuilder().setVal("Turn on").build();
        StringResponse response = blockingStub.turnOn(request);
        System.out.println(response.getVal());
    }

}
