import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class YesOrNo{


    private JPanel yesOrNoPanel;

    public JButton getYesButton() {
        return yesButton;
    }
    public JButton getNoButton() {
        return noButton;
    }

    private JButton yesButton;
    private JButton noButton;
    private JFrame f;

    YesOrNo(){
        f = new JFrame();

        Image im = new ImageIcon(YesOrNo.class.getResource("img/talk.png")).getImage();
        Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(im2);
        yesButton.setRolloverIcon(ic2);
        noButton.setRolloverIcon(ic2);

        f.add(yesOrNoPanel);
        f.setBounds(200,100,200,100);
        f.setLocation(580,480);
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                f.dispose();

            }
        });
        f.setUndecorated(true);
        yesOrNoPanel.setBackground(new Color(0,0,0,0));
        f.setBackground(new Color(0,0,0,0));
        f.setVisible(true);

    }

    YesOrNo(int x,int y){
        f = new JFrame();

        Image im = new ImageIcon(YesOrNo.class.getResource("img/talk.png")).getImage();
        Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(im2);
        yesButton.setRolloverIcon(ic2);
        noButton.setRolloverIcon(ic2);

        f.add(yesOrNoPanel);
        f.setBounds(200,100,200,100);
        f.setLocation(x,y);
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                f.dispose();

            }
        });
        f.setUndecorated(true);
        yesOrNoPanel.setBackground(new Color(0,0,0,0));
        f.setBackground(new Color(0,0,0,0));
        f.setVisible(true);

    }

    void off(){
        f.dispose();
    }
}

