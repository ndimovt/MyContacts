package io.github.ndimovt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.adapter.SpinnerEmailTypeAdapter;
import io.github.ndimovt.adapter.SpinnerPhoneTypeAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;

public class EditContactActivity extends AppCompatActivity {
    EditText contactNameView;
    Spinner contactPhoneTypeView;
    EditText contactPhoneView;
    Spinner contactEmailTypeView;
    EditText contactEmailView;
    Button saveRecord;
    private final SpinnerPhoneTypeAdapter phoneTypeAdapter = new SpinnerPhoneTypeAdapter();
    private final SpinnerEmailTypeAdapter emailTypeAdapter = new SpinnerEmailTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ContactService service = new ContactService();
        ArrayList<Contact> list = (ArrayList<Contact>) service.getContacts();
        Contact contact = null;
        String[] pTypes = phoneTypeAdapter.getPhoneTypes();
        String[] eTypes = emailTypeAdapter.getEmailTypes();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        contactNameView = findViewById(R.id.editName);
        contactPhoneTypeView = findViewById(R.id.phoneTypeSpinner);
        contactPhoneView = findViewById(R.id.editTextPhone);
        contactEmailTypeView = findViewById(R.id.emailTypeSpinner);
        contactEmailView = findViewById(R.id.editEmailAddress);
        saveRecord = findViewById(R.id.save_button);

        Intent intent = getIntent();
        int index = intent.getIntExtra("id", -1);

        for(Contact c : list){
            if(c.getId() == index){
                contact = c;
                break;
            }
        }
        if(contact != null){
            contactNameView.setText(contact.getName());

            contactNameView.requestFocus();
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.showSoftInput(contactNameView, InputMethodManager.SHOW_IMPLICIT);

            contactPhoneView.setText(contact.getPhone());
            contactEmailView.setText(contact.getEmail());

            ArrayAdapter<String> phoneType = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pTypes);
            phoneType.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            contactPhoneTypeView.setAdapter(phoneType);

            ArrayAdapter<String> emailType = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, eTypes);
            emailType.setDropDownViewResource(androidx.transition.R.layout.support_simple_spinner_dropdown_item);
            contactEmailTypeView.setAdapter(emailType);

            String typePhone = contact.getPhoneType();
            if(typePhone != null){
                int position = findPosition(pTypes, typePhone);
                contactPhoneTypeView.setSelection(position);
            }

            String typeMail = contact.getEmailType();
            if(typeMail != null){
                int position = findPosition(eTypes, typeMail);
                contactEmailTypeView.setSelection(position);
            }
        }

        Contact finalContact = contact;
        saveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalContact.setName(contactNameView.getText().toString());
                finalContact.setEmailType(contactEmailTypeView.getSelectedItem().toString());
                finalContact.setEmail(contactEmailView.getText().toString());
                finalContact.setPhoneType(contactPhoneTypeView.getSelectedItem().toString());
                finalContact.setPhone(contactPhoneView.getText().toString());
                service.updateContact(finalContact);
                finish();
            }
        });
    }
    private int findPosition(String[] arr, String element){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(element)){
                return i;
            }
        }
        return 0;
    }
}