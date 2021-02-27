package HashCarBaseSecondVar;

public class SpecialTransport extends Transport {

    public SpecialTransport(String number, String brand, String colour) {
        super(number, brand, colour, "special transport");
    }

    @Override
    public String toString() {
        return String.format("  Номер: %s, Модель: %s, Цвет: %s", number, brand, colour);
    }
}
