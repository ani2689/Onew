import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lobby extends Thread{
    private JPanel leftUnderPanel;
    private JButton eattingButton;
    private JLabel copyright;
    private JPanel charctorPanel;
    private JLabel charctor;
    private JPanel rightPanel;
    private JButton gardenButton;
    private JPanel lobbyPanel;
    private JPanel barPanel;
    private JPanel hpPanel;
    private JPanel fullPanel;
    private JLabel hpBar;
    private JLabel fullBar;
    private JPanel binLf;
    private JPanel binRt;
    static ImageIcon hpBarImg;
    static ImageIcon fullBarImg;

    String costume;

    static boolean onlyOneForGarden =true;
    static boolean onlyOneForFittingRoom=true;
    static int click=0;

    MessageBox mb;

    Onew o ;


    public long time;

    void setIcon(){
        hpBar.setIcon(hpBarImg);
        fullBar.setIcon(fullBarImg);
    }

    Lobby(Onew o) {
        this.o = o;
        go();
    }
    void go(){

        setCostume(o);

        start();

        hpBarImg=new ImageIcon(Onew.class.getResource("/img/hpBar/hpBar10.png"));
        fullBarImg=new ImageIcon(Onew.class.getResource("/img/fullBar/fullBar10.png"));

       for (int i=0;;i++){
           if(i==100){
               mb.setMessageWithTalk();
               i=0;
           }
           setIcon();
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {

           }
       }
    }



    @Override
    public void run() {

        mb= new MessageBox();
        MessageBox.messageText="만나서 반가워요, "+o.getOnewName();
        time = System.currentTimeMillis();
        mb.setMessageWithTalk();

        new FittingRoom(o,mb).start();

        JFrame f = new JFrame("오뉴");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(lobbyPanel);
        f.setBounds(500, 400, 500, 400);
        f.setLocation(300, 150);
        f.setIconImage(new ImageIcon(Start.class.getResource("img/onew.png")).getImage());
        //new FittingRoom(o);

        f.setVisible(true);



        charctor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(onlyOneForFittingRoom){
                    onlyOneForFittingRoom=false;
                    new FittingRoom(o,mb).start();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gardenButton.addActionListener(event -> {
            if (onlyOneForGarden) {
                onlyOneForGarden=false;
                new Garden(o).start();
            }
        });

        eattingButton.addActionListener(e -> {
            if(Garden.foodList.peek()!=null&&o.getFull()<100){

                FoodList fd =  Garden.foodList.poll();
                if(o.getFull()+fd.getSatiation()>=100){
                    o.setFull(100);
                    MessageBox.messageText="포만도가"+((o.getFull()+fd.getSatiation())-100)+"만큼 올랐어요."+"\t(현재 포만도 : "+o.getFull()+")";
                }else{
                    o.setFull(o.getFull()+ fd.getSatiation());
                    MessageBox.messageText="포만도가"+fd.getSatiation()+"만큼 올랐어요."+"\t(현재 포만도 : "+o.getFull()+")";;
                }

                mb.setMessageWithFood(fd.getImg());
            }else if(Garden.foodList.peek()==null){
                MessageBox.messageText="냉장고에 먹이가 없어요!";
                mb.setMessageWithWow();
            }else{
                MessageBox.messageText="오뉴는 지금 충분히 배가 불러요.";
                mb.setMessageWithTalk();
            }
        });



        onewMove(o);
        gameOver();


    }

    void onewMove(Onew o) {

        try {
            while (!Main.gameOver) {

                setCostume(o);

                int randAction = ((int) (Math.random() * 8));

                switch (randAction) {
                    case 0:
                    case 1:
                        rightWalk();
                        rightSee();
                        break;
                    case 2:
                    case 3:
                        leftWalk();
                        leftSee();
                        break;
                    case 4:
                        rightSee();
                        break;
                    case 5:
                        leftSee();
                        break;
                    case 6:
                        leftJump();
                        leftSee();
                        break;
                    case 7:
                        rightJump();
                        rightSee();
                        break;

                }
            }
        }catch (Exception e){

            return;
        }
    }

    public void leftJump() throws InterruptedException{

        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"2.png"));

        charctor.setIcon(ic2);
        Thread.sleep(100);
        charctor.setIcon(ic2);

        for(int i=0;i<3;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()-i*2);
            Thread.sleep(150);
        }
        for(int i=0;i<3;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()+i*2);
            Thread.sleep(150);
        }

        charctor.setIcon(ic2);
        Thread.sleep(100);
        charctor.setIcon(ic1);


    }

    public void rightJump() throws InterruptedException{


        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"2.png"));

        charctor.setIcon(ic2);
        Thread.sleep(100);
        charctor.setIcon(ic2);

        for(int i=0;i<3;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()-i*2);
            Thread.sleep(150);
        }
        for(int i=0;i<3;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()+i*2);
            Thread.sleep(150);
        }

        charctor.setIcon(ic2);
        Thread.sleep(100);
        charctor.setIcon(ic1);


    }

    public void leftSee() throws InterruptedException {
        for(int i=0;i<(Math.random()*3+5)&&click==0;i++){

            ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+costume+"1.png"));
            ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+costume+"2.png"));

            charctor.setIcon(ic1);
            for(int j=0;j<10&&click==0;j++){
                Thread.sleep(50);
            }
            charctor.setIcon(ic2);
            for(int j=0;j<10&&click==0;j++){
                Thread.sleep(50);
            }
        }
    }

    public void rightSee() throws InterruptedException {

        for(int i=0;i<(Math.random()*3+5)&&click==0;i++){

            ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+costume+"1.png"));
            ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+costume+"2.png"));

            charctor.setIcon(ic1);
            for(int j=0;j<10&&click==0;j++){
                Thread.sleep(50);
            }
            charctor.setIcon(ic2);
            for(int j=0;j<10&&click==0;j++){
                Thread.sleep(50);
            }
        }
    }

    public void leftWalk() throws InterruptedException {

        ImageIcon ic0;
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk1.png"));
        ImageIcon ic2;

        for(int i=0;i<(Math.random()*30+3)&&charctor.getX()>=-130&&click==0;i++){

            ic0 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk0.png"));
            ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk1.png"));
            ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk2.png"));

            charctor.setIcon(ic1);
            charctor.setLocation(charctor.getX()-5,charctor.getY());

            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()-2,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic2);
            charctor.setLocation(charctor.getX()-5,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()-2,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }
        }
        charctor.setIcon(ic1);

    }

    public void rightWalk() throws InterruptedException {

        ImageIcon ic0;
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk1.png"));
        ImageIcon ic2;

        for(int i=0;i<(Math.random()*30+3)&&charctor.getX()<=130&&click==0;i++){

            ic0 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk0.png"));
            ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk1.png"));
            ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk2.png"));

            charctor.setIcon(ic1);
            charctor.setLocation(charctor.getX()+5,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()+2,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic2);
            charctor.setLocation(charctor.getX()+5,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()+2,charctor.getY());
            for(int j=0;j<10&&click==0;j++) {
                Thread.sleep(20);
            }
        }
        charctor.setIcon(ic1);

    }

    public void gameOver() {
        charctor.setIcon(new ImageIcon(Lobby.class.getResource("img/die.png")));
        eattingButton.setVisible(false);
        gardenButton.setVisible(false);

        int h,m,s;

        s = (int)((System.currentTimeMillis()-time)/1000);
        m=s/60;
        h=m/60;
        s=s%60;
        m=m%60;

        MessageBox.messageText="GameOver... "+h+"시간 "+m+"분 "+s+"초 동안 키웠어요.";
        mb.setMessageWithWow();

        try {
            sleep(10000);
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    void setCostume(Onew o){
        this.costume= o.getCostume();
    }

}
