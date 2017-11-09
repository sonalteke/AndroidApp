package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_SAMPLE =1235 ;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void onFire(View view){

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setDefaults(Notification.DEFAULT_ALL);
        Notification notification=builder.build();
        manager.notify(NOTIFICATION_SAMPLE,notification);
    }

}
