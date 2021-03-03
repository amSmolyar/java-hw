package javaBasics.Library;

public interface Reader {
    void takeBook(Administrator administrator, String book);

    void returnBook(Administrator administrator);

    default String getSurname() {
        return "Admin";
    }
}
