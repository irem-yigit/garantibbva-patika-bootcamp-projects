public class SmartPhone extends Phone {

    private int storage;
    private int ram;
    private String camera;

    public SmartPhone() {
    }

    public SmartPhone(int id, String name, double price, String phoneNumber, int storage, int ram, String camera) {
        super(id, name, price,phoneNumber);
        this.storage = storage;
        this.ram = ram;
        this.camera = camera;
    }
}
