package GameApp;

public abstract class Device {

    public Boolean isOpen = false;
    public GameController gameController;

   public void addController(GameController gameController ){
        this.gameController = gameController;

    }

    public abstract void addController();

    public void open() throws Exception {
        if (!isOpen){
            throw new Exception("Device zaten açık!!");
        }
        else {
            System.out.println("Device açıldı.");
        }
    }

    public void shutDown() throws Exception {
        if (isOpen){
            System.out.println("Device kapandı.");
        }
        else {
            throw new Exception("Device zaten kapalı!!");
        }

    }

    public void playGame() throws Exception {
        if (!isOpen){
            throw new Exception("Device zaten kapalı!!");
        }
        else {
            System.out.println("Oyun başladı.");
        }
    }

}
