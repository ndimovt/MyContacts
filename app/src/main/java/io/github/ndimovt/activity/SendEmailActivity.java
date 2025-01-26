package io.github.ndimovt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import io.github.ndimovt.R;

public class SendEmailActivity extends AppCompatActivity {
    private Button send;
    private TextView sendTo;
    private TextView subject;
    private TextView receiver;
    private TextView body;
    private EditText mailSubject;
    private EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        initializeDesign();

        Intent emailData = getIntent();
        String mail = emailData.getStringExtra("receiver");
        sendTo.setText(mail);

        send.setOnClickListener(view -> {
            String emailsubject = subject.getText().toString();
            String emailbody = body.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailbody);

            intent.setType("message/rfc822");

            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });
    }
    private void initializeDesign(){
        send = findViewById(R.id.button);
        sendTo = findViewById(R.id.sendTo);
        subject = findViewById(R.id.topic);
        receiver = findViewById(R.id.editTextSendTo);
        body = findViewById(R.id.textView);
        mailSubject = findViewById(R.id.editTextTopic);
        mail = findViewById(R.id.editTextText);
    }

}