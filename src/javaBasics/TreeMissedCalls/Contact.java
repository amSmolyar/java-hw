package javaBasics.TreeMissedCalls;

public class Contact {
    private String surname;
    private String name;
    private String number;
    private EnumGroup group;

    public Contact(String surname, String name, String number, EnumGroup group) {
        this.surname = surname;
        this.name = name;
        this.number = number;
        this.group = group;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public EnumGroup getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return String.format("%s %s, тел. %s    (%s)", this.surname, this.name, this.number, this.group);
    }
}
