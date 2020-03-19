package interfaces;

public interface TVInterface {
    public String turnOn();
    public void turnOff();
    public void mode();
    public boolean connnected(boolean turnOn);
    public int brightness();
    public boolean musicMode();
}
