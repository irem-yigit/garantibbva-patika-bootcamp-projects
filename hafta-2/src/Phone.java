public class Phone extends Product {

    String phoneNumber;

    public Phone(int id, String name, double price,String phoneNumber) {
        super(id, name, price);
        this.phoneNumber = phoneNumber;
    }

    public Phone() {
    }
}
