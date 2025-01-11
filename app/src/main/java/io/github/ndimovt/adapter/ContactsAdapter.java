package io.github.ndimovt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContactsAdapter extends ArrayAdapter<Map.Entry<Character, TreeMap<String, Contact>>> {
    public ContactsAdapter(Context context, List<Map.Entry<Character, TreeMap<String, Contact>>> entries){
        super(context, 0, entries);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_contact, parent,false);
        }
        Map.Entry<Character, TreeMap<String, Contact>> entry = getItem(position);
        char header = entry.getKey();
        TreeMap<String, Contact> contact = entry.getValue();

        TextView headerTextView = convertView.findViewById(R.id.header);
        headerTextView.setText(String.valueOf(header));

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Contact> map : contact.entrySet()){
            Contact contactObject = map.getValue();
            sb.append(contactObject.getName()).append("\n").append(contactObject.getPhone()).append("\n\n");
        }

        TextView nameTextView = convertView.findViewById(R.id.contact_info);
        nameTextView.setText(sb.toString());

        return convertView;
    }
}
