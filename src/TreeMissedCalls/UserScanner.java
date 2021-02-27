package TreeMissedCalls;

import java.util.Scanner;

public class UserScanner {
    private Scanner scan;
    private Contact newContact;

    public UserScanner() {
        scan = new Scanner(System.in);
    }

    public void closeScanner() {
        scan.close();
    }

    public boolean selectAction(MissedCalls missedCalls, ContactStore contacts) {
        int cmd;
        boolean result;
        String[] contactName;

        System.out.println("\nВыберите действие: \n" +
                "1. Добавить контакт;\n" +
                "2. Добавить пропущенный вызов;\n" +
                "3. Вывести все пропущенные вызовы;\n" +
                "4. Очистить пропущенные вызовы;\n" +
                "5. Редактировать контакт;\n" +
                "6. Удалить контакт;\n" +
                "7. Выход;");

        String scanData = scan.nextLine().trim();
        try {
            cmd = Integer.parseInt(scanData);
        } catch (NumberFormatException e) {
            System.out.println("Введенные данные не корректны");
            return true;
        }

        switch (cmd) {
            case (1):
                System.out.println("Введите данные нового контакта (фамилия, имя, номер, группа(семья, друзья, работа)):");
                scanData = scan.nextLine().trim();
                try {
                    newContact = detectContact(scanData);
                    contacts.addContact(newContact);
                } catch (DataFormatException e) {
                    System.out.println(e.getMessage());
                }
                result = true;
                break;
            case (2):
                System.out.println("Добавьте номер пропущенного вызова:");
                scanData = scan.nextLine().trim();
                missedCalls.addMissedCall(scanData);
                result = true;
                break;
            case (3):
                missedCalls.writeMissedCalls(contacts);
                result = true;
                break;
            case (4):
                missedCalls.clearMissedCalls();
                result = true;
                break;
            case (5):
                System.out.println("Введите наименование контакта, который хотите редактировать (фамилия, имя)):");
                scanData = scan.nextLine().trim();
                try {
                    contactName = detectName(scanData);
                    System.out.println("Введите новые данные контакта (фамилия, имя, номер, группа(семья, друзья, работа)):");
                    scanData = scan.nextLine().trim();
                    try {
                        newContact = detectContact(scanData);
                        contacts.changeContact(contactName[0], contactName[1], newContact);
                    } catch (DataFormatException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (DataFormatException e) {
                    System.out.println(e.getMessage());
                }
                result = true;
                break;
            case (6):
                System.out.println("Введите наименование контакта, который хотите удалить (фамилия, имя)):");
                scanData = scan.nextLine().trim();
                try {
                    contactName = detectName(scanData);
                    contacts.removeContact(contactName[0], contactName[1]);
                } catch (DataFormatException e) {
                    System.out.println(e.getMessage());
                }
                result = true;
                break;
            case (7):
                result = false;
                break;
            default:
                System.out.println("Данной команды нет в списке");
                result = true;
                break;
        }

        return result;
    }

    public Contact detectContact(String scanData) throws DataFormatException {
        String[] arrayIn = scanData.split("[,:;.]");
        String surname;
        String name;
        String number;
        String group;
        EnumGroup enumGroup;

        if (arrayIn.length == 3) {
            surname = "";
            name = arrayIn[0].trim();
            number = arrayIn[1].trim();
            group = arrayIn[2].trim().toUpperCase();
        } else if (arrayIn.length == 4) {
            surname = arrayIn[0].trim();
            name = arrayIn[1].trim();
            number = arrayIn[2].trim();
            group = arrayIn[3].trim().toUpperCase();
        } else {
            throw new DataFormatException("Неправильный формат введенных данных");
        }

        switch (group) {
            case ("СЕМЬЯ"):
                group = "FAMILY";
                break;
            case ("ДРУЗЬЯ"):
                group = "FRIENDS";
                break;
            case ("РАБОТА"):
                group = "WORK";
                break;
            default:
                break;
        }

        try {
            enumGroup = EnumGroup.valueOf(group);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new DataFormatException("Неподходящее название группы контактов");
        }

        return new Contact(surname, name, number, enumGroup);
    }

    public String[] detectName(String scanData) throws DataFormatException {
        String[] arrayIn = scanData.split("[,:;.]");
        String[] contactName = new String[]{"surname", "name"};

        if (arrayIn.length == 1) {
            contactName[0] = "";
            contactName[1] = arrayIn[0].trim();
        } else if (arrayIn.length == 2) {
            contactName[0] = arrayIn[0].trim();
            contactName[1] = arrayIn[1].trim();
        } else {
            throw new DataFormatException("Неправильный формат введенных данных");
        }

        return contactName;
    }
}


