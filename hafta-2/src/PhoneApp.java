public class PhoneApp {

    SmartPhone[] smartPhones = new SmartPhone[]{
            new SmartPhone(1, "Nokia", 1000, "05212122121", 32, 6, "5 MP"),
            new SmartPhone(2,"Samsung", 2000, "05212124141", 64, 8, "8 MP"),
            new SmartPhone(3, "Google Nexus", 3000, "05212126161", 128, 10, "8 MP"),
            new SmartPhone(4, "LG", 4000, "05212128181", 256, 12, "10 MP"),
            new SmartPhone(5, "Huawei", 5000, "05212129191", 512, 8, "12 MP")};

    double calculateTotalPrice(SmartPhone[] smartPhones){
        double total = 0;

        for(SmartPhone smartPhone : smartPhones){
            total += smartPhone.getPrice();
        }
        return total;
    }
}

