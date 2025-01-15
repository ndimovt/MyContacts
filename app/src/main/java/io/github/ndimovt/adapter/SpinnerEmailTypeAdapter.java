package io.github.ndimovt.adapter;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerEmailTypeAdapter implements AdapterView.OnItemSelectedListener{
    String selectedItem;
    String[] emailTypes = {"Main", "Office", "Personal", "Billing", "School", "University"};

    public String getSelectedItem() {
        return selectedItem;
    }

    public String[] getEmailTypes() {
        return emailTypes;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItem = emailTypes[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
