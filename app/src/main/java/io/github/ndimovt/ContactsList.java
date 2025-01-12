package io.github.ndimovt;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        ListView listView = findViewById(R.id.contacts);

        ArrayList<Contact> list = new ArrayList<>();
        ContactService contactService = new ContactService();
        list.addAll(contactService.getContacts());
        ContactAdapter adapter = new ContactAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ContactsList.this, ContactActivity.class);
                    intent.putExtra("id", list.get(i).getId());
                    startActivity(intent);
                }
            });
    }
}