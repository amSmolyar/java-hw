package BookStatus;

class Main {
    public static void main(String[] args) {
        Book book = new Book("The call of the wild");

        FromArchievedStatusMover fromArchievedStatusMover = new FromArchievedStatusMover();

        FromAvailableStatusMover fromAvailableStatusMover = new FromAvailableStatusMover();

        FromBorrowedStatusMover fromBorrowedStatusMover = new FromBorrowedStatusMover();

        FromOverduedStatusMover fromOverduedStatusMover = new FromOverduedStatusMover();

        // Ошибочные варианты:
        fromArchievedStatusMover.moveToStatus(book, Status.BORROWED);
        fromArchievedStatusMover.moveToStatus(book, Status.AVAILABLE);
        //===
        fromAvailableStatusMover.moveToStatus(book, Status.ARCHIVED);
        fromArchievedStatusMover.moveToStatus(book, Status.AVAILABLE);
        fromAvailableStatusMover.moveToStatus(book, Status.BORROWED);
        fromBorrowedStatusMover.moveToStatus(book, Status.OVERDUED);
        fromOverduedStatusMover.moveToStatus(book, Status.AVAILABLE);
    }
}
