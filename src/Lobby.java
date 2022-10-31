import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Lobby extends Thread{
    private JPanel leftUnderPanel;
    private JButton eattingButton;
    private JPanel underTextPanel;
    private JLabel copyright;
    private JPanel charctorPanel;
    private JLabel charctor;
    private JPanel rightPanel;
    private JButton gardenButton;
    private JPanel lobbyPanel;

    String costume;

    static int onlyOne=0;
    static int click=0;

    /*
    class LobbyMouseAdapter implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            click=0;

            click++;

            try {
                if(e.getX()>charctor.getX()){
                    ImageIcon ic0 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk0.png"));
                    ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk1.png"));
                    ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk2.png"));

                    while(e.getX()>charctor.getX()){
                        charctor.setIcon(ic1);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()+5,charctor.getY());

                        charctor.setIcon(ic0);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()+2,charctor.getY());

                        charctor.setIcon(ic2);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()+5,charctor.getY());

                        charctor.setIcon(ic0);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()+2,charctor.getY());
                    }
                    charctor.setIcon(ic1);
                }else if(e.getX()-70<=charctor.getX()){
                    ImageIcon ic0 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk0.png"));
                    ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk1.png"));
                    ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk2.png"));

                    while(e.getX()-70<charctor.getX()){

                        charctor.setIcon(ic1);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()-5,charctor.getY());

                        charctor.setIcon(ic0);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()-2,charctor.getY());

                        charctor.setIcon(ic2);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()-5,charctor.getY());

                        charctor.setIcon(ic0);
                        Thread.sleep(200);
                        charctor.setLocation(charctor.getX()-2,charctor.getY());
                    }
                    charctor.setIcon(ic1);
                }

                click--;

            }catch (Exception er){
                er.printStackTrace();
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
    }*/



    Lobby() {

        JFrame f = new JFrame();

        f.setTitle("오뉴");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(lobbyPanel);
        f.setBounds(500, 500, 500, 500);
        f.setLocation(300, 150);

        //charctorPanel.addMouseListener(new LobbyMouseAdapter());

        f.setVisible(true);

        gardenButton.addActionListener(event -> {
            if (onlyOne == 0) {
                onlyOne++;
                run();
            }
        });

        onewMove();
    }

    void onewMove() {

        Onew o = new Onew("설희");
        setCostume(o);

        try {
            while (click==0) {

                setCostume(o);

                int randAction = (int) (Math.random() * 8);

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

        for(int i=0;i<5;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()-i*3);
            Thread.sleep(150);
        }
        for(int i=0;i<5;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()+i*3);
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

        for(int i=0;i<5;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()-i*3);
            Thread.sleep(150);
        }
        for(int i=0;i<5;i++){
            charctor.setLocation(charctor.getX(),charctor.getY()+i*3);
            Thread.sleep(150);
        }

        charctor.setIcon(ic2);
        Thread.sleep(100);
        charctor.setIcon(ic1);


    }

    public void leftSee() throws InterruptedException {
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+costume+"1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+costume+"2.png"));
        for(int i=0;i<(Math.random()*3+5);i++){
            charctor.setIcon(ic1);
            for(int j=0;j<10;j++){
                if(click!=0){
                    return;
                }
                Thread.sleep(50);
            }
            charctor.setIcon(ic2);
            for(int j=0;j<10;j++){
                if(click!=0){
                    return;
                }
                Thread.sleep(50);
            }
        }
    }

    public void rightSee() throws InterruptedException {
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+costume+"1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+costume+"2.png"));
        for(int i=0;i<(Math.random()*3+5);i++){
            charctor.setIcon(ic1);
            for(int j=0;j<10;j++){
                if(click!=0){
                    return;
                }
                Thread.sleep(50);
            }
            charctor.setIcon(ic2);
            for(int j=0;j<10;j++){
                if(click!=0){
                    return;
                }
                Thread.sleep(50);
            }
        }
    }

    public void leftWalk() throws InterruptedException {

        ImageIcon ic0 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk0.png"));
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/left/charctor"+ costume +"Walk2.png"));

        for(int i=0;i<(Math.random()*30+3)&&charctor.getX()>=30;i++){
            charctor.setIcon(ic1);
            charctor.setLocation(charctor.getX()-5,charctor.getY());

            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()-2,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic2);
            charctor.setLocation(charctor.getX()-5,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()-2,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }
        }
        charctor.setIcon(ic1);

    }

    public void rightWalk() throws InterruptedException {

        ImageIcon ic0 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk0.png"));
        ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk1.png"));
        ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/right/charctor"+ costume +"Walk2.png"));

        for(int i=0;i<(Math.random()*30+3)&&charctor.getX()<=280;i++){
            charctor.setIcon(ic1);
            charctor.setLocation(charctor.getX()+5,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()+2,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic2);
            charctor.setLocation(charctor.getX()+5,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }

            charctor.setIcon(ic0);
            charctor.setLocation(charctor.getX()+2,charctor.getY());
            for(int j=0;j<10;j++) {
                if (click != 0) {
                    return;
                }
                Thread.sleep(20);
            }
        }
        charctor.setIcon(ic1);

    }

    void setCostume(Onew o){
        this.costume=o.costume;
    }

}
