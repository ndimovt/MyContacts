package io.github.ndimovt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.ContactInfoActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public TextView phoneTextView;
        public Button callButton;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView){
            super(itemView);
            this.nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            this.phoneTextView = (TextView) itemView.findViewById(R.id.contact_phone);
            this.callButton = (Button) itemView.findViewById(R.id.call_btn);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
        }
    }
    private final ArrayList<Contact> contacts;

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
        int currentPosition = holder.getAdapterPosition();

        final Contact contact = contacts.get(currentPosition);
        holder.nameTextView.setText(contact.getName());
        holder.phoneTextView.setText(contact.getPhone());
        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callButtonFunction(contact, view);
            }
        });
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != RecyclerView.NO_POSITION) {
                    openContactInfoActivity(view, currentPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    private void callButtonFunction(Contact contact, View view){
        if(contact.getPhone() != null){
            Toast.makeText(view.getContext(), "Calling "+ contact.getPhone(), Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(view.getContext(), "Missing PhoneNumber!", Toast.LENGTH_LONG).show();
        }
    }
    private void openContactInfoActivity(View view, int index){
        Context context = view.getContext();
        Intent intent = new Intent(context, ContactInfoActivity.class);
        intent.putExtra("id",contacts.get(index).getId());
        context.startActivity(intent);
    }
}
