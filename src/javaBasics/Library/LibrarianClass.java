package javaBasics.Library;

import java.util.ArrayList;

public class LibrarianClass implements Reader, Administrator, Librarian {
    private ArrayList<String> bookAll;
    private String bookTitle;
    private Supplier supplier;

    private static int bookCount = 0;
    private static int bookIndex = 0;

    public LibrarianClass(Supplier supplier) {
        this.supplier = supplier;
        this.bookTitle = "";

        bookAll = new ArrayList<String>();
        bookAll.add("book1");
        bookAll.add("book2");
        bookAll.add("book3");
        bookAll.add("book4");

        bookCount = 4;
        bookIndex = 0;
    }

    @Override
    public boolean findBook(String bookWanted) {
        boolean tmp = false;
        for (int ii = 0; ii < bookAll.toArray().length; ii++) {
            if (bookWanted.equals(bookAll.toArray()[ii])) {
                tmp = true;
                bookIndex = ii;
            }
        }
        return tmp;
    }

    @Override
    public void giveBook(String bookWanted) {
        if (findBook(bookWanted)) {
            System.out.println("Отлично, нашел, есть такая книга!");
            bookAll.remove(bookIndex);
            bookCount--;
            System.out.println("Книга выдана!");
        } else {
            System.out.println("К сожалению, такой книги нет. Закажем!");
            orderBook(this.supplier, bookWanted);
        }
    }

    @Override
    public void addBook(String book) {
        System.out.println("Спасибо за книгу, положим ее сюда.");
        bookAll.add(book);
        bookCount++;
    }

    @Override
    public void takeBook(Administrator administrator, String bookWanted) {
        System.out.println("Я библиотекарь. Хочу почитать " + bookWanted);

        if (administrator.findBook(bookWanted)) {
            administrator.giveBook(bookWanted);
            System.out.println("Ура, беру!");
            this.bookTitle = bookWanted;
        } else {
            administrator.giveBook(bookWanted);
            //System.out.println("Жаль. Посмотрю позже!");
        }

    }

    @Override
    public void returnBook(Administrator administrator) {
        System.out.println("\nХочу вернуть" + this.bookTitle);
        administrator.addBook(this.bookTitle);
    }

    @Override
    public void orderBook(Supplier supplier, String book) {
        System.out.println("\nПривет! Привези мне, пожалуйста, книгу " + book + ".");
        supplier.bringBook(this, book);
    }

    @Override
    public void acceptBook(String book) {
        System.out.println("Вы очень надежный поставщик!");
        addBook(book);
    }

}
