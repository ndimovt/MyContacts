package io.github.ndimovt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.R;
import io.github.ndimovt.model.Contact;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The class ContactAdapter.
 * Sets RecyclerView adapter and shows data on-screen.
 */
public class ContactAdapter extends RecyclerView.Adapter<DataViewHolder>{
    private static List<Contact> list;
    private IClick listener;

    /**
     * Instantiates ContactAdapter.
     * @param list List object
     */
    public ContactAdapter(List<Contact> list) {
        this.list = list;
    }

    /**
     * Returns List object.
     * @return List object
     */
    public static List<Contact> getList() {
        return list;
    }

    /**
     * Creates layout from list_contact.xml
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return DataViewHolder object.
     */
    @NonNull
    @NotNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context1);
        View view = layoutInflater.inflate(R.layout.list_contact, parent, false);
        return new DataViewHolder(view);
    }

    /**
     * Binds data from given List.
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NotNull DataViewHolder holder, int position) {
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
        holder.button.setOnClickListener(v -> listener.buttonClick(position));

        holder.itemView.setOnClickListener(view -> {
            listener.contactClick(position, contact);
        });
    }

    /**
     * Return given DataStructure size.
     * @return Int primitive
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Updates Contact object at a given position in the List and notifies the adapter.
     * @param i Int primitive
     * @param c Contact object
     */
    public void updateContact(int i,Contact c){
        list.set(i, c);
        notifyItemChanged(i);
    }
    public void setListener(IClick listener) {
        this.listener = listener;
    }
    public interface IClick{
        void buttonClick(int position);
        void contactClick(int position, Contact contact);
    }
}
