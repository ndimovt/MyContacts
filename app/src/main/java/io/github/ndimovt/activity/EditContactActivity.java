package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.SpinnerEmailTypeAdapter;
import io.github.ndimovt.adapter.SpinnerPhoneTypeAdapter;
import io.github.ndimovt.data.DataList;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.validators.Validator;

import java.util.ArrayList;

/**
 * The class EditContactActivity.
 * Creates activity for changing selected contact info.
 */
public class EditContactActivity extends AppCompatActivity{
    private EditText nameView;
    private Spinner phoneTypeView;
    private EditText phoneView;
    private Spinner emailTypeView;
    private EditText emailView;
    private Button saveRecord;
    private ImageView imageView;
    private final SpinnerPhoneTypeAdapter phoneTypeAdapter = new SpinnerPhoneTypeAdapter();
    private final SpinnerEmailTypeAdapter emailTypeAdapter = new SpinnerEmailTypeAdapter();
    private ArrayList<Contact> list = (ArrayList<Contact>) DataList.getInstance().getContacts();
    private Contact contact;

    /**
     * Populates activity with info fetched by List with contacts with a given id.
     * Also gives possibility to update and save info.
     * Creates layout using activity_edit_contact.
     * @param savedInstanceState Bundle object
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        String[] pTypes = phoneTypeAdapter.getPhoneTypes();
        String[] eTypes = emailTypeAdapter.getEmailTypes();

        initializeDesign();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        contact = null;
        for(Contact c : list){
            if(c.getId() == id){
                contact = c;
                break;
            }
        }

        if (contact != null) {
            nameView.setText(contact.getName());
            phoneView.setText(contact.getPhone());
            emailView.setText(contact.getEmail());

            //phoneTypeView.setAdapter(spinnerValue(pTypes));

            //emailTypeView.setAdapter(spinnerValue(eTypes));

            String typePhone = contact.getPhoneType();
            if (typePhone != null) {
                int position = findPosition(pTypes, typePhone);
                phoneTypeView.setSelection(position);
            }

            String typeMail = contact.getEmailType();
            if (typeMail != null) {
                int position = findPosition(eTypes, typeMail);
                emailTypeView.setSelection(position);
            }
        }

        Contact finalContact = contact;
        saveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveContact(finalContact);
            }
        });
    }
    private void saveContact(Contact finalContact){
        boolean isNameValid = true;
        boolean isPhoneNumValid = true;
        boolean isEmailValid = true;

        String name = nameView.getText().toString();
        if(!Validator.nameValidator(name)){
            Toast.makeText(getApplicationContext(), "Invalid or missing name!", Toast.LENGTH_LONG).show();
            isNameValid = false;
        }
        String phoneType = phoneTypeView.getSelectedItem().toString();
        String phone = phoneView.getText().toString();
        if(!Validator.phoneNumberValidator(phone)){
            Toast.makeText(getApplicationContext(), "Invalid or missing phone number!", Toast.LENGTH_LONG).show();
            isPhoneNumValid = false;
        }
        String mailType = emailTypeView.getSelectedItem().toString();
        String email = emailView.getText().toString();

        if(!Validator.emailValidator(email)){
            Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_LONG).show();
            isEmailValid = false;
        }
        if(isNameValid && isPhoneNumValid && isEmailValid){
            finalContact.setId(contact.getId());
            finalContact.setName(name);
            finalContact.setPhoneType(phoneType);
            finalContact.setPhone(phone);
            finalContact.setEmailType(mailType);
            finalContact.setEmail(email);

            Intent resultIntent = new Intent(EditContactActivity.this, ContactsListActivity.class);
            resultIntent.putExtra("id", finalContact.getId());
            resultIntent.putExtra("name", finalContact.getName());
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
    private int findPosition(String[] arr, String infoType) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(infoType)){
                return i;
            }
        }
        return -1;
    }
    private ArrayAdapter<String> spinnerValue(String[] arr){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        return adapter;
    }
    private void initializeDesign(){
        nameView = findViewById(R.id.editName);
        phoneTypeView = findViewById(R.id.phoneTypeSpinner);
        phoneView = findViewById(R.id.editTextPhone);
        emailTypeView = findViewById(R.id.emailTypeSpinner);
        emailView = findViewById(R.id.editEmailAddress);
        imageView = findViewById(R.id.imageView);
        saveRecord = findViewById(R.id.save_button);
    }

}

