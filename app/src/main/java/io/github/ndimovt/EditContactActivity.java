package io.github.ndimovt;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import io.github.ndimovt.databinding.ActivityEditContactBinding;

public class EditContactActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityEditContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}