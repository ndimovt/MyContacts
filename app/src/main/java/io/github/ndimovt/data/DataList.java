package io.github.ndimovt.data;

import io.github.ndimovt.comparator.ContactComparator;
import io.github.ndimovt.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class DataList.
 */
public class DataList {
    private static DataList dataList;
    private static final List<Contact> CONTACTS = new ArrayList<>();
    private static final ContactComparator COMPARATOR = new ContactComparator();
    private DataList(){
        CONTACTS.add(new Contact(6,"Elena Petrova","Work", null, "Work", "boris@example.com"));
        CONTACTS.add(new Contact(2,"Boris", "Work", null, "Work", "boris@example.com"));
        CONTACTS.add(new Contact(1,"Anton", "Mobile", "0876517651", "Main", "anton@abv.bg"));
        CONTACTS.add(new Contact(4,"David", "Work", "0877654321", "Office", "david@yahoo.com"));
        CONTACTS.add(new Contact(5,"Elena", "Home", "0888999777", "Main", null));
        CONTACTS.add(new Contact(3,"Carla", "Mobile", "0899123456", "School", "carla@gmail.com"));
        Collections.sort(CONTACTS, COMPARATOR);
    }

    /**
     * Returns DataList instance.
     * @return DataList instance
     */
    public static DataList getInstance(){
        if(dataList == null){
            dataList = new DataList();
        }
        return dataList;
    }

    /**
     * Returns List object.
     * @return List object
     */
    public List<Contact> getContacts(){
        return CONTACTS;
    }

}
