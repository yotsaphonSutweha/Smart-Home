import javax.swing.*;

public class CurtainGUI extends JFrame{
    private JPanel rootPane;
    private JLabel curtainPanelLabel;
    private JPanel inputsPanel;
    private JButton openCurtainBtn;
    private JButton closeCurtainBtn;
    private JTextField widthTextField;
    private JTextField heightTextField;
    private JButton adjustWidthHeightBtn;
    private JPanel outputPanel;
    private JTextPane curtainStatusTextPane;
    private JTextPane widthTextPane;
    private JTextPane heightTextPane;
    private JLabel widthLabel;
    private JLabel heightLabel;

    public CurtainGUI() {
        add(rootPane);
        setTitle("Curtain GUI");
        setSize(500, 200);
    }

    public JButton getOpenCurtainBtn() {
        return openCurtainBtn;
    }

    public JButton getCloseCurtainBtn() {
        return closeCurtainBtn;
    }

    public JTextField getWidthTextField() {
        return widthTextField;
    }

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JButton getAdjustWidthHeightBtn() {
        return adjustWidthHeightBtn;
    }

    public JTextPane getCurtainStatusTextPane() {
        return curtainStatusTextPane;
    }

    public JTextPane getWidthTextPane() {
        return widthTextPane;
    }

    public JTextPane getHeightTextPane() {
        return heightTextPane;
    }
}
