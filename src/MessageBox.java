import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageBox {

    JFrame f;

    private JPanel messageBoxPanel;
    private JLabel icon;
    private JLabel text;
    private JPanel iconPanel;
    private JPanel textPanel;
    private JButton yesButton;
    private JButton noButton;

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

        yesButton.setVisible(false);
        noButton.setVisible(false);
    }

    void qnaUp(){
        yesButton.setVisible(true);
        noButton.setVisible(true);
    }
    void qnaDown(){
        yesButton.setVisible(false);
        noButton.setVisible(false);
    }


    JButton getYesButton(){
        return yesButton;
    }
    JButton getNoButton(){
        return noButton;
    }

    void setYesNoButton(JButton yesButton,JButton noButton){
        this.yesButton=yesButton;
        this.noButton=noButton;
    }



    void setMessageWithTalk(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/talk.png")));
            text.setText(messageText);
        }catch (Exception e){
            messageText = "알 수 없는 오류가 발생했어요.";
            setMessageWithWow();
        }
    }

    void setMessageWithFood(String img){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource(img)));
            text.setText(messageText);
        }catch (Exception e){
            messageText = "알 수 없는 오류가 발생했어요.";
            setMessageWithWow();
        }
    }

    void setMessageWithIcon(Icon ic){
        try {
            icon.setIcon(ic);
            text.setText(messageText);
        }catch (Exception e){
            messageText = "알 수 없는 오류가 발생했어요.";
            setMessageWithWow();
        }
    }


    void setMessageWithWhy(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/why.png")));
            text.setText(messageText);
        }catch (Exception e){
            messageText = "알 수 없는 오류가 발생했어요.";
            setMessageWithWow();
        }
    }
    void setMessageWithWow(){
        try {
            icon.setIcon(new ImageIcon(MessageBox.class.getResource("/img/wow.png")));
            text.setText(messageText);
        }catch (Exception e){
            System.out.println("알 수 없는 오류 발생.");
        }
    }

    public JFrame getF() {
        return f;
    }
}
