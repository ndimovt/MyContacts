package io.github.ndimovt.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.ContactInfoActivity;
import io.github.ndimovt.EditContactActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView phoneTextView;
        public Button callButton;
        public TextView letter;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            phoneTextView = (TextView) itemView.findViewById(R.id.contact_phone);
            callButton = (Button) itemView.findViewById(R.id.call_btn);
            letter = (TextView) itemView.findViewById((R.id.letter));
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
    private ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.list_contact, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        if(position > 0){
            Contact prevContact = contacts.get(position - 1);

            char current = contact.getName().charAt(0);
            char prev = prevContact.getName().charAt(0);

            if(current != prev) {
                holder.letter.setText(String.valueOf(contact.getName().charAt(0)));
            }
        }else{
            char firstSymbol = contact.getName().charAt(0);
            holder.letter.setText(String.valueOf(firstSymbol));
        }

        holder.nameTextView.setText(contact.getName());
        holder.phoneTextView.setText(contact.getPhone());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    openContactInfoActivity(view, position);
            }
        });
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Context context = view.getContext();
//                Intent intent = new Intent(context, EditContactActivity.class);
//                intent.putExtra("id", contacts.get(position).getId());
//                context.startActivity(intent);

                Contact c = contacts.get(position);
                //c.setName("ogtl");
                holder.nameTextView.setText(c.getName());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    private void openContactInfoActivity(View view, int index){
        Context context = view.getContext();
        Intent intent = new Intent(context, ContactInfoActivity.class);
        intent.putExtra("id",contacts.get(index).getId());
        context.startActivity(intent);
    }
    public void updateData(List<Contact> c){
        contacts = (ArrayList<Contact>) c;
        for (Contact contact : contacts) {
            Log.d("ContactList", "Name: " + contact.getName() +
                    ", EmailType: " + contact.getEmailType() +
                    ", Email: " + contact.getEmail() +
                    ", PhoneType: " + contact.getPhoneType() +
                    ", Phone: " + contact.getPhone());
        }
        notifyDataSetChanged();
    }

}
