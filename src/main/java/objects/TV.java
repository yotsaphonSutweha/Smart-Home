package objects;

import interfaces.TVInterface;

public class TV implements TVInterface {

    public TV() {

    }

    @Override
    public String turnOn() {
        return "Turing on tv...";
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
}
