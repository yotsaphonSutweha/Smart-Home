package objects;

import interfaces.TVInterface;

import java.util.ArrayList;

public class TV implements TVInterface {

    public TV() {

    }

    @Override
    public String turnOn() {
        return "is On";
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off tv...");
    }

    @Override
    public void mode() {

    }

    @Override
    public boolean connnected(boolean turnOn) {
        if (turnOn) {
            return true;
        }
        return false;
    }

    @Override
    public int brightness() {
        return 0;
    }

    @Override
    public boolean musicMode() {
        return false;
    }

    @Override
    public ArrayList<String> channelList() {
        ArrayList<String> channelList = new ArrayList<>();
        channelList.add("Disney");
        channelList.add("Cartoon Network");
        channelList.add("Music");
        return channelList;
    }
}
