package io.github.ndimovt.service;

import io.github.ndimovt.comparator.ContactComparator;
import io.github.ndimovt.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactService {
    private final List<Contact> contacts = new ArrayList<>();
    private final ContactComparator comparator = new ContactComparator();

    public ContactService() {
        contacts.add(new Contact(6,"Elena Petrova", "Mobile", "0888999767", "Main", "elenaP@hotmail.com"));
        contacts.add(new Contact(2,"Boris", "Work", null, "Work", "boris@example.com"));
        contacts.add(new Contact(1,"Anton", "Mobile", "0876517651", "Main", "anton@abv.bg"));
        contacts.add(new Contact(4,"David", "Work", "0877654321", "Office", "david@yahoo.com"));
        contacts.add(new Contact(5,"Elena", "Home", "0888999777", "Main", null));
        contacts.add(new Contact(3,"Carla", "Mobile", "0899123456", "School", "carla@gmail.com"));

    }
    public List<Contact> getContacts() {
        Collections.sort(contacts, comparator);
        return contacts;
    }
    public void updateContact(Contact contact){
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == contact.getId()) {
                contacts.set(i, contact);
                break;
            }
        }
    }

}
