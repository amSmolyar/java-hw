package Library;

public class Library {
    public static void main(String[] args) {
        SupplierClass supplier = new SupplierClass("Петров");
        LibrarianClass librarian = new LibrarianClass(supplier);
        ReaderClass reader = new ReaderClass("Плюшкин");

        System.out.println("=========== Читатель приходит за книгой ===========");
        reader.takeBook(librarian, "book1");
        librarian.overdueNotification(reader);
        reader.returnBook(librarian);

        System.out.println("=========== Библиотекарь хочет почитать ===========");
        librarian.takeBook(librarian, "book10");

        System.out.println("=========== Поставщик хочет почитать ===========");
        supplier.takeBook(librarian, "book10");
        supplier.returnBook(librarian);
    }
}
