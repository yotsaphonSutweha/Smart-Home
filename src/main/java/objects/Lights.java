package objects;

import interfaces.LightsInterface;

import java.util.ArrayList;

public class Lights implements LightsInterface{

    private boolean lightSwitch;
    private ArrayList<String> lightModes = new ArrayList<>();
    private String lightColor;
    private String lightMode;

    public Lights() {
        this.lightSwitch = false;
        this.lightModes.add("Light");
        this.lightModes.add("Dark");
        this.lightModes.add("Disco");
        this.lightColor = "white";
    }
    @Override
    public void setSwitch(boolean on) {
        this.lightSwitch = on;
    }

    @Override
    public Boolean getSwitch() {
        return this.lightSwitch;
    }

    @Override
    public ArrayList<String> getLightModes() {
        return lightModes;
    }

    @Override
    public void setLightMode(String mode) {
        this.lightMode = mode;
    }

    @Override
    public String getLightMode() {
        return this.lightMode;
    }

    @Override
    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

    @Override
    public String getLightColor() {
        return this.lightColor;
    }
}
