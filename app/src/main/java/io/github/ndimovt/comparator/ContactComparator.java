package io.github.ndimovt.comparator;

import io.github.ndimovt.model.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact contact, Contact t1) {
        return contact.getName().compareTo(t1.getName());
    }
}
