import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightsGUI extends JFrame{
    private JPanel rootPane;
    private JLabel lightsLabel;
    private JPanel inputsPanel;
    private JButton switchBtn;
    private JButton displayLightsModesBtn;
    private JTextField lighteModeTextField;
    private JButton setLightsModeBtn;
    private JLabel lightColor1Label;
    private JLabel lightColor2Label;
    private JTextField lightColorTextField1;
    private JTextField lightColorTextField2;
    private JButton combineLightBtn;
    private JPanel lightsCombinerPanel;
    private JPanel outputsPanel;
    private JLabel lightsStatusPanel;
    private JTextPane lightsSwitchTextPane;
    private JTextPane lightsModeTextPane;
    private JTextPane lightsColorTextPane;
    private JTextPane availableLightsMode;
    private JComboBox lightsModeComboBox;

    public LightsGUI () {
        add(rootPane);
        setTitle("Lights GUI");
        setSize(500, 300);
        lightsModeComboBox.addItem("LIGHT");
        lightsModeComboBox.addItem("DARK");
        lightsModeComboBox.addItem("DISCO");
        lightsModeComboBox.setSelectedIndex(0);
    }

    public JComboBox getLightsModeComboBox() {
        return lightsModeComboBox;
    }

    public JButton getDisplayLightsModesBtn() {
        return displayLightsModesBtn;
    }

    public JButton getSwitchBtn() {
        return switchBtn;
    }

    public JTextField getLighteModeTextField() {
        return lighteModeTextField;
    }

    public JButton getSetLightsModeBtn() {
        return setLightsModeBtn;
    }

    public JButton getCombineLightBtn() {
        return combineLightBtn;
    }

    public JTextPane getLightsSwitchTextPane() {
        return lightsSwitchTextPane;
    }

    public JTextPane getLightsModeTextPane() {
        return lightsModeTextPane;
    }

    public JTextPane getLightsColorTextPane() {
        return lightsColorTextPane;
    }

    public JTextPane getAvailableLightsMode() {
        return availableLightsMode;
    }

    public JTextField getLightColorTextField1() {
        return lightColorTextField1;
    }

    public JTextField getLightColorTextField2() {
        return lightColorTextField2;
    }
}
