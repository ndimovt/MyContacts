package io.github.ndimovt.service;

import io.github.ndimovt.model.Contact;

import java.util.Map;
import java.util.TreeMap;

public class ContactService {
    private final Map<Character, TreeMap<String, Contact>> CONTACTS = new TreeMap<>();

    {
        Contact anton = new Contact("Anton", "Mobile", "0876517651", "Home", "anton@abv.bg");
        Contact boris = new Contact("Boris", "Work", "0888123456", "Work", "boris@example.com");
        Contact carla = new Contact("Carla", "Mobile", "0899123456", "Home", "carla@gmail.com");
        Contact david = new Contact("David", "Work", "0877654321", "Office", "david@yahoo.com");
        Contact elena = new Contact("Elena", "Mobile", "0888999777", "Home", "elena@hotmail.com");
        Contact elenaPetrova = new Contact("Elena Petrova", "Mobile", "0888999767", "Home", "elenaP@hotmail.com");

        TreeMap<String, Contact> contactsForA = new TreeMap<>();
        contactsForA.put(anton.getPhone(), anton);

        TreeMap<String, Contact> contactsForB = new TreeMap<>();
        contactsForB.put(boris.getPhone(), boris);

        TreeMap<String, Contact> contactsForC = new TreeMap<>();
        contactsForC.put(carla.getPhone(), carla);

        TreeMap<String, Contact> contactsForD = new TreeMap<>();
        contactsForD.put(david.getPhone(), david);

        TreeMap<String, Contact> contactsForE = new TreeMap<>();
        contactsForE.put(elena.getPhone(), elena);
        contactsForE.put(elenaPetrova.getPhone(), elenaPetrova);

        CONTACTS.put('A', contactsForA);
        CONTACTS.put('B', contactsForB);
        CONTACTS.put('C', contactsForC);
        CONTACTS.put('D', contactsForD);
        CONTACTS.put('E', contactsForE);
    }
    public Map<Character, TreeMap<String, Contact>> getCONTACTS() {
        return CONTACTS;
    }

    public void updateContact(Contact contact){
        String key = contact.getPhone();
        char letter = Character.toUpperCase(contact.getName().charAt(0));
        if(CONTACTS.containsKey(letter)){
            TreeMap<String, Contact> contacts = CONTACTS.get(letter);
            if(contacts != null){
                contacts.remove(key);
                contacts.put(key, contact);
            }
        }
    }
}
