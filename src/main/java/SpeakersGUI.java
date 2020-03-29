import javax.swing.*;

public class SpeakersGUI extends JFrame{
    private JLabel spkearsJPanel;
    private JPanel rootPane;
    private JPanel speakersFunctions;
    private JTextPane speakOn;
    private JTextPane availableInputs;
    private JTextPane musicStreamingTextPane;
    private JTextPane musicStreamingTextPane2;
    private JTextPane musicStreamingTextPane3;
    private JTextPane musicStreamingTextPane4;
    private JTextPane musicStreamingTextPane5;
    private JTextPane musicStreamingTextPane6;
    private JTextPane musicStreamingTextPane7;
    private JTextPane musicStreamingTextPane8;
    private JTextPane musicStreamingTextPane9;

    public SpeakersGUI() {
        add(rootPane);
        setTitle("Speakers Panel");
        setSize(500, 500);
    }

    public JTextPane getAvailableInputs() {
        return availableInputs;
    }

    public JTextPane getSpeakOn() {
        return speakOn;
    }

    public JTextPane getMusicStreamingTextPane() {
        return musicStreamingTextPane;
    }

    public JTextPane getMusicStreamingTextPane2() {
        return musicStreamingTextPane2;
    }

    public JTextPane getMusicStreamingTextPane3() {
        return musicStreamingTextPane3;
    }

    public JTextPane getMusicStreamingTextPane4() {
        return musicStreamingTextPane4;
    }

    public JTextPane getMusicStreamingTextPane5() {
        return musicStreamingTextPane5;
    }

    public JTextPane getMusicStreamingTextPane6() {
        return musicStreamingTextPane6;
    }

    public JTextPane getMusicStreamingTextPane7() {
        return musicStreamingTextPane7;
    }

    public JTextPane getMusicStreamingTextPane8() {
        return musicStreamingTextPane8;
    }

    public JTextPane getMusicStreamingTextPane9() {
        return musicStreamingTextPane9;
    }
}