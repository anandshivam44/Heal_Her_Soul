package com.example.healhersoul;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

    public  static  final String Channel1ID="Channel1ID";
    public  static  final String Channel1Name="Channel1";
    public  static  final String Channel2ID="Channel2ID";
    public  static  final String Channel2Name="Channel2";

    private NotificationManager mManager;
    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    public void  createChannel(){
        NotificationChannel channel1=new NotificationChannel(Channel1ID,Channel1Name, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.colorPrimary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel1);

        NotificationChannel channel2=new NotificationChannel(Channel2ID,Channel2Name, NotificationManager.IMPORTANCE_DEFAULT);
        channel2.enableLights(true);
        channel2.enableVibration(true);
        channel2.setLightColor(R.color.colorPrimary);
        channel2.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel2);
    }
    public NotificationManager getManager(){
        if (mManager==null)
        {
            mManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }
    public NotificationCompat.Builder getChannel1Notification(String title, String message)/**not in use */
    {
        return new NotificationCompat.Builder(getApplicationContext(),Channel1ID).setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_background);
    }
    public NotificationCompat.Builder getChannel2Notification(String title, String message)/**not in use*/
    {
        return new NotificationCompat.Builder(getApplicationContext(),Channel2ID).setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_background);
    }

    public NotificationCompat.Builder getChannelNotification() /**sending notification through this method */
    {
        return new NotificationCompat.Builder(getApplicationContext(),Channel2ID).setContentTitle("title")
                .setContentText("message")
                .setSmallIcon(R.drawable.ic_launcher_background);
    }

}
