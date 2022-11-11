import javax.swing.*;
import java.awt.*;

public class FittingRoom extends Thread{
    private JPanel fittingRoomPanel;
    private JButton chickButton;
    //static Clothing chickCostume = new Clothing("chick",50,"img/garden/emptyFood");
    private JButton closeMouseButton;
    //static Clothing closeMouseCostume = new Clothing("closeMouse",30,"img/garden/emptyFood");
    private JButton openMouseButton;
    //static Clothing openMouseCostume = new Clothing("openMouse",30,"img/garden/emptyFood");
    private JButton crownButton;
    //static Clothing crownCostume = new Clothing("crown",50,"img/garden/emptyFood");
    private JButton eggButton;
    //static Clothing eggCostume = new Clothing("egg",50,"img/garden/emptyFood");
    private JButton eyesButton;
    //static Clothing eyes = new Clothing("eyes",30,"img/garden/emptyFood");
    private JButton hatButton;
    //static Clothing hatCostume = new Clothing("hat",70,"img/garden/emptyFood");
    private JButton miniChickButton;
    //static Clothing miniChickCostume = new Clothing("miniChick",60,"img/garden/emptyFood");
    private JButton scarfButton;
    //static Clothing scarfCostume = new Clothing("scarf",80,"img/garden/emptyFood");
    private JButton shrimpButton;
    //static Clothing shrimpCostume = new Clothing("shrimp",70,"img/garden/emptyFood");
    private JButton thiefButton;
    static Clothing thiefCostume = new Clothing("thief",80,"img/costume/thief");
    private JButton exit;
    private JScrollPane fitList;
    private JPanel fitListPanel;

    static boolean answer;
    static boolean ready;

    Onew o;
    MessageBox mb;



    FittingRoom(Onew o,MessageBox mb){
        this.o = o;
        this.mb = mb;
        
        thiefCostume.setJButton(thiefButton);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("옷장");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,500,100,500);
        f.setLocation(785,150);
        f.add(fittingRoomPanel);
        f.setVisible(true);

        thiefButton.addActionListener(e -> {
            buttonClick(thiefButton,thiefCostume);
        });

    }

    void buttonClick(JButton bt,Clothing ct){
        if(ct.getSell()==false){
            MessageBox.messageText="이 의상을 구매할까요?";
            mb.setMessageWithWhy();

            mb.qnaUp();
            mb.getYesButton().addActionListener(e -> {
                mb.qnaDown();

                if(o.getCoin()-ct.getPrize()<0&&ct.getSell()==false){
                    MessageBox.messageText="가지고 있는 코인이 부족해요. (부족한 코인 : "+(ct.getPrize()-o.getCoin())+")";
                    mb.setMessageWithWow();
                }else if(o.getCoin()-ct.getPrize()>=0&&ct.getSell()==false){
                    o.setCoin(o.getCoin()-ct.getPrize());
                    ct.setSell(true);

                    MessageBox.messageText="의상을 구매했어요.";
                    mb.setMessageWithTalk();

                    ImageIcon ic = ct.getUnLockIcon();

                    bt.setIcon(ic);
                    Image im = ic.getImage();
                    Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
                    ImageIcon ic2 = new ImageIcon(im2);
                    bt.setRolloverIcon(ic2);
                }

                mb.getYesButton().removeActionListener(e1 -> {

                });

            });

            mb.getNoButton().addActionListener(e -> {
                mb.qnaDown();

                MessageBox.messageText = "의상을 구매하지 않았어요.";
                mb.setMessageWithTalk();

                mb.getNoButton().removeActionListener(en -> {
                });
            });
        }
        else if(ct.getSell()==true){

            MessageBox.messageText="이 의상을 착용할까요?";
            mb.setMessageWithWhy();

            mb.qnaUp();
            mb.getYesButton().addActionListener(e -> {
                mb.qnaDown();
                MessageBox.messageText="의상을 착용했어요.";
                mb.setMessageWithTalk();
                o.costume = ct.getName();
                mb.getYesButton().removeActionListener(en -> {

                });
            });
            mb.getNoButton().addActionListener(e -> {
                mb.qnaDown();
                MessageBox.messageText="의상을 착용하지 않았어요.";
                mb.setMessageWithTalk();

                mb.getNoButton().removeActionListener(en -> {

                });
            });

        }
    }


    public static void main(String[] args) {
        new FittingRoom(new Onew("테스터"),new MessageBox()).start();
    }

}


class Clothing{

    private String name="";
    private int prize=0;
    private boolean sell=false;
    private String unlockImg;
    private String lockImg;

    JButton Button;


    public Clothing(String name, int prize,String img) {
        this.name = name;
        this.prize = prize;

        unlockImg = img+".png";
        lockImg = img+"Lock.png";

    }

    ImageIcon getUnLockIcon(){
        return new ImageIcon(FittingRoom.class.getResource(unlockImg));
    }

    ImageIcon getLockIcon(){
        return new ImageIcon(FittingRoom.class.getResource(lockImg));
    }

    void setJButton(JButton jButton){
        this.Button=jButton;

        ImageIcon ic = getLockIcon();
        Button.setIcon(ic);
        Image im = ic.getImage();
        Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(im2);
        Button.setRolloverIcon(ic2);
    }

    JButton getJButton(){
       return Button;
    }

    boolean getSell(){
        return sell;
    }
    public void setSell(boolean sell) {
        this.sell = sell;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}