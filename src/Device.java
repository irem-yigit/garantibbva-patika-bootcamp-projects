package GameApp;

public abstract class Device {

    public Boolean isOpen = false;

    public abstract void addController(GameController gameController);

    public void open() throws Exception {
        if (isOpen){
            throw new Exception("Device zaten açık!!");
        }
        else {
            this.isOpen = true;
            System.out.println("Device açıldı.");
        }
    }

    public void shutDown() throws Exception {
        if (isOpen){
            this.isOpen = false;
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
