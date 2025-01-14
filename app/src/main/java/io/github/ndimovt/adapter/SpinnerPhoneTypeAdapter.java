package io.github.ndimovt.adapter;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerPhoneTypeAdapter implements AdapterView.OnItemSelectedListener {
    String selectedType;
    String[] phoneTypes = {"Mobile", "Fax", "Home"};

    public String[] getPhoneTypes() {
        return phoneTypes;
    }

    public String getSelectedType() {
        return selectedType;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedType = phoneTypes[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
