package io.github.ndimovt;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.github.ndimovt.adapter.ContactsAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContactsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        ListView listView = findViewById(R.id.contacts);

        ContactService contactService = new ContactService();

        List<Map.Entry<Character, TreeMap<String, Contact>>> entries = new ArrayList<>(contactService.getCONTACTS().entrySet());
        ContactsAdapter contactsAdapter = new ContactsAdapter(this, entries);
        listView.setAdapter(contactsAdapter);
    }
}