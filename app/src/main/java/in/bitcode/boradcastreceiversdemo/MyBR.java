package in.bitcode.boradcastreceiversdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if( intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            boolean isEnabled = intent.getBooleanExtra("state", false);
            String message = isEnabled ? "Airplane mode is turned ON!" : "Airplane mode is turned Off!";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        else {
            if(intent.getAction().equals("in.bitcode.course.download.COMPLETE")) {
                Toast.makeText(
                        context,
                        intent.getAction() + "\n" + intent.getStringExtra("path"),
                        Toast.LENGTH_LONG
                ).show();
            }
            else {
                Toast.makeText(context, intent.getAction(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
