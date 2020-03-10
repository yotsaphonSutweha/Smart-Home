package objects;

import interfaces.TVInterface;

public class TV implements TVInterface {

    public TV() {

    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public int increaseVolume() {
        return 0;
    }

    @Override
    public int lowerVolume() {
        return 0;
    }

    @Override
    public void mode() {

    }

    @Override
    public boolean connnected() {
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
