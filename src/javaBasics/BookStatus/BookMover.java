package javaBasics.BookStatus;

public class BookMover {
    protected void moveToStatus(Book book, Status requestedStatus) {
        System.out.println("\nNeed to change the status of the book '" + book.getTitle() + "' from " + book.getStatus() + " to " + requestedStatus + ".");
    }
}
