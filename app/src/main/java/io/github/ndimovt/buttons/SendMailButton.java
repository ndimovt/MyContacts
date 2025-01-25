package io.github.ndimovt.buttons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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
//        if (email != null && !email.isEmpty()) {
//            Log.d("mail", "mails "+email);
//            try {
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.putExtra(Intent.EXTRA_EMAIL, email);
//                intent.setType("message/rfc822");
//                context.startActivity(intent);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            Toast.makeText(context, "Phone number is missing or invalid", Toast.LENGTH_SHORT).show();
//        }
    }
}
