package objects;

import interfaces.SpeakerInterface;

import java.util.ArrayList;

/*
    This class is used to represents the speakers device
 */

public class Speakers implements SpeakerInterface {
    private int volume;
    private ArrayList<String> deviceList;
    private boolean radioOn;
    private boolean connectedToTv;

    public Speakers() {
        volume = 0;
        radioOn = false;
        connectedToTv = false;
    }
    @Override
    public String turnOn() {
        return "are On";
    }

    @Override
    public ArrayList<String> availableInputs() {
        ArrayList<String> availableInputList = new ArrayList<>();
        availableInputList.add("USB-B");
        availableInputList.add("USB-C");
        availableInputList.add("Micro-USB");
        availableInputList.add("Bluetooth");
        return availableInputList;
    }

    @Override
    public void setConnectedToTv(boolean connectedToTv) {
        this.connectedToTv = connectedToTv;
    }

    @Override
    public boolean connectedToTV() {
        return this.connectedToTv;
    }

    @Override
    public String turnOff() {
        return "are Off";
    }

    @Override
    public void setDeviceList(ArrayList<String> arr) {
        this.deviceList = arr;
    }

    @Override
    public ArrayList<String> getDeviceList() {
        return this.deviceList;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void turnRadioOn(boolean radioOn) {
        this.radioOn = radioOn;
    }

    @Override
    public boolean getRadioOn() {
        return this.radioOn;
    }

}
