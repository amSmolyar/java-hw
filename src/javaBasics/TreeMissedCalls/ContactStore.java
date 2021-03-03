package javaBasics.TreeMissedCalls;

import java.util.HashMap;
import java.util.Map;

public class ContactStore {
    private Map<String, Contact> contactMap;

    public ContactStore() {
        contactMap = new HashMap<>();
    }

    public Map<String, Contact> getContactMap() {
        return contactMap;
    }

    public void addContact(Contact newContact) {
        contactMap.put(newContact.getNumber(), newContact);
    }

    public boolean changeContact(String surname, String name, Contact newContact) {
        if (contactMap.isEmpty()) {
            System.out.println("Список контактов пустой");
            return true;
        } else {
            for (Contact contact : contactMap.values()) {
                if (contact.getSurname().equals(surname) && contact.getName().equals(name)) {
                    contactMap.put(contact.getNumber(), newContact);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeContact(String surname, String name) {
        if (contactMap.isEmpty()) {
            System.out.println("Список контактов пустой");
            return true;
        } else {
            for (Contact contact : contactMap.values()) {
                if (contact.getSurname().equals(surname) && contact.getName().equals(name)) {
                    contactMap.remove(contact.getNumber());
                    return true;
                }
            }
        }
        return false;
    }
}
