package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.adapter.ContactAdapter;
import io.github.ndimovt.buttons.CallButton;
import io.github.ndimovt.buttons.MessageButton;
import io.github.ndimovt.buttons.SendMailButton;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.myListener.IListener;

import java.util.List;

/**
 * The class ContactInfoActivity.
 * Creates activity including info for selected contact.
 */

public class ContactInfoActivity extends AppCompatActivity {
    private TextView contactNameView;
    private TextView contactPhoneTypeView;
    private  TextView contactPhoneView;
    private TextView contactEmailTypeView;
    private  TextView contactEmailView;
    private Button openEditActivity;
    private Button call;
    private Button message;
    private Button mail;
    private ImageView image;
    private IListener listener;
    private List<Contact> list = ContactAdapter.getList();

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
        mail.setOnClickListener(listener = new SendMailButton(contact.getEmail(), this));

        message.setOnClickListener(listener = new MessageButton(contact.getPhone(), this));

        call.setOnClickListener(listener = new CallButton(contact.getPhone(), this));
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
    private void initializeDesign(){
        contactNameView = findViewById(R.id.contact_name);
        contactPhoneTypeView = findViewById(R.id.contact_phone_type);
        contactPhoneView = findViewById(R.id.contact_phone);
        contactEmailTypeView = findViewById(R.id.contact_email_type);
        contactEmailView = findViewById(R.id.contact_email);
        openEditActivity = findViewById(R.id.edit);
        image = findViewById(R.id.imageView2);
        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        mail = findViewById(R.id.mail);
    }
}

