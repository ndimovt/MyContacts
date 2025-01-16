package io.github.ndimovt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.adapter.SpinnerEmailTypeAdapter;
import io.github.ndimovt.adapter.SpinnerPhoneTypeAdapter;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.service.ContactService;

import java.util.ArrayList;

public class EditContactActivity extends AppCompatActivity{
    EditText nameView;
    Spinner phoneTypeView;
    EditText phoneView;
    Spinner emailTypeView;
    EditText emailView;
    Button saveRecord;
    private final SpinnerPhoneTypeAdapter phoneTypeAdapter = new SpinnerPhoneTypeAdapter();
    private final SpinnerEmailTypeAdapter emailTypeAdapter = new SpinnerEmailTypeAdapter();
    private ContactAdapter adapter;
    private ArrayList<Contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        list = (ArrayList<Contact>) ContactService.getContacts();
        String[] pTypes = phoneTypeAdapter.getPhoneTypes();
        String[] eTypes = emailTypeAdapter.getEmailTypes();

        nameView = findViewById(R.id.editName);
        phoneTypeView = findViewById(R.id.phoneTypeSpinner);
        phoneView = findViewById(R.id.editTextPhone);
        emailTypeView = findViewById(R.id.emailTypeSpinner);
        emailView = findViewById(R.id.editEmailAddress);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        Contact contact = null;
        for(Contact c : list){
            if(c.getId() == id){
                contact = c;
            }
        }
        Log.d("Text", "Name"+contact.getPhone());

//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



//        Bundle extras = getIntent().getBundleExtra("key");
//        Contact contact = null;
//        if (extras != null) {
//            contact = new Contact(
//                    extras.getInt("id"),
//                    extras.getString("name"),
//                    extras.getString("phoneType"),
//                    extras.getString("phone"),
//                    extras.getString("emailType"),
//                    extras.getString("email")
//            );
//        }

//        if (contact != null) {
//            nameView.setText(contact.getName());
//            phoneView.setText(contact.getPhone());
//            emailView.setText(contact.getEmail());
//
//            ArrayAdapter<String> phoneType = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pTypes);
//            phoneType.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//            phoneTypeView.setAdapter(phoneType);
//
//            ArrayAdapter<String> emailType = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, eTypes);
//            emailType.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//            emailTypeView.setAdapter(emailType);
//
//            String typePhone = contact.getPhoneType();
////            if (typePhone != null) {
////                int position = findPosition(pTypes, typePhone);
////                phoneTypeView.setSelection(position);
////            }
////
////            String typeMail = contact.getEmailType();
////            if (typeMail != null) {
////                int position = findPosition(eTypes, typeMail);
////                emailTypeView.setSelection(position);
////            }
//        }
//        Contact finalContact = contact;

    }
}

