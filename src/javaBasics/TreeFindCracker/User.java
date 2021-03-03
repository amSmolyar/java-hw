package javaBasics.TreeFindCracker;

public class User {
    private String id;
    private String name;
    private String address;


    public User(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ФИО : %s\nАдрес : %s", name, address);
    }

}
