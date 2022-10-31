import javax.swing.*;



public class Main {


    static JFrame f = new JFrame();

    public static void main(String[] args) {
        new Main();
    }

    Main(){
        lobbyFrame();
    }

    public void gardenFrame(){
        new Garden();
    }

    public void lobbyFrame(){
        new Lobby();
    }
}