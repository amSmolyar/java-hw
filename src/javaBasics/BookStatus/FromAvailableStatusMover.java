package javaBasics.BookStatus;

public class FromAvailableStatusMover extends BookMover {

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        if (book.getStatus() == Status.AVAILABLE) {
            switch (requestedStatus) {
                case ARCHIVED:
                    book.setStatus(requestedStatus);
                    System.out.println("Status was successfully changed to " + requestedStatus + ".");
                    break;
                case AVAILABLE:
                    System.out.println("The book already has the required status.");
                    break;
                case BORROWED:
                    book.setStatus(requestedStatus);
                    System.out.println("Status was successfully changed to " + requestedStatus + ".");
                    break;
                case OVERDUED:
                    System.out.println("Status OVERDUED is not available.");
                    break;
            }
        } else
            System.out.println("Try to call method from another class (to move from " + book.getStatus() + " status).");
    }

}
