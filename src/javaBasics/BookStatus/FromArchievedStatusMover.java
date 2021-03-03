package javaBasics.BookStatus;

public class FromArchievedStatusMover extends BookMover {

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        if (book.getStatus() == Status.ARCHIVED) {
            switch (requestedStatus) {
                case ARCHIVED:
                    System.out.println("The book already has the required status");
                    break;
                case AVAILABLE:
                    book.setStatus(requestedStatus);
                    System.out.println("Status was successfully changed to " + requestedStatus + ".");
                    break;
                case BORROWED:
                    System.out.println("Status BORROWED is not available for archived book.");
                    break;
                case OVERDUED:
                    System.out.println("Status OVERDUED is not available for archived book.");
                    break;
            }
        } else
            System.out.println("Try to call method from another class (to move from " + book.getStatus() + " status).");
    }
}
