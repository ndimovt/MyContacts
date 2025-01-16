package io.github.ndimovt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
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
    private List<Contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        list = ContactService.getContacts();

        contactNameView = findViewById(R.id.contact_name);
        contactPhoneTypeView = findViewById(R.id.contact_phone_type);
        contactPhoneView = findViewById(R.id.contact_phone);
        contactEmailTypeView = findViewById(R.id.contact_email_type);
        contactEmailView = findViewById(R.id.contact_email);
        openEditActivity = findViewById(R.id.edit);

        Intent intent = getIntent();
        int id = intent.getIntExtra("contact", -1);
        Contact contact = null;
        for(Contact c : list){
            if(c.getId() == id){
                contact = c;
            }
        }

        contactNameView.setText(contact.getName());
        contactPhoneTypeView.setText(contact.getPhoneType());
        contactPhoneView.setText(contact.getPhone());
        contactEmailTypeView.setText(contact.getEmailType());
        contactEmailView.setText(contact.getPhone());

        Contact finalContact = contact;
        openEditActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditContactActivity.class);
                intent.putExtra("id", finalContact.getId());
                startActivity(intent);
                finish();
            }
        });
    }
}

