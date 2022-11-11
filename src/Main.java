

public class Main extends Thread{

    static int gameOver;

    public static void main(String[] args) {
        Onew o = new Onew("히");
        new Lobby(o);
    }

    Main(){

    }

}