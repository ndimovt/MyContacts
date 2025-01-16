package io.github.ndimovt;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
    Button call;
    Button message;
    Button mail;
    ImageView image;
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
        image = findViewById(R.id.imageView2);
        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        mail = findViewById(R.id.mail);

        Bundle intent = getIntent().getExtras();
        int id = intent.getInt("contact");
        Contact contact = null;
        for(Contact c : list){
            if(c.getId() == id){
                contact = c;
                break;
            }
        }
        Log.d("asdas", "asd"+contact.getName());

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
                String value = contactEmailView.getText().toString();
                if(!value.equals("") && !value.equals(" ")){
                Toast.makeText(getApplicationContext(), "Sending mail to "+contactEmailView.getText(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Missing email ", Toast.LENGTH_LONG).show();
                }
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = contactPhoneView.getText().toString();
                if(!value.equals("") && !value.equals(" ")){
                    Toast.makeText(getApplicationContext(), "Sending message to "+contactNameView.getText(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Missing phone number ", Toast.LENGTH_LONG).show();
                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = contactPhoneView.getText().toString();
                if(!value.equals("") && !value.equals(" ")){
                    Toast.makeText(getApplicationContext(), "Calling "+contactPhoneView.getText(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Missing phone number ", Toast.LENGTH_LONG).show();
                }
            }
        });
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

