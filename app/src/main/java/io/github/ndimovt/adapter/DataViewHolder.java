package io.github.ndimovt.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import io.github.ndimovt.R;
import org.jetbrains.annotations.NotNull;

/**
 * The class DataViewHolder
 */

public class DataViewHolder extends RecyclerView.ViewHolder {
    TextView letter;
    TextView name;
    TextView phone;
    Button button;
    View view;

    /**
     * Instantiates DataViewHolder.
     * @param itemView View object
     */

    public DataViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        this.letter = itemView.findViewById(R.id.letter);
        this.name = itemView.findViewById(R.id.contact_name);
        this.phone = itemView.findViewById(R.id.contact_phone);
        this.button = itemView.findViewById(R.id.call_btn);
        this.view = itemView;
    }
}
