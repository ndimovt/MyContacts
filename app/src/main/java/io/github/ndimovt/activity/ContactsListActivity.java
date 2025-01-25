package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.adapter.DataViewHolder;
import io.github.ndimovt.buttons.CallButton;
import io.github.ndimovt.comparator.ContactComparator;
import io.github.ndimovt.data.DataList;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.myListener.IListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class ContactsListActivity.
 * Creates main app screen.
 */

public class ContactsListActivity extends AppCompatActivity {
    private static final int RESULT_DELETE = 5;
    private ContactComparator comparator;
    private ActivityResultLauncher<Intent> contactInfoLauncher;
    private ActivityResultLauncher<Intent> insertContactLauncher;
    private List<Contact> contacts = DataList.getInstance().getContacts();
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private Button insertBtn;

    /**
     * Sets adapter, view and List with contacts info.
     * Creates layout using activity_contacts_list.
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ContactAdapter(contacts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        insertBtn = findViewById(R.id.insert);
        adapter.setListener(new ContactAdapter.IClick() {
            @Override
            public void buttonClick(int position) {
                try {
                    String value = contacts.get(position).getPhone();
                    if (value != null) {
                        Toast.makeText(getApplicationContext(), "Calling " + value, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Missing phone number", Toast.LENGTH_LONG).show();
                    }
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                }
            }

            @Override
            public void contactClick(int position, Contact contact) {
                Intent intent = new Intent(ContactsListActivity.this, ContactInfoActivity.class);
                intent.putExtra("id", contact.getId());
                contactInfoLauncher.launch(intent);
            }
        });
        contactInfoLauncher = updateOrDeleteContact(contactInfoLauncher);
        insertContactLauncher = addNewContact(insertContactLauncher);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactsListActivity.this, AddContactActivity.class);
                intent.putExtra("id", contacts.size()+1);
                insertContactLauncher.launch(intent);
            }
        });
    }
    private ActivityResultLauncher<Intent> updateOrDeleteContact(ActivityResultLauncher<Intent> launcher){
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    if(data != null){
                        int id = data.getIntExtra("id", -1);
                        int index = getIndex(contacts, id);

                        switch (result.getResultCode()){
                            case RESULT_OK:
                                adapter.notifyItemChanged(index);
                                break;
                            case RESULT_DELETE:
                                contacts.remove(index);
                                adapter.notifyItemRemoved(index);
                                break;
                            default:
                                break;
                        }
                    }

                }
        );
        return launcher;
    }
    private ActivityResultLauncher<Intent> addNewContact(ActivityResultLauncher<Intent> launcher){
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        Contact contact = (Contact) (data != null ? data.getSerializableExtra("contact") : null);
                        contacts.add(contacts.size(), contact);
                        comparator = new ContactComparator();
                        contacts.sort(comparator);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        return launcher;
    }
    private int getIndex(List<Contact> list, int id){
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id){
                index = i;
                break;
            }
        }
        return index;
    }
}
