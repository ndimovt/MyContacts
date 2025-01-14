package io.github.ndimovt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static io.github.ndimovt.R.*;

public class ContactInfoActivity extends AppCompatActivity {
    TextView contactNameView;
    TextView contactPhoneTypeView;
    TextView contactPhoneView;
    TextView contactEmailTypeView;
    TextView contactEmailView;

    Button openEditActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_contact_info);

        contactNameView = findViewById(R.id.contact_name);
        contactPhoneTypeView = findViewById(id.contact_phone_type);
        contactPhoneView = findViewById(id.contact_phone);
        contactEmailTypeView = findViewById(id.contact_email_type);
        contactEmailView = findViewById(id.contact_email);

        Intent intent = getIntent();

        contactNameView.setText(intent.getStringExtra("name"));
        contactPhoneTypeView.setText(intent.getStringExtra("phoneType"));
        contactPhoneView.setText(intent.getStringExtra("phone"));
        contactEmailTypeView.setText(intent.getStringExtra("emailType"));
        contactEmailView.setText(intent.getStringExtra("email"));

        openEditActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, EditContactActivity.class);
                startActivity(intent);
            }
        });


        }
    }

