package interfaces;

import java.util.ArrayList;

public interface SpeakerInterface {
    public String turnOn();
    public ArrayList<String> availableInputs();
    public void turnOff();
    public boolean connected();
    public void setDeviceList(ArrayList<String> arr);
    public ArrayList<String> getDeviceList();
    public void setVolume(int volume);
    public int getVolume();
    public void turnRadioOn();
    public void turnRadioOff();
    public boolean musicMode();

}

