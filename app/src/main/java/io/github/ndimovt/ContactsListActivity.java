package io.github.ndimovt;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;

public class ContactsListActivity extends AppCompatActivity{
    private ArrayList<Contact> contacts;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        contacts = (ArrayList<Contact>) ContactService.getContacts();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ContactAdapter(contacts, getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }
        });
        findViewById(R.id.addContactButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = 5;
                Contact s = new Contact(5,"koiokl", "podas", "1354f", "ada", "adsa");
                adapter.updateContact(index, s);
            }
        });
    }
}
