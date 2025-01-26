package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.buttons.CallButton;
import io.github.ndimovt.data.DataList;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.myListener.IListener;

import java.util.List;

/**
 * The class ContactInfoActivity.
 * Creates activity including info for selected contact.
 */

public class ContactInfoActivity extends AppCompatActivity {
    private static final int RESULT_DELETE = 5;
    private ActivityResultLauncher<Intent> launcher;
    private TextView contactNameView;
    private TextView contactPhoneTypeView;
    private TextView contactPhoneView;
    private TextView contactEmailTypeView;
    private TextView contactEmailView;
    private Button openEditActivity;
    private Button call;
    private Button message;
    private Button mail;
    private Button exit;
    private Button delete;
    private ImageView image;
    private IListener listener;
    private List<Contact> list = DataList.getInstance().getContacts();

    /**
     * Creates screen and populates all fields with values.
     * Creates layout using activity_contact_info.
     * @param savedInstanceState Bundle Object
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        initializeDesign();

        Bundle intent = getIntent().getExtras();
        int id = intent.getInt("id");
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
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contactEmailView != null){
                    Intent mailIntent = new Intent(ContactInfoActivity.this, SendEmailActivity.class);
                    mailIntent.putExtra("receiver", finalContact.getEmail());
                    startActivity(mailIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Missing email!", Toast.LENGTH_LONG).show();
                }

            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contactPhoneView != null){
                    Intent phone = new Intent(ContactInfoActivity.this, SendSmsActivity.class);
                    phone.putExtra("phone", finalContact.getPhone());
                    startActivity(phone);
                }else{
                    Toast.makeText(getApplicationContext(), "Missing phone number!", Toast.LENGTH_LONG).show();
                }

            }
        });

        call.setOnClickListener(listener = new CallButton(contact.getPhone(), this));
        openEditActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactInfoActivity.this, EditContactActivity.class);
                intent.putExtra("id", finalContact.getId());
                launcher.launch(intent);;
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        setResult(RESULT_OK, data);
                    }
                }
        );
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delete = new Intent(ContactInfoActivity.this, ContactsListActivity.class);
                delete.putExtra("id", id);
                setResult(RESULT_DELETE, delete);
                finish();
            }
        });
    }
    private void initializeDesign(){
        contactNameView = findViewById(R.id.contact_name);
        contactPhoneTypeView = findViewById(R.id.contact_phone_type);
        contactPhoneView = findViewById(R.id.contact_phone);
        contactEmailTypeView = findViewById(R.id.contact_email_type);
        contactEmailView = findViewById(R.id.contact_email);
        openEditActivity = findViewById(R.id.edit);
        exit = findViewById(R.id.back_btn);
        delete = findViewById(R.id.delete_btn);
        image = findViewById(R.id.imageView2);
        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        mail = findViewById(R.id.mail);
    }
}

