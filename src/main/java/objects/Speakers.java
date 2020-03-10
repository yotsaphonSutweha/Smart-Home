package objects;

import interfaces.SpeakerInterface;

public class Speakers implements SpeakerInterface {
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public boolean connected() {
        return false;
    }

    @Override
    public int increaseVolumn() {
        return 0;
    }

    @Override
    public int lowerVolumn() {
        return 0;
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
