package javaBasics.HashCarBase;

public class SpecialTransport extends Transport {

    public SpecialTransport(String number, String brand, String colour) {
        super(number, brand, colour, "special transport");
        this.id = 1;
    }

    @Override
    public String getType() {
        return "special transport";
    }

    @Override
    public String toString() {
        return String.format("Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
