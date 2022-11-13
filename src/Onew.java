import javax.swing.*;

public class Onew extends Thread{

    private String name;
    private int full=100;
    private int hp=100;

    private int coin=80;


    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }




    private String costume="";

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    Onew(String name){
        this.name = name;
        start();
    }

    @Override
    public void run() {
        ImageIcon[] hpBarIcon = new ImageIcon[11];
        ImageIcon[] fullBarIcon = new ImageIcon[11];

        for(int i=0;i<11;i++){
            hpBarIcon[i] = new ImageIcon(Onew.class.getResource("/img/hpBar/hpBar"+i+".png"));
            fullBarIcon[i] = new ImageIcon(Onew.class.getResource("/img/fullBar/fullBar"+i+".png"));
        }

        while (Main.gameOver==0){

            Lobby.hpBarImg=hpBarIcon[hp/10];
            Lobby.fullBarImg=fullBarIcon[full/10];
            try {
                for(int i=0;i<100;i++){
                    sleep(10);
                    Lobby.hpBarImg=hpBarIcon[hp/10];
                    Lobby.fullBarImg=fullBarIcon[full/10];
                }
                if(hp<=0){
                    Main.gameOver++;
                    return;
                }
                else if(full<=0){
                    hp--;
                }else{
                    full--;
                    if(hp!=100)
                        hp++;
                }

                if(hp<=30){
                    switch ((int)(Math.random()*5)){
                        case 0:
                            MessageBox.messageText = name+"(이)가 죽을 지경이에요!";
                            break;
                        case 1:
                            MessageBox.messageText ="어서 밥을 주세요!";
                            break;
                        case 2:
                            MessageBox.messageText = name+"(이)는 지금 배가 고프다는데...";
                            break;
                        case 3:
                            MessageBox.messageText ="이런! 창고가 비었나요?";
                            break;
                        case 4:
                            MessageBox.messageText ="과도한 단식은 위험해요.";
                            break;
                    }
                }else if(hp<=60) {
                    switch ((int)(Math.random()*5)){
                        case 0:
                            MessageBox.messageText = name+"(이)가 배가 고프다며 투정을 부려요.";
                            break;
                        case 1:
                            MessageBox.messageText ="이런! 창고가 비었나요?";
                            break;
                        case 2:
                            MessageBox.messageText =name+"(이)는 지금 배가 고프다는데...";
                            break;
                        case 3:
                            MessageBox.messageText ="이러다가는 배가 등가죽에 붙겠어요...";
                            break;
                        case 4:
                            MessageBox.messageText =name+"(이)는 열심히 운동하고 있어요!";
                            break;
                    }
                }else if(full<=50){
                    switch ((int)(Math.random()*5)){
                    case 0:
                        MessageBox.messageText = name+"(이)는 지금 기분이 좋아요.";
                        break;
                    case 1:
                        MessageBox.messageText ="밥주는 시간을 잊은 건 아니죠?";
                        break;
                    case 2:
                        MessageBox.messageText ="꾸준히 먹어야 튼튼해져요.";
                        break;
                    case 3:
                        MessageBox.messageText ="적당한 음식투정은 괜찮겠죠?";
                        break;
                    case 4:
                        MessageBox.messageText =name+"(이)는 열심히 운동하고 있어요!";
                        break;

                    }
                }else if(full<=80){
                    switch ((int)(Math.random()*5)) {
                        case 0:
                            MessageBox.messageText = name+"(이)는 지금 기분이 좋아요.";
                            break;
                        case 1:
                            MessageBox.messageText = name+"(이)는 지금 충분히 베가 불러요";
                            break;
                        case 2:
                            MessageBox.messageText = "꾸준히 먹어야 튼튼해져요.";
                            break;
                        case 3:
                            MessageBox.messageText = "적당한 음식투정은 괜찮겠죠?";
                            break;
                        case 4:
                            MessageBox.messageText = name+", 아무래도 좋아보여요.";
                            break;
                    }
                }else{
                    switch ((int)(Math.random()*5)) {
                        case 0:
                            MessageBox.messageText = "이때 음식을 쟁여놔야죠.";
                            break;
                        case 1:
                            MessageBox.messageText = name+"(이)는 행복하답니다.";
                            break;
                        case 2:
                            MessageBox.messageText = "꾸준히 먹어야 튼튼해져요.";
                            break;
                        case 3:
                            MessageBox.messageText = "체중따위 신경쓰지 않는게 맞겠죠!";
                            break;
                        case 4:
                            MessageBox.messageText = "포식했나보네요.";
                            break;
                    }
                }
            }catch (Exception e){

            }

        }
    }

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


}
