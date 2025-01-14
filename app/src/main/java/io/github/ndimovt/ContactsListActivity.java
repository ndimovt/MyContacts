package io.github.ndimovt;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;
import java.util.List;

public class ContactsListActivity extends AppCompatActivity {
    private final ContactService service = new ContactService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        ArrayList<Contact> contactsList = (ArrayList<Contact>) service.getContacts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ContactAdapter adapter = new ContactAdapter(contactsList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}