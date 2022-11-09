import javax.swing.*;

public class FittingRoom extends Thread{
    private JPanel fittingRoomPanel;
    private JButton chickButton;
    private JButton closeMouseButton;
    private JButton openMouseButton;
    private JButton crownButton;
    private JButton eggButton;
    private JButton eyesButton;
    private JButton hatButton;
    private JButton miniChickButton;
    private JButton scarfButton;
    private JButton shrimpButton;
    private JButton thiefButton;
    private JButton exit;
    private JScrollPane fitList;
    private JPanel fitListPanel;

    Onew o;



    FittingRoom(Onew o){
        this.o = o;
        start();
    }

    @Override
    public void run() {
        JFrame f = new JFrame("옷장");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,500,100,500);
        f.setLocation(785,150);
        f.add(fittingRoomPanel);
        f.setVisible(true);
    }

    void buttonClick(JButton bt, int prize){
        if(o.getCoin()-prize<0){
            return;
        }
    }
}
