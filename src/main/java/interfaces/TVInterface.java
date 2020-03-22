package interfaces;

import java.util.ArrayList;

public interface TVInterface {
    public String turnOn();
    public void turnOff();
    public void mode();
    public boolean connnected(boolean turnOn);
    public int brightness();
    public boolean musicMode();
    public ArrayList<String> channelList();
}
