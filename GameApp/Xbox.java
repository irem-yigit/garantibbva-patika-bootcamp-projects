package GameApp;

public class Xbox extends Device{

    XboxController xboxController;

    @Override
    public void addController(GameController gameController){
        if (gameController instanceof XboxController){
            System.out.println("Xbox başarıyla bağlandı.");
        }
        else {
            System.out.println("Xbox'a sadece XboxController bağlanabilir!!");
        }
    }

    @Override
    public void addController() {

    }

    @Override
    public void open() throws Exception {
        if (!isOpen){
            throw new Exception("Xbox zaten açık!!");
        }
        else {
            System.out.println("Xbox açıldı.");
        }
    }

    @Override
    public void shutDown() throws Exception {
        if (isOpen){
            System.out.println("Xbox kapandı.");
        }
        else {
            throw new Exception("Xbox zaten kapalı!!");
        }

    }

    @Override
    public void playGame() throws Exception {
        if (!isOpen){
            throw new Exception("Xbox zaten kapalı!!");
        }
        else {
            System.out.println("Xbox başladı.");
        }
    }
}
