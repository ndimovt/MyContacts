package io.github.ndimovt.buttons;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import io.github.ndimovt.myListener.IListener;

/**
 * The class MessageButton.
 */
public class MessageButton implements IListener{
    private String phoneNumber;
    private Context context;

    /**
     * Instantiates MessageButton.
     * @param phoneNumber String object
     * @param context Context object
     */
    public MessageButton(String phoneNumber, Context context) {
        this.phoneNumber = phoneNumber;
        this.context = context;
    }

    /**
     * When method is called returns on screen message with parameter.
     * @param view View object
     */
    @Override
    public void onClick(View view) {
        try{
            String value = this.phoneNumber;
            if(value != null){
                Toast.makeText(this.context, "Sending message to "+value, Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this.context, "Missing phone number ", Toast.LENGTH_LONG).show();
            }
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }
}
