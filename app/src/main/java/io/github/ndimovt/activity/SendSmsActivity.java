package io.github.ndimovt.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.github.ndimovt.R;

public class SendSmsActivity extends AppCompatActivity {
    private TextView mobileno;
    private EditText message;
    private Button sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        mobileno = findViewById(R.id.editText1);
        message = findViewById(R.id.editText2);
        sendsms = findViewById(R.id.button1);

        Intent phone = getIntent();
        String getPhone = phone.getStringExtra("phone");
        mobileno.setText(getPhone);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(SendSmsActivity.this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SendSmsActivity.this,new String[] { Manifest.permission.SEND_SMS},1);
                }
                else {
                    try {
                        String msg = message.getText().toString();
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(String.valueOf(getPhone), null, msg, null, null);
                        Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_LONG).show();
                        finish();
                    }catch (IllegalArgumentException ie){
                        Toast.makeText(getApplicationContext(), "Message not send! Missing text!", Toast.LENGTH_LONG).show();
                        ie.printStackTrace();
                    }
                }

            }
        });
    }
}