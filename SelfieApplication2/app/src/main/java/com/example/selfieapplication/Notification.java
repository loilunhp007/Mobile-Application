package com.example.selfieapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.Toast;

import java.util.Calendar;

public class Notification extends BroadcastReceiver {
    private static final int MY_NOTIFICATION_ID = 1;
    Context context;
    private String mChannelID;
    private int mNotificationCount;
    private final CharSequence tickerText = "Chụp ảnh nào bạn ơi!";
    private final CharSequence contentTitle = "Remainder";
    private final CharSequence contentText = "Lâu rồi chưa thấy bạn chụp hình";
    private final long[] mVibratePattern = {100, 200, 300, 400, 500, 400, 300, 200, 400};
    private final int startTime=30*1000;
    public Notification(Context context){
        this.context = context;

    }
    public  Notification(){}
    public void createNotificationChannel(Context context){
        NotificationManager mNotificationManager =(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mChannelID = context.getPackageName() + ".channel_01";
        String description =context.getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        CharSequence name = context.getString(R.string.channel_name);
        NotificationChannel mChannel = new NotificationChannel(mChannelID, name, importance);
        // Configure the notification channel.
        mChannel.setDescription(description);
        mChannel.enableLights(true);
        Uri mSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        mChannel.setSound(mSoundURI, (new AudioAttributes.Builder())
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .build());

        mNotificationManager.createNotificationChannel(mChannel);
    }
    @Override
    public void onReceive(Context context,Intent intent){
        createNotificationChannel(context);
        notificationMessege(context);


    }
    public void notificationMessege(Context context){
        // Define action Intent
        System.out.println("hello"+System.currentTimeMillis());
        Intent mNotificationIntent = new Intent(context.getApplicationContext(),
                Subnotification.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent mContentIntent = PendingIntent.getActivity(context.getApplicationContext(), 0,
                mNotificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Define the Notification's expanded message and Intent:

        android.app.Notification.Builder notificationBuilder = new android.app.Notification.Builder(
                context.getApplicationContext(), mChannelID)
                .setTicker(tickerText)
                .setSmallIcon(R.drawable.launcher)
                .setColor(13369395)
                .setAutoCancel(true)
                .setContentTitle(contentTitle)
                .setContentText(
                        contentText + " (" + ++mNotificationCount + ")")
                .setContentIntent(mContentIntent);

        // Pass the Notification to the NotificationManager:
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(MY_NOTIFICATION_ID,
                notificationBuilder.build());

    }

}
