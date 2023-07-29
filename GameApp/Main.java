package GameApp;

public class Main {
    public static void main(String[] args) throws Exception {

        Xbox xbox = new Xbox();
        Playstation playstation = new Playstation();
        Computer computer = new Computer();

        xbox.addController();
        xbox.open();
        xbox.shutDown();
        xbox.playGame();

        playstation.addController();
        playstation.open();
        playstation.shutDown();
        playstation.playGame();

        computer.addController();
        computer.open();
        computer.shutDown();
        computer.playGame();
    }
}
