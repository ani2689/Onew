import javax.swing.*;
import java.awt.*;

public class Start extends Thread{
    private JPanel startPanel;
    private JPanel empty1;
    private JPanel empty2;
    private JPanel textPanel;
    private JPanel readNamePanel;
    private JLabel text;
    private JTextField readText;
    private JButton checkButton;
    private JLabel subText;

    private JFrame f;

    Start() {
        start();
    }

    @Override
    public void run() {
        f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(400,250,400,250);
        f.setLocation(400,400);

        f.setIconImage(new ImageIcon(Start.class.getResource("img/onew.png")).getImage());

        f.add(startPanel);
        subText.setVisible(false);
        f.setVisible(true);
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JTextField getReadText() {
        return readText;
    }

    public JFrame getF() {
        return f;
    }

    public void setSubText(String str){
        subText.setVisible(true);
        subText.setText(str);
    }
}
