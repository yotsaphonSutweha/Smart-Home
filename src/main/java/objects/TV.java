package objects;

import interfaces.TVInterface;

import java.util.ArrayList;

public class TV implements TVInterface {
    private ArrayList<String> speakersInputs;
    private ArrayList<String> musicLyrics;
    public TV() {
        speakersInputs = new ArrayList<>();
    }

    @Override
    public String turnOn() {
        return "is On";
    }

    @Override
    public void mode() {

    }

    @Override
    public ArrayList<String> channelList() {
        ArrayList<String> channelList = new ArrayList<>();
        channelList.add("Disney");
        channelList.add("Cartoon Network");
        channelList.add("Music");
        return channelList;
    }

    @Override
    public void setSpeakersAvailableInputs(String input) {
        this.speakersInputs.add(input);
    }

    @Override
    public ArrayList<String> getSpeakersAvailableInputs() {
        return this.speakersInputs;
    }

    @Override
    public void setMusicLyrics(String lyric) {
        this.musicLyrics.add(lyric);
    }

    @Override
    public ArrayList<String> getMusicLyrics() {
        return this.musicLyrics;
    }


}
