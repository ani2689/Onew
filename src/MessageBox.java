import javax.swing.*;

public class MessageBox {

    JFrame f;

    private JPanel messageBoxPanel;
    private JLabel icon;
    private JLabel text;
    private JPanel iconPanel;
    private JPanel textPanel;

    private JLabel messageBox;

    static String messageText;

    MessageBox(){
        f = new JFrame("메세지박스");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setBounds(490, 102, 484, 102);
        f.setLocation(308, 540);
        f.setUndecorated(true);

        f.add(messageBoxPanel);
        f.setVisible(true);
    }


    void setMessageWithTalk(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/talk.png")));
        }catch (Exception e){

        }
        text.setText(messageText);
    }

    void setMessageWithFood(String img){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource(img)));
        }catch (Exception e){

        }
        text.setText(messageText);
    }


    void setMessageWithWhy(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/why.png")));
        }catch (Exception e){

        }
        text.setText(messageText);
    }
    void setMessageWithWow(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/wow.png")));
        }catch (Exception e){

        }
        text.setText(messageText);
    }
}
