import javax.swing.*;

public class Start {
    private JPanel startPanel;
    private JPanel empty1;
    private JPanel empty2;
    private JPanel textPanel;
    private JPanel readNamePanel;
    private JLabel text;
    private JTextField readText;
    private JButton checkButton;

    private JFrame f;

    static String name;

    Start() {
        f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(300,200,300,200);
        f.setLocation(400,400);

        f.add(startPanel);
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

    public static String getName() {
        return name;
    }
}
