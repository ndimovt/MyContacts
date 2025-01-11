package io.github.ndimovt;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

        List<String> list = new ArrayList<>();
        ContactService contactService = new ContactService();

        for(Map.Entry<Character, TreeMap<String, Contact>> entry : contactService.getCONTACTS().entrySet()){
            list.add(entry.getKey().toString() + "\n");
            for(Map.Entry<String, Contact> tree : entry.getValue().entrySet()){
                Contact contact = tree.getValue();
                list.add(contact.getName() + "\n"+contact.getPhone());

            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

    }
    public void homeScreen(View view){
        System.out.println("Testing");
        setContentView(R.layout.activity_add_contact);
    }
}