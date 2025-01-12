package io.github.ndimovt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter(Context context, ArrayList<Contact> contacts){
        super(context, 0, contacts);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View contacts = convertView;

        if(contacts == null){
            contacts = LayoutInflater.from(getContext()).inflate(R.layout.list_contact, parent,false);
        }

        Contact contact = getItem(position);

        TextView nameTextView = contacts.findViewById(R.id.contact_name);
        nameTextView.setText(contact.getName());
        TextView phoneTextView = contacts.findViewById(R.id.contact_phone);
        phoneTextView.setText(contact.getPhone());

        return contacts;
    }

}
