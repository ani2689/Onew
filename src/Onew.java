import javax.swing.*;

public class Onew extends Thread{

    String name;
    private int full=100;
    private int hp=100;

    String costume="";

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
                sleep(1000);
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
                            Lobby.messegeText ="오뉴가 죽을 자경이에요!";
                            break;
                        case 1:
                            Lobby.messegeText ="어서 밥을 주세요!";
                            break;
                        case 2:
                            Lobby.messegeText ="오뉴는 지금 배가 고프다는데...";
                            break;
                        case 3:
                            Lobby.messegeText ="이런! 창고가 비었나요?";
                            break;
                        case 4:
                            Lobby.messegeText ="과도한 단식은 위험해요.";
                            break;
                    }
                }else if(hp<=60) {
                    switch ((int)(Math.random()*5)){
                        case 0:
                            Lobby.messegeText = "오뉴가 배가 고프다며 투정을 부려요.";
                            break;
                        case 1:
                            Lobby.messegeText ="이런! 창고가 비었나요?";
                            break;
                        case 2:
                            Lobby.messegeText ="오뉴는 지금 배가 고프다는데...";
                            break;
                        case 3:
                            Lobby.messegeText ="이러다가는 배가 등가죽에 붙겠어요...";
                            break;
                        case 4:
                            Lobby.messegeText ="오뉴는 열심히 운동하고 있어요!";
                            break;
                    }
                }else if(full<=50){
                    switch ((int)(Math.random()*5)){
                    case 0:
                        Lobby.messegeText = "오뉴는 지금 기분이 좋아요.";
                        break;
                    case 1:
                        Lobby.messegeText ="밥주는 시간을 잊은 건 아니죠?";
                        break;
                    case 2:
                        Lobby.messegeText ="꾸준히 먹어야 튼튼해져요.";
                        break;
                    case 3:
                        Lobby.messegeText ="적당한 음식투정은 괜찮겠죠?";
                        break;
                    case 4:
                        Lobby.messegeText ="오뉴는 열심히 운동하고 있어요!";
                        break;

                    }
                }else if(full<=80){
                    switch ((int)(Math.random()*5)) {
                        case 0:
                            Lobby.messegeText = "오뉴는 지금 기분이 좋아요.";
                            break;
                        case 1:
                            Lobby.messegeText = "오뉴는 지금 충분히 베가 불러요";
                            break;
                        case 2:
                            Lobby.messegeText = "꾸준히 먹어야 튼튼해져요.";
                            break;
                        case 3:
                            Lobby.messegeText = "적당한 음식투정은 괜찮겠죠?";
                            break;
                        case 4:
                            Lobby.messegeText = "포식했나?";
                            break;
                    }
                }else{
                    switch ((int)(Math.random()*5)) {
                        case 0:
                            Lobby.messegeText = "오뉴는 지금 기분이 좋아요.";
                            break;
                        case 1:
                            Lobby.messegeText = "오뉴는 행복하답니다.";
                            break;
                        case 2:
                            Lobby.messegeText = "꾸준히 먹어야 튼튼해져요.";
                            break;
                        case 3:
                            Lobby.messegeText = "오뉴는 체중따위 신경쓰지 않아요!";
                            break;
                        case 4:
                            Lobby.messegeText = "포식했나보네요.";
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
