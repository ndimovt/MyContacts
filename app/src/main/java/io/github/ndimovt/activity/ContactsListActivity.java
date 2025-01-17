package io.github.ndimovt.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.data.DataList;
import io.github.ndimovt.model.Contact;

import java.util.ArrayList;

/**
 * The class ContactsListActivity.
 * Creates main app screen.
 */

public class ContactsListActivity extends AppCompatActivity{
    private ArrayList<Contact> contacts;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private DataList list;

    /**
     * Sets adapter, view and List with contacts info.
     * Creates layout using activity_contacts_list.
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        list = DataList.getInstance();
        contacts = (ArrayList<Contact>) list.getContacts();

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
    }
}
