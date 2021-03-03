package javaBasics.TreeMissedCalls;

public class TreeMissedCalls {

    public static void main(String[] args) {
        UserScanner scanner = new UserScanner();
        ContactStore contacts = new ContactStore();
        MissedCalls missedCalls = new MissedCalls();

        addContacts(contacts);
        addMissedCalls(missedCalls);

        System.out.println("Привет!");
        while (true) {
            if (!scanner.selectAction(missedCalls, contacts)) {
                System.out.println("\nПока!");
                break;
            }
        }
        scanner.closeScanner();
    }

    private static void addContacts(ContactStore contacts) {
        contacts.addContact(
                new Contact("Пашкин", "Максим", "+7 921 123 45 67", EnumGroup.FRIENDS));
        contacts.addContact(
                new Contact("", "Мама", "+7 925 123 45 67", EnumGroup.FAMILY));
        contacts.addContact(
                new Contact("", "Папа", "+7 995 123 45 67", EnumGroup.FAMILY));
        contacts.addContact(
                new Contact("Колобков", "Евгений", "+7 999 123 45 67", EnumGroup.WORK));
    }

    private static void addMissedCalls(MissedCalls missedCalls) {
        missedCalls.addMissedCall("+7 911 456 56 34");
        missedCalls.addMissedCall("+7 921 123 45 67");
        missedCalls.addMissedCall("+7 565 456 89 23");
        missedCalls.addMissedCall("+7 995 123 45 67");
        missedCalls.addMissedCall("+7 999 889 34 65");
    }
}
