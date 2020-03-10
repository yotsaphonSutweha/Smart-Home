package objects;

import interfaces.LightsInterface;

public class Lights implements LightsInterface{
    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public int increaseLight() {
        return 0;
    }

    @Override
    public int lowerLight() {
        return 0;
    }

    @Override
    public String lightModels() {
        return null;
    }

    @Override
    public String colours() {
        return null;
    }

    @Override
    public boolean connected() {
        return false;
    }
}
