package HashCarBaseSecondVar;

public class Transport {
    protected String number;
    protected String brand;
    protected String colour;
    protected String type;

    public Transport(String number, String brand, String colour, String type) {
        this.number = number;
        this.brand = brand;
        this.colour = colour;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !Transport.class.isAssignableFrom(o.getClass())) return false;
        Transport transport = (Transport) o;
        return number.equals(transport.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return String.format("  Номер: %s, Модель: %s, Цвет: %s, Тип транспорта: %s", number, brand, colour, type);
    }
}
