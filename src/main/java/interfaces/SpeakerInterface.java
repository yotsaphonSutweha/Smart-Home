package interfaces;

import java.util.ArrayList;

public interface SpeakerInterface {
    public String turnOn();
    public ArrayList<String> availableInputs();
    public void setConnectedToTv(boolean connectedToTv);
    public boolean connectedToTV();
    public void turnOff();
    public void setDeviceList(ArrayList<String> arr);
    public ArrayList<String> getDeviceList();
    public void setVolume(int volume);
    public int getVolume();
    public void turnRadioOn(boolean radioOn);
    public boolean getRadioOn();
}

