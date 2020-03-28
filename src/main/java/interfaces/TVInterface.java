package interfaces;

import java.util.ArrayList;

public interface TVInterface {
    public String turnOn();
    public String turnOff();
    public void mode();
    public ArrayList<String> channelList();
    public void setSpeakersAvailableInputs(String input);
    public ArrayList<String> getSpeakersAvailableInputs();
    public void setMusicLyrics(String lyric);
    public ArrayList<String> getMusicLyrics();
}
