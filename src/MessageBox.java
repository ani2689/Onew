import javax.swing.*;

public class MessageBox {

    JFrame f;

    private JPanel messageBoxPanel;
    private JButton button1;
    private JPanel foodImgPanel;
    private JLabel foodImg;
    private JButton text;

    private JLabel messageBox;

    static String messageText;

    MessageBox(){
        f = new JFrame("메세지박스");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(490, 102, 484, 102);
        f.setLocation(308, 540);
        f.setUndecorated(true);

        text = new JButton("히히");
        text.setBorderPainted(false);
        text.setContentAreaFilled(false);
        text.setFocusPainted(false);
        text.setHorizontalAlignment(JButton.CENTER);
        messageBoxPanel.add(text);

        f.add(messageBoxPanel);
        f.setVisible(true);
    }


    void setMessage(){
        foodImg.setIcon(null);
        text.setText(messageText);
    }

    void setMessageWithImg(String img){
        foodImg.setIcon(new ImageIcon(img));
        text.setText(messageText);
    }
}
