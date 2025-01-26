package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.SpinnerEmailTypeAdapter;
import io.github.ndimovt.adapter.SpinnerPhoneTypeAdapter;
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
    private final SpinnerPhoneTypeAdapter phoneTypeAdapter = new SpinnerPhoneTypeAdapter();
    private final SpinnerEmailTypeAdapter emailTypeAdapter = new SpinnerEmailTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        String[] pTypes = phoneTypeAdapter.getPhoneTypes();
        String[] eTypes = emailTypeAdapter.getEmailTypes();

        initializeDesign();
        phoneType.setAdapter(spinnerValue(pTypes));
        emailType.setAdapter(spinnerValue(eTypes));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

    }
    private void insert(){
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

        if(!Validator.emailValidator(contactEmail)){
            Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_LONG).show();
            isEmailValid = false;
        }

        if(isNameValid && isPhoneNumValid && isEmailValid){
            Contact contact = new Contact(id, contactName, contactPhoneType, contactPhone, contactMailType, contactEmail);
            Intent result = new Intent(AddContactActivity.this, ContactsListActivity.class);
            result.putExtra("contact", contact);
            setResult(RESULT_OK, result);
            finish();
        }
    }
    private ArrayAdapter<String> spinnerValue(String[] arr){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        return adapter;
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