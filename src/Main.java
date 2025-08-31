package GameApp;

public class Main {
    public static void main(String[] args) throws Exception {

        Xbox xbox = new Xbox();
        Playstation playstation = new Playstation();
        Computer computer = new Computer();

        XboxController xboxController = new XboxController();
        xbox.addController(xboxController);
        xbox.open();
        xbox.playGame();

        PlaystationController playstationController = new PlaystationController();
        playstation.addController(playstationController);
        playstation.open();
        playstation.playGame();


        computer.addController(playstationController);
        computer.open();
        computer.playGame();
    }
}
