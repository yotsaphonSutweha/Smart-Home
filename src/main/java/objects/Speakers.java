package objects;

import interfaces.SpeakerInterface;

import java.util.ArrayList;

public class Speakers implements SpeakerInterface {
    private int volume;
    private ArrayList<String> deviceList;
    public Speakers() {
        volume = 0;
    }
    @Override
    public String turnOn() {
        return "is On";
    }

    @Override
    public ArrayList<String> availableInputs() {
        ArrayList<String> availableInputList = new ArrayList<>();
        availableInputList.add("HDMI");
        availableInputList.add("VGD");
        availableInputList.add("Bluetooth");
        return availableInputList;
    }

    @Override
    public void turnOff() {

    }

    @Override
    public boolean connected() {
        return false;
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
    public void turnRadioOn() {

    }

    @Override
    public void turnRadioOff() {

    }

    @Override
    public boolean musicMode() {
        return false;
    }
}
