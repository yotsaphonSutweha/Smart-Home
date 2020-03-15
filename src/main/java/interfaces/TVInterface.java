package interfaces;

public interface TVInterface {
    public String turnOn();
    public void turnOff();
    public int increaseVolume();
    public int lowerVolume();
    public void mode();
    public boolean connnected(boolean turnOn);
    public int brightness();
    public boolean musicMode();
}
