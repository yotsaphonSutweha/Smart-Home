package interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface LightsInterface {
    public void setSwitch(boolean on);
    public Boolean getSwitch();
    public ArrayList<String> getLightModes();
    public void setLightMode(String mode);
    public String getLightMode();
    public void setLightColor(String lightColor);
    public String getLightColor();
}
