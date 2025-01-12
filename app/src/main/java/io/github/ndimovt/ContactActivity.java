package io.github.ndimovt;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;
import java.util.List;

import static io.github.ndimovt.R.*;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.contact_info);

        TextView contactNameView = findViewById(R.id.contact_name);
        TextView contactPhoneTypeView = findViewById(id.contact_phone_type);
        TextView contactPhoneView = findViewById(id.contact_phone);
        TextView contactEmailTypeView = findViewById(id.contact_email_type);
        TextView contactEmailView = findViewById(id.contact_email);

        int contactId = getIntent().getIntExtra("id", -1);

        ContactService contactService = new ContactService();
        ArrayList<Contact> contacts = new ArrayList<>(contactService.getContacts());

        Contact targetContact = new Contact(contactId);
        if (contacts.contains(targetContact)) {
            int index = contacts.indexOf(targetContact);
            Contact contact = contacts.get(index);

            contactNameView.setText(contact.getName());
            contactPhoneTypeView.setText(contact.getPhoneType());
            contactPhoneView.setText(contact.getPhone());
            contactEmailTypeView.setText(contact.getEmailType());
            contactEmailView.setText(contact.getEmail());
        }
    }
}
