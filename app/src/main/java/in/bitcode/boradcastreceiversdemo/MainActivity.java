package in.bitcode.boradcastreceiversdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnRegister, mBtnUnregister, mBtnSendBroadcast;
    private MyBR mMyBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRegister = findViewById(R.id.btnRegister);
        mBtnUnregister = findViewById(R.id.btnUnRegister);
        mBtnSendBroadcast = findViewById(R.id.btnSendBroadcast);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyBR = new MyBR();

                IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
                intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intentFilter.addAction(Intent.ACTION_WALLPAPER_CHANGED);
                intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
                intentFilter.addAction("in.bitcode.course.download.COMPLETE");

                registerReceiver(mMyBR, intentFilter);

            }
        });
        mBtnUnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unregisterReceiver(mMyBR);
            }
        });

        mBtnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("in.bitcode.course.download.COMPLETE");
                //intent.setAction(Intent.ACTION_BATTERY_LOW);
                intent.putExtra("path", "/storage/bitcode/android/tutorial.mp4");
                sendBroadcast(intent);
            }
        });


    }
}