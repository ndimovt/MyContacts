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

public class ContactsAdapter extends ArrayAdapter<Contact> {
    public ContactsAdapter(Context context, ArrayList<Contact> contacts){
        super(context, 0, contacts);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View contacts = convertView;

        if(contacts == null){
            contacts = LayoutInflater.from(getContext()).inflate(R.layout.contact_info, parent,false);
        }

        Contact contact = getItem(position);

        TextView nameTextView = contacts.findViewById(R.id.contact_name);
        nameTextView.setText(contact.getName());
        TextView phoneTypeView = contacts.findViewById(R.id.contact_phone_type);
        phoneTypeView.setText(contact.getPhoneType());
        TextView phoneTextView = contacts.findViewById(R.id.contact_phone);
        phoneTextView.setText(contact.getPhone());
        TextView phoneMailTView = contacts.findViewById(R.id.contact_email_type);
        phoneMailTView.setText(contact.getPhone());
        TextView phoneMailView = contacts.findViewById(R.id.contact_email);
        phoneMailView.setText(contact.getPhone());

        return contacts;
    }
}
