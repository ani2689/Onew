import javax.swing.*;
import java.awt.*;

public class FittingRoom extends Thread{
    private JPanel fittingRoomPanel;
    private JButton chickButton;
    static Clothing chickCostume = new Clothing("chick",50,"img/costume/chick");
    private JButton closeMouseButton;
    static Clothing closeMouseCostume = new Clothing("closeMouse",30,"img/costume/closeMouse");
    private JButton openMouseButton;
    static Clothing openMouseCostume = new Clothing("openMouse",30,"img/costume/openMouse");
    private JButton crownButton;
    static Clothing crownCostume = new Clothing("crown",50,"img/costume/crown");
    private JButton eggButton;
    static Clothing eggCostume = new Clothing("egg",50,"img/costume/egg");
    private JButton eyesButton;
    static Clothing eyesCostume = new Clothing("eyes",30,"img/costume/eyes");
    private JButton hatButton;
    static Clothing hatCostume = new Clothing("hat",70,"img/costume/hat");
    private JButton miniChickButton;
    static Clothing miniChickCostume = new Clothing("miniChick",60,"img/costume/miniChick");
    private JButton scarfButton;
    static Clothing scarfCostume = new Clothing("scarf",80,"img/costume/scarf");
    private JButton shrimpButton;
    static Clothing shrimpCostume = new Clothing("shrimp",70,"img/costume/shrimp");
    private JButton thiefButton;
    static Clothing thiefCostume = new Clothing("thief",80,"img/costume/thief");
    private JButton exit;
    private JScrollPane fitList;
    private JPanel fitListPanel;


    Onew o;
    MessageBox mb;



    Clothing[] costumeClothing={
            chickCostume,
            closeMouseCostume,
            openMouseCostume,
            crownCostume,
            eggCostume,
            eyesCostume,
            hatCostume,
            miniChickCostume,
            scarfCostume,
            shrimpCostume,
            thiefCostume
    };
    JButton[] costumeJButton={
            chickButton,
            closeMouseButton,
            openMouseButton,
            crownButton,
            eggButton,
            eyesButton,
            hatButton,
            miniChickButton,
            scarfButton,
            shrimpButton,
            thiefButton
    };

    FittingRoom(Onew o,MessageBox mb){
        this.o = o;
        this.mb = mb;

        for(int i=0;i<costumeClothing.length;i++){
            costumeClothing[i].setJButton(costumeJButton[i]);

            int finalI = i;
            costumeJButton[i].addActionListener(e -> {
                buttonClick(costumeJButton[finalI],costumeClothing[finalI]);
            });
        }
    }

    @Override
    public void run() {
        JFrame f = new JFrame("옷장");
        f.setBounds(120,500,100,500);
        f.setLocation(185,150);
        f.setIconImage(new ImageIcon(Start.class.getResource("img/onew.png")).getImage());
        f.setResizable(false);
        f.add(fittingRoomPanel);
        f.setVisible(true);

        exit.addActionListener(e -> {
            Lobby.onlyOneForFittingRoom=true;
            f.dispose();
        });

    }

    void buttonClick(JButton bt,Clothing ct){

        //1.구매 - 착용중일때 : 옷을 착용해제할까요?
        //2.구매 - 미착용중일때 : 옷을 착용할까요?
        //3.비구매 - 돈 여유 : 구매할까요?
        //4.비구매 - 돈 없음 : 돈이 부족합니다ㅋ

        YesOrNo yesOrNo = new YesOrNo();

        if(ct.getSell()==true&&o.getCostume()==ct.getName()){
            MessageBox.messageText="옷을 착용해제할까요?";
            mb.setMessageWithWhy();

            yesOrNo.getYesButton().addActionListener(e -> {
                MessageBox.messageText="옷을 착용해제했어요.";
                mb.setMessageWithIcon(ct.getUnLockIcon());
                o.setCostume("");
                yesOrNo.off();
            });
            yesOrNo.getNoButton().addActionListener(e -> {
                MessageBox.messageText="옷을 착용해제하지 않았어요.";
                mb.setMessageWithWow();
                yesOrNo.off();
            });

        }else if(ct.getSell()==true&&o.getCostume()!=ct.getName()){
            MessageBox.messageText="옷을 착용할까요?";
            mb.setMessageWithWhy();

            yesOrNo.getYesButton().addActionListener(e -> {
                MessageBox.messageText="옷을 착용했어요.";
                mb.setMessageWithIcon(ct.getUnLockIcon());
                o.setCostume(ct.getName());
                yesOrNo.off();
            });
            yesOrNo.getNoButton().addActionListener(e -> {
                MessageBox.messageText="옷을 착용하지 않았어요.";
                mb.setMessageWithWow();
                yesOrNo.off();
            });

        }else if(ct.getSell()==false){
            MessageBox.messageText="옷을 구매할까요? (필요한 코인 : " + ct.getPrize()+")";
            mb.setMessageWithWhy();

            yesOrNo.getYesButton().addActionListener(e -> {

                if(o.getCoin()-ct.getPrize()<0){
                    MessageBox.messageText="돈이 부족해요!";
                    mb.setMessageWithWow();
                    yesOrNo.off();
                }else{
                    MessageBox.messageText="옷을 구매했어요.";
                    o.setCoin(o.getCoin()-ct.getPrize());
                    mb.setMessageWithIcon(ct.getUnLockIcon());
                    ct.setSell(true);
                    ct.setIcon();
                    yesOrNo.off();
                }
            });
            yesOrNo.getNoButton().addActionListener(e -> {
                MessageBox.messageText="옷을 구매하지 않았어요.";
                mb.setMessageWithWow();
                yesOrNo.off();
            });
        }
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
        setIcon();
    }

    void setIcon(){
        if(getSell()){
            ImageIcon ic = getUnLockIcon();
            Button.setIcon(ic);
            Image im = ic.getImage();
            Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon ic2 = new ImageIcon(im2);
            Button.setRolloverIcon(ic2);
        }else{
            ImageIcon ic = getLockIcon();
            Button.setIcon(ic);
            Image im = ic.getImage();
            Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon ic2 = new ImageIcon(im2);
            Button.setRolloverIcon(ic2);
        }
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