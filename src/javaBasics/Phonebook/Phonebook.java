package javaBasics.Phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        PhoneContacts phoneBook = new PhoneContacts();

        System.out.println("Привет!");
        //создание списка групп:
        while (true) {
            System.out.println("Введите название группы ('end' для завершения формирования списка групп):");
            scanData = scan.nextLine();
            scanData = scanData.trim();

            if (scanData.equals("end")) {
                writePhoneBook(phoneBook);
                break;
            }
            phoneBook.addGroup(scanData);
        }

        //создание контакта и добавление его в группу:
        String nameContact;
        String numberContact;
        while (true) {
            System.out.println("Введите через пробел имя и номер контакта в формате +номер." +
                    "('end' для завершения формирования списка контактов):");
            scanData = scan.nextLine();
            scanData = scanData.trim();

            if (scanData.equals("end")) {
                writePhoneBook(phoneBook);
                break;
            }

            try {
                nameContact = scanData.substring(0, scanData.indexOf("+") - 1).trim();
                numberContact = scanData.substring(scanData.indexOf("+"));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Неправильный формат ввода номера");
                continue;
            }

            System.out.println("Укажите группы контакта через пробел:");
            scanData = scan.nextLine();
            scanData = scanData.trim();
            String[] groupArray = scanData.split("\\s+");
            for (String group : groupArray) {
                phoneBook.addContactToGroup(group, new Contact(nameContact, numberContact));
            }
        }

        scan.close();
    }

    public static void writePhoneBook(PhoneContacts phoneBook) {
        System.out.println("Группы в справочнике:");
        for (Map.Entry<String, ArrayList<Contact>> entry : phoneBook.getContactMap().entrySet()) {
            System.out.println(" - " + entry.getKey());
            for (Contact contact : entry.getValue()) {
                System.out.println(contact.toString());
            }
        }
    }

}
