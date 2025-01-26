package io.github.ndimovt.buttons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import io.github.ndimovt.model.Contact;
import io.github.ndimovt.myListener.IListener;

import java.util.List;

/**
 * The class CallButton.
 */
public class CallButton implements IListener {
    private String phoneNumber;
    private Context context;

    /**
     * Instantiates CallButton.
     * @param phoneNumber String object
     * @param context Context object
     */
    public CallButton(String phoneNumber, Context context) {
        this.phoneNumber = phoneNumber;
        this.context = context;
    }

    /**
     * When method is called returns on screen message with parameter.
     * @param view View object
     */
    @Override
    public void onClick(View view) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            try {
                Uri uri = Uri.parse("tel:" + phoneNumber);
                Intent call = new Intent(Intent.ACTION_DIAL, uri);
                call.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(call);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(context, "Phone number is missing or invalid", Toast.LENGTH_SHORT).show();
        }
    }
}
