package javaBasics.HashCarBaseSecondVar;

public class Truck extends Transport {

    public Truck(String number, String brand, String colour) {
        super(number, brand, colour, "truck");
    }

    @Override
    public String toString() {
        return String.format("  Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
