package GameApp;

public class Playstation extends Device{

    PlaystationController playstationController;

    @Override
    public void addController(GameController gameController){
        if (gameController instanceof PlaystationController){
            this.playstationController = (PlaystationController) gameController;
            System.out.println("Playstation başarıyla bağlandı.");
        }
        else {

            System.out.println("Playstation'a sadece PlaystationController bağlanabilir!!");
        }
    }


}
