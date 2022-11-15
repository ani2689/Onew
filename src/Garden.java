import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.Queue;

public class Garden extends Thread {
    private JPanel gardenPanel;
    private JPanel sidePanel;
    private JLabel farmmer;
    private JLabel combo;
    private JPanel scoreBoard;
    private JLabel score;
    private JPanel gamePanel;
    private JPanel exitPanel;
    private JButton exit;
    private JLabel coinText;
    private JLabel coinCount;

    static Queue<FoodList> foodList = new LinkedList<>();

    Onew o;


    Garden(Onew o) {
        this.o = o;
        setCoinText();
    }


    @Override
    public void run() {
        JFrame f = new JFrame("가든");
        ImageIcon background = new ImageIcon(Lobby.class.getResource("/img/box.png"));
        JLabel bg = new JLabel(background);
        gamePanel.add(bg);
        f.setResizable(false);
        f.add(gardenPanel);
        f.setBounds(500, 500, 500, 500);
        f.setLocation(785, 150);
        f.setIconImage(new ImageIcon(Start.class.getResource("img/onew.png")).getImage());

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

        f.setVisible(true);


        exit.addActionListener(event -> {
            f.dispose();
            Lobby.onlyOneForGarden=true;
        });

        new FarmmerMove().start();

        while (!Main.gameOver) {
            int satiation;
            try {
                Thread.sleep((int) (Math.random() * 1500) + 500);
                gamePanel.remove(bg);
                int rand =(int)(Math.random()*15);
                if(rand>=14){
                    satiation = 0;
                }else if(rand>=12){
                    satiation = 4;
                }else if(rand>=8){
                    satiation = 3;
                }else if(rand>=4){
                    satiation = 2;
                }else{
                    satiation = 1;
                }
                new Food((int) (Math.random() * (gamePanel.getWidth() - 95)) + 12, (int) (Math.random() * (gamePanel.getHeight() - 95)) + 12, satiation);
                gamePanel.add(bg);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    class FarmmerMove extends Thread {
        @Override
        public void run() {
            ImageIcon ic1 = new ImageIcon(Lobby.class.getResource("/img/farmer1.png"));
            ImageIcon ic2 = new ImageIcon(Lobby.class.getResource("/img/farmer2.png"));

            try {
                while (true) {
                    farmmer.setIcon(ic1);
                    setCoinText();
                    Thread.sleep(500);
                    farmmer.setIcon(ic2);
                    setCoinText();
                    Thread.sleep(500);
                }
            } catch (Exception e) {

            }
        }
    }

    public class Food {
        private int satiation;    //포만도
        private int foodNum;
        private String img;

        private int x;
        private int y;

        Food(int x, int y, int satiation) {
            this.x = x;
            this.y = y;
            this.satiation = satiation;
            setFoodNum();

            ImageIcon imgIc = new ImageIcon(Garden.class.getResource(getImg()));

            JButton foodButton = new JButton(imgIc);
            foodButton.setBorderPainted(false);
            foodButton.setContentAreaFilled(false);
            foodButton.setFocusPainted(false);

            ImageIcon ic = imgIc;
            Image im = ic.getImage();
            Image im2 = im.getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon ic2 = new ImageIcon(im2);
            foodButton.setRolloverIcon(ic2);

            foodButton.addActionListener(e -> {
                if (satiation != 0) {
                    int nextCount = Integer.parseInt(score.getText()) + 1;
                    score.setText(String.valueOf(nextCount));
                    FoodList saveFood = new FoodList(satiation, getImg());
                    foodList.add(saveFood);
                } else {
                    o.setCoin((o.getCoin())+1);
                    setCoinText();
                }

                foodButton.setVisible(false);
            });

            gamePanel.add(foodButton);
            foodButton.setBounds(x, y, 72, 72);

        }

        String getImg() {
            String number;

            switch (satiation) {
                case 1:
                    number = "one";
                    break;
                case 2:
                    number = "two";
                    break;
                case 3:
                    number = "three";
                    break;
                case 4:
                    number = "four";
                    break;
                case 0:
                    return "/img/coin.png";
                default:
                    number = "";
            }

            return "/img/garden/" + number + "/food" + foodNum + ".png";

        }

        void setFoodNum() {
            switch (satiation) {
                case 1:
                    foodNum = (int) (Math.random() * 8) + 1;
                    break;
                case 2:
                    foodNum = (int) (Math.random() * 13) + 1;
                    break;
                case 3:
                    foodNum = (int) (Math.random() * 9) + 1;
                    break;
                case 4:
                    foodNum = (int) (Math.random() * 11) + 1;
                    break;
                case 0:
                    foodNum = 0;
                    break;
                default:
                    foodNum = 1;
            }
        }
    }

    void setCoinText(){
        coinCount.setText(String.valueOf(o.getCoin()));
    }
}

class FoodList{
    private int satiation;
    private String img;

    FoodList(int satiation,String img){
        this.satiation=satiation;
        this.img=img;
    }

    public int getSatiation() {
        return satiation;
    }

    public String getImg() {
        return img;
    }
}
