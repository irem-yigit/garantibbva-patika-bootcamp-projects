package GameApp;

public class Playstation extends Device{

    PlaystationController playstationController;

    @Override
    public void addController(GameController gameController){
        if (gameController instanceof PlaystationController){
            System.out.println("Playstation başarıyla bağlandı.");
        }
        else {
            System.out.println("Playstation'a sadece PlaystationController bağlanabilir!!");
        }
    }

    @Override
    public void addController() {

    }

    @Override
    public void open() throws Exception {
        if (!isOpen){
            throw new Exception("Playstation zaten açık!!");
        }
        else {
            System.out.println("Playstation açıldı.");
        }
    }

    @Override
    public void shutDown() throws Exception {
        if (isOpen){
            System.out.println("Playstation kapandı.");
        }
        else {
            throw new Exception("Playstation zaten kapalı!!");
        }

    }

    @Override
    public void playGame() throws Exception {
        if (!isOpen){
            throw new Exception("Playstation zaten kapalı!!");
        }
        else {
            System.out.println("Playstation başladı.");
        }
    }
}
