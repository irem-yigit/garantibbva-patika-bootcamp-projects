package GameApp;

public class Computer extends Device{

    GameController gameController;

    @Override
    public void addController(GameController gameController ){
        this.gameController = gameController;
        System.out.println("GameController başarıyla bağlandı.");

    }

    @Override
    public void addController() {

    }

    @Override
    public void open() throws Exception {
        if (!isOpen){
            throw new Exception("Computer zaten açık!!");
        }
        else {
            System.out.println("Computer açıldı.");
        }
    }

    @Override
    public void shutDown() throws Exception {
        if (isOpen){
            System.out.println("Computer kapandı.");
        }
        else {
            throw new Exception("Computer zaten kapalı!!");
        }

    }

    @Override
    public void playGame() throws Exception {
        if (!isOpen){
            throw new Exception("Computer zaten kapalı!!");
        }
        else {
            System.out.println("Computer başladı.");
        }
    }
}
