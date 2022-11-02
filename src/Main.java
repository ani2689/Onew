

public class Main{

    static int gameOver;
    Onew o = new Onew("히");
    public static void main(String[] args) {
        new Main();
    }

    Main(){
        lobbyFrame();
    }

    public void lobbyFrame(){
        new Lobby(o);
    }
}