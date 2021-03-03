package javaBasics.Phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PhoneContacts {
    private Map<String, ArrayList<Contact>> contactMap;

    public PhoneContacts() {
        contactMap = new HashMap<>();
    }

    public PhoneContacts(Map<String, ArrayList<Contact>> contactMap) {
        this.contactMap = contactMap;
    }

    public Map<String, ArrayList<Contact>> getContactMap() {
        return contactMap;
    }

    public void addGroup(String newGroup) {
        if (!contactMap.containsKey(newGroup))
            contactMap.put(newGroup, new ArrayList<Contact>());
        else
            System.out.println("Группа " + newGroup + " уже существует");
    }

    public boolean addContactToGroup(String group, Contact contact) {
        if (contactMap.containsKey(group)) {
            ArrayList<Contact> contactList = contactMap.get(group);
            contactList.add(contact);
            Collections.sort(contactList);
            contactMap.put(group, contactList);
            return true;
        } else
            System.out.println("Группы " + group + " не существует");

        return false;
    }
}
