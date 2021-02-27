package Phonebook;

public class Contact implements Comparable<Contact> {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("      Имя: %s, Телефон: %s", this.name, this.number);
    }

    @Override
    public int compareTo(Contact anotherContact) {
        String name1 = this.getName();
        String name2 = anotherContact.getName();
        return name1.compareTo(name2);
    }
}



