package io.github.ndimovt.adapter;

import android.view.View;
import android.widget.AdapterView;

/**
 * The class SpinnerPhoneTypeAdapter.
 * Possible phone choices.
 */
public class SpinnerPhoneTypeAdapter implements AdapterView.OnItemSelectedListener {
    String selectedType;
    String[] phoneTypes = {"Mobile", "Fax", "Home", "Work"};

    /**
     * Returns String array object.
     * @return String array object
     */
    public String[] getPhoneTypes() {
        return phoneTypes;
    }

    /**
     * Returns String object.
     * @return String object
     */
    public String getSelectedType() {
        return selectedType;
    }

    /**
     * Assigns SelectedItem to PhoneTypes item of given index.
     * @param adapterView AdapterView object
     * @param view View object
     * @param i Int primitive
     * @param l Long primitive
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedType = phoneTypes[i];
    }

    /**
     * Uses the current value.
     * @param adapterView AdapterView object
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
