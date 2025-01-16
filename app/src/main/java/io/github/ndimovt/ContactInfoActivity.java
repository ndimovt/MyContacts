package io.github.ndimovt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.List;

public class ContactInfoActivity extends AppCompatActivity {
    TextView contactNameView;
    TextView contactPhoneTypeView;
    TextView contactPhoneView;
    TextView contactEmailTypeView;
    TextView contactEmailView;
    Button openEditActivity;
    private List<Contact> list = ContactAdapter.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        contactNameView = findViewById(R.id.contact_name);
        contactPhoneTypeView = findViewById(R.id.contact_phone_type);
        contactPhoneView = findViewById(R.id.contact_phone);
        contactEmailTypeView = findViewById(R.id.contact_email_type);
        contactEmailView = findViewById(R.id.contact_email);
        openEditActivity = findViewById(R.id.edit);

        Bundle intent = getIntent().getExtras();
        int id = intent.getInt("contact");
        Contact contact = null;
        for(Contact c : list){
            if(c.getId() == id){
                contact = c;
                break;
            }
        }

        assert contact != null;
        contactNameView.setText(contact.getName());
        contactPhoneTypeView.setText(contact.getPhoneType());
        contactPhoneView.setText(contact.getPhone());
        contactEmailTypeView.setText(contact.getEmailType());
        contactEmailView.setText(contact.getEmail());

        Contact finalContact = contact;
        openEditActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditContactActivity.class);
                intent.putExtra("id", finalContact.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}

