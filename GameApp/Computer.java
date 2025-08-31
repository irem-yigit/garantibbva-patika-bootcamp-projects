package GameApp;

public class Computer extends Device{

    private GameController gameController;

    @Override
    public void addController(GameController gameController ){
        this.gameController = gameController;
        System.out.println("GameController başarıyla bağlandı.");

    }

}
