package io.github.ndimovt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import io.github.ndimovt.adapter.SpinnerPhoneTypeAdapter;
import io.github.ndimovt.databinding.ActivityEditContactBinding;

public class EditContactActivity extends AppCompatActivity {
    TextView contactNameView;
    Spinner contactPhoneTypeView;
    TextView contactPhoneView;
    Spinner contactEmailTypeView;
    TextView contactEmailView;
    private final SpinnerPhoneTypeAdapter phoneTypeAdapter = new SpinnerPhoneTypeAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] pTypes = phoneTypeAdapter.getPhoneTypes();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        contactNameView = findViewById(R.id.editName);
        contactPhoneTypeView = findViewById(R.id.phoneTypeSpinner);
        contactPhoneView = findViewById(R.id.editTextPhone);
        contactEmailTypeView = findViewById(R.id.emailTypeSpinner);
        contactEmailView = findViewById(R.id.editEmailAddress);

        Intent intent = getIntent();

        contactNameView.setText(intent.getStringExtra("name"));
        contactPhoneView.setText(intent.getStringExtra("phone"));
        contactEmailView.setText(intent.getStringExtra("email"));

        ArrayAdapter<String> phoneType = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pTypes);
        phoneType.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        contactPhoneTypeView.setAdapter(phoneType);

    }
}