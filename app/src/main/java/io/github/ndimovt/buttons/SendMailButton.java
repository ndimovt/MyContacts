package io.github.ndimovt.buttons;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import io.github.ndimovt.myListener.IListener;

/**
 * The class SendMailButton.
 */
public class SendMailButton implements IListener {
    private String email;
    private Context context;

    /**
     * Instantiates SendMailButton.
     * @param email String object
     * @param context Context object
     */
    public SendMailButton(String email, Context context) {
        this.email = email;
        this.context = context;
    }

    /**
     * When method is called returns on screen message with parameter.
     * @param view View object
     */
    @Override
    public void onClick(View view) {
        try{
            String value = this.email;
            if(value != null){
                Toast.makeText(this.context, "Sending email to "+value, Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this.context, "Missing email ", Toast.LENGTH_LONG).show();
            }
        }catch (NullPointerException npe){
            npe.printStackTrace();
        }
    }
}
