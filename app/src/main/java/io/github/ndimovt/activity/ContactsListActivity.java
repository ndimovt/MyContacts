package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.adapter.DataViewHolder;
import io.github.ndimovt.buttons.CallButton;
import io.github.ndimovt.data.DataList;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.myListener.IListener;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class ContactsListActivity.
 * Creates main app screen.
 */

public class ContactsListActivity extends AppCompatActivity {
    private ArrayList<Contact> contacts;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private DataList list = DataList.getInstance();;

    /**
     * Sets adapter, view and List with contacts info.
     * Creates layout using activity_contacts_list.
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        contacts = (ArrayList<Contact>) list.getContacts();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ContactAdapter(contacts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setListener(new ContactAdapter.IClick() {
            @Override
            public void buttonClick(int position) {
                try{
                    String value = contacts.get(position).getPhone();
                    if(value != null){
                        Toast.makeText(getApplicationContext(), "Calling "+value, Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Missing phone number ", Toast.LENGTH_LONG).show();
                    }
                }catch (NullPointerException npe){
                    npe.printStackTrace();
                }
            }

            @Override
            public void contactClick(int position, Contact contact) {
                //to be implemented;
            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
            }
        });
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
