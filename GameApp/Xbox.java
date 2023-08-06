package GameApp;

public class Xbox extends Device{

    private XboxController xboxController;

    @Override
    public void addController(GameController gameController){
        if (gameController instanceof XboxController){
            this.xboxController = (XboxController) gameController;
            System.out.println("Xbox başarıyla bağlandı.");
        }
        else {
            System.out.println("Xbox'a sadece XboxController bağlanabilir!!");
        }
    }


}
