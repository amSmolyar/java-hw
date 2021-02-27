package Library;

public class SupplierClass implements Supplier, Reader {
    private String surname;
    private String bookTitle;

    public SupplierClass(String surname) {
        this.surname = surname;
        bookTitle = "";
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public void takeBook(Administrator administrator, String book) {
        System.out.println("Я ваш поставщик. Моя фамилия " + this.surname + ". Я хочу взять в библиотеке " + book);
        if (administrator.findBook(book)) {
            administrator.giveBook(book);
            this.bookTitle = book;
            System.out.println("Ура, беру!");
        } else {
            administrator.giveBook(book);
            //System.out.println("Жаль. Зайду позже!");
        }

    }

    @Override
    public void returnBook(Administrator administrator) {
        System.out.println("Я ваш поставщик. Моя фамилия " + this.surname + ". Возвращаю в библиотеку " + this.bookTitle);
        administrator.addBook(this.bookTitle);
    }

    @Override
    public void bringBook(Librarian librarian, String book) {
        System.out.println("Без проблем, скоро привезу!");
        System.out.println("Вот ваша книга.");
        librarian.acceptBook(book);
    }

}
