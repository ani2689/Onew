import javax.swing.*;
import java.awt.*;

public class Garden {
    private JPanel gardenPanel;
    private JPanel sidePanel;
    private JLabel farmmer;
    private JLabel combo;
    private JPanel scoreBoard;
    private JLabel score;
    private JPanel gamePanel;
    private JPanel exitPanel;
    private JButton exit;


    Garden(){
        JFrame f = new JFrame();

        f.setTitle("자바프로젝트");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(gardenPanel);
        f.setBounds(500,500,500,500);
        f.setLocation(785,150);
        f.setVisible(true);


        exit.addActionListener(event -> {
            f.setVisible(false);
            Lobby.onlyOne--;
        });


        while(true){
            try {
                new Food((int)(Math.random()* (gamePanel.getWidth()-70)),(int)(Math.random()* (gamePanel.getHeight()-70)),(int)(Math.random()*4)+1);
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public class Food {
        private int satiation;    //포만도
        private int foodNum;
        private String img;

        private int x;
        private int y;

        Food(int x,int y, int satiation){
            this.x = x;
            this.y = y;
            this.satiation=satiation;
            setFoodNum();

            ImageIcon imgIc = new ImageIcon(Garden.class.getResource(getImg()));

            JButton foodButton = new JButton(imgIc);
            foodButton.setBorderPainted(false);
            foodButton.setContentAreaFilled(false);
            foodButton.setFocusPainted(false);

            ImageIcon ic = imgIc;
            Image im =ic.getImage();
            Image im2 = im.getScaledInstance(72,72,Image.SCALE_SMOOTH);
            ImageIcon ic2 = new ImageIcon(im2);
            foodButton.setRolloverIcon(ic2);

            foodButton.addActionListener(e -> {
                int nextCount = Integer.parseInt(score.getText())+1;
                score.setText(String.valueOf(nextCount));


                foodButton.setVisible(false);
            });

            gamePanel.add(foodButton);
            foodButton.setBounds(x,y,72,72);

        }

        String getImg(){
            String number;

            switch (satiation){
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
                default:
                    number = "";
            }

            return "/img/garden/"+number+"/food"+ foodNum +".png";

        }

        void setFoodNum(){
            switch (satiation){
                case 1:
                    foodNum =(int)(Math.random()*8)+1;
                    break;
                case 2:
                    foodNum =(int)(Math.random()*13)+1;
                    break;
                case 3:
                    foodNum =(int)(Math.random()*9)+1;
                    break;
                case 4:
                    foodNum =(int)(Math.random()*11)+1;
                    break;
                default:
                    foodNum =1;
            }
        }
    }
}
