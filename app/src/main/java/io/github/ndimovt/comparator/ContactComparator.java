package io.github.ndimovt.comparator;

import io.github.ndimovt.model.Contact;

import java.util.Comparator;

/**
 * The class ContactComparator.
 */
public class ContactComparator implements Comparator<Contact> {
    /**
     * Compares objects by names.
     * @param contact Contact object
     * @param t1 Contact object
     * @return Int primitive
     */
    @Override
    public int compare(Contact contact, Contact t1) {
        return contact.getName().compareTo(t1.getName());
    }
}
