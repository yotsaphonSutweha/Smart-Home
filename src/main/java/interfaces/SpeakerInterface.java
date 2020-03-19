package interfaces;

public interface SpeakerInterface {
    public String turnOn();
    public void turnOff();
    public boolean connected();
    public int increaseVolumn();
    public int setVolumn(int volumn);
    public int lowerVolumn();
    public void turnRadioOn();
    public void turnRadioOff();
    public boolean musicMode();

}

