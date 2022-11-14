

public class Main extends Thread{

    static int gameOver;

    String onewName;

    public static void main(String[] args) {
        Start st = new Start();
        st.getCheckButton().addActionListener(e -> {

            if(st.getReadText().getText().equals("")){
                st.setSubText("이름은 비워둘 수 없습니다.");
                 return;
            }
            st.getF().dispose();
            new Main(st.getReadText().getText());
        });
    }

    Main(String onewName){
        this.onewName=onewName;
        start();
    }

    @Override
    public void run() {

        new Lobby(new Onew(onewName));

    }
}