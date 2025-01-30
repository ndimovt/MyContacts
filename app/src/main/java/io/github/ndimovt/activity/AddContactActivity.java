package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.validators.Validator;

public class AddContactActivity extends AppCompatActivity {
    private EditText name;
    private Spinner phoneType;
    private EditText phone;
    private Spinner emailType;
    private EditText email;
    private Button save;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initializeDesign();
    }
    public void insert(View view){
        boolean isNameValid = true;
        boolean isPhoneNumValid = true;
        boolean isEmailValid = true;
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        String contactName = name.getText().toString();
        if(!Validator.nameValidator(contactName)){
            Toast.makeText(getApplicationContext(), "Invalid or missing name!", Toast.LENGTH_LONG).show();
            isNameValid = false;
        }
        String contactPhoneType = phoneType.getSelectedItem().toString();
        String contactPhone = phone.getText().toString();

        if(!Validator.phoneNumberValidator(contactPhone)){
            Toast.makeText(getApplicationContext(), "Invalid or missing phone number!", Toast.LENGTH_LONG).show();
            isPhoneNumValid = false;
        }
        String contactMailType = emailType.getSelectedItem().toString();
        String contactEmail = email.getText().toString();

        if(!Validator.emailValidator(contactEmail) && !contactEmail.isEmpty()){
            Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_LONG).show();
            isEmailValid = false;
        }
        if(contactEmail.isEmpty()){
            contactEmail = null;
        }

        if(isNameValid && isPhoneNumValid && isEmailValid){
            Contact contact = new Contact(id, contactName, contactPhoneType, contactPhone, contactMailType, contactEmail);
            Intent result = new Intent(AddContactActivity.this, ContactsListActivity.class);
            result.putExtra("contact", contact);
            setResult(RESULT_OK, result);
            finish();
        }
    }
    private void initializeDesign(){
        name = findViewById(R.id.addName);
        phoneType = findViewById(R.id.phoneType);
        phone = findViewById(R.id.addPhoneNumber);
        emailType = findViewById(R.id.emailTypeSpinner);
        email = findViewById(R.id.addEmailAddress);
        imageView = findViewById(R.id.avatar);
        save = findViewById(R.id.save_btn);
    }

}