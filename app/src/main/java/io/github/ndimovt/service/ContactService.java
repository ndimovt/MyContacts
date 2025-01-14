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
        contacts.add(new Contact(6,"Elena Petrova", "Mobile", "0888999767", "Home", "elenaP@hotmail.com"));
        contacts.add(new Contact(2,"Boris", "Work", null, "Work", "boris@example.com"));
        contacts.add(new Contact(1,"Anton", "Mobile", "0876517651", "Home", "anton@abv.bg"));
        contacts.add(new Contact(4,"David", "Work", "0877654321", "Office", "david@yahoo.com"));
        contacts.add(new Contact(5,"Elena", "Mobile", "0888999777", "Home", null));
        contacts.add(new Contact(3,"Carla", "Mobile", "0899123456", "Home", "carla@gmail.com"));

    }
    public List<Contact> getContacts() {
        Collections.sort(contacts, comparator);
        return contacts;
    }
}
