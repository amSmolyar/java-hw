package HashCarBase;

public class Truck extends Transport {

    public Truck(String number, String brand, String colour) {
        super(number, brand, colour, "car");
        this.id = 2;
    }

    @Override
    public String getType() {
        return "truck";
    }

    @Override
    public String toString() {
        return String.format("Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
