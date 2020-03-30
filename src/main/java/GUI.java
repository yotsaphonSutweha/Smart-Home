import java.awt.*;

public class GUI {
    public static void main(String args[]) {
        GUIClient client = new GUIClient();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        client.setLocation(dim.width/2-client.getSize().width/2, dim.height/2-client.getSize().height/2);
        client.setVisible(true);
    }
}
