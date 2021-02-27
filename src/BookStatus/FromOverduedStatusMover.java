package BookStatus;

public class FromOverduedStatusMover extends BookMover {

    public void moveToStatus(Book book, Status requestedStatus) {
        super.moveToStatus(book, requestedStatus);

        if (book.getStatus() == Status.OVERDUED) {
            switch (requestedStatus) {
                case ARCHIVED:
                    book.setStatus(requestedStatus);
                    System.out.println("Status was successfully changed to " + requestedStatus + ".");
                    break;
                case AVAILABLE:
                    book.setStatus(requestedStatus);
                    System.out.println("Status was successfully changed to " + requestedStatus + ".");
                    break;
                case BORROWED:
                    System.out.println("Status BORROWED is not available for overdued book.");
                    break;
                case OVERDUED:
                    System.out.println("The book already has the required status");
                    break;
            }
        } else
            System.out.println("Try to call method from another class (to move from " + book.getStatus() + " status).");
    }

}
