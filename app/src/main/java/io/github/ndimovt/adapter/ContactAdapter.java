package io.github.ndimovt.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.ContactInfoActivity;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;
import org.jetbrains.annotations.NotNull;

import java.util.List;
public class ContactAdapter extends RecyclerView.Adapter<DataViewHolder>{
    List<Contact> list;
    private Context context;
    public ContactAdapter(List<Contact> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ContactAdapter(List<Contact> list) {
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context1);
        View view = layoutInflater.inflate(R.layout.list_contact, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull final DataViewHolder holder, final int position) {
        Contact contact = list.get(position);
        if(position > 0){
            Contact prevContact = list.get(position - 1);

            char current = contact.getName().charAt(0);
            char prev = prevContact.getName().charAt(0);

            if(current != prev) {
                holder.letter.setText(String.valueOf(contact.getName().charAt(0)).toUpperCase());
            }
        }else{
            char firstSymbol = contact.getName().charAt(0);
            holder.letter.setText(String.valueOf(firstSymbol));
        }
        holder.name.setText(list.get(position).getName());
        holder.phone.setText(list.get(position).getPhone());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ContactInfoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("contact", contact.getId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void updateContact(int index, Contact c){
        Contact contact = list.get(index);
        contact.setName(c.getName());
        contact.setPhone(c.getPhone());
        contact.setEmailType(c.getEmailType());
        contact.setPhoneType(c.getPhone());
        notifyItemChanged(index);
    }
    public void addContact(int index, Contact contact){

    }
}
