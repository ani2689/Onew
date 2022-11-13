

public class Main extends Thread{

    static int gameOver;

    static String name;

    public static void main(String[] args) {
        Start s=new Start();
        s.getCheckButton().addActionListener(e -> {
            s.getF().dispose();
            name = s.getReadText().getText();
            new Main();
        });
    }
}