package HashCarBase;

public class Car extends Transport {

    public Car(String number, String brand, String colour) {
        super(number, brand, colour, "car");
        this.id = 3;
    }

    @Override
    public String getType() {
        return "car";
    }

    @Override
    public String toString() {
        return String.format("Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
