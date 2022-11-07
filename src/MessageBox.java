import javax.swing.*;

public class MessageBox {

    JFrame f;

    private JPanel messageBoxPanel;
    private JButton text;

    private JLabel messageBox;

    static String messageText;

    MessageBox(){
        f = new JFrame("메세지박스");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(490, 150, 484, 200);
        f.setLocation(308, 540);
        f.setUndecorated(true);

        text = new JButton("히히");
        text.setBorderPainted(false);
        text.setContentAreaFilled(false);
        text.setFocusPainted(false);
        text.setHorizontalAlignment(JButton.CENTER);
        messageBoxPanel.add(text);

        messageBox = new JLabel(new ImageIcon(MessageBox.class.getResource("/img/TextBar.png")));
        messageBox.setHorizontalAlignment(JLabel.CENTER);
        messageBoxPanel.add(messageBox);

        f.add(messageBoxPanel);
        f.setVisible(true);
    }


    void setMessage(){
        text.setText(messageText);
    }
}
