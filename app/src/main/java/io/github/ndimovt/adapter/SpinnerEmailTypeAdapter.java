package io.github.ndimovt.adapter;

import android.view.View;
import android.widget.AdapterView;

/**
 * The class SpinnerEmailTypeAdapter.
 * Possible email choices.
 */
public class SpinnerEmailTypeAdapter implements AdapterView.OnItemSelectedListener{
    String selectedItem;
    String[] emailTypes = {"Main", "Office", "Personal", "Billing", "School", "University"};

    /**
     * Returns String object.
     * @return String object
     */
    public String getSelectedItem() {
        return selectedItem;
    }

    /**
     * Returns String array object.
     * @return String array object
     */
    public String[] getEmailTypes() {
        return emailTypes;
    }

    /**
     * Assigns SelectedItem to EmailTypes item of given index.
     * @param adapterView AdapterView object
     * @param view View object
     * @param i Int primitive
     * @param l Long primitive
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedItem = emailTypes[i];
    }

    /**
     * Uses the current value.
     * @param adapterView AdapterView object
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
