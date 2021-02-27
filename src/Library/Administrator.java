package Library;

public interface Administrator {
    boolean findBook(String bookWanted);

    void giveBook(String bookWanted);

    void addBook(String book);

    default void overdueNotification(Reader reader) {
        System.out.println(reader.getSurname() + ", верни книгу!");
    }
}
