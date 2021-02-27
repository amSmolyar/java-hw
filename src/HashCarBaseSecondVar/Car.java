package HashCarBaseSecondVar;

public class Car extends Transport {

    public Car(String number, String brand, String colour) {
        super(number, brand, colour, "car");
    }

    @Override
    public String toString() {
        return String.format("  Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
