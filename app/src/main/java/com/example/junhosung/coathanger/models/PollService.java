package com.example.junhosung.coathanger.models;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.junhosung.coathanger.R;
import com.example.junhosung.coathanger.views.activities.LobbyActivity;

import java.util.Calendar;

/**
 * Created by Junho Sung on 12/9/2018.
 */

public class PollService extends IntentService {

    private static final String TAG = "PollService";
    public static final String CHANNEL_ID = "channelOne";
    private static final int POLL_INTERVAL = 1000*60*60*2; // every 2 hours
    private static final int hour = 8;
    private static final int minute = 30;

    // a service's intents are called commands

    public static Intent newIntent(Context context) {
        return new Intent(context, PollService.class);
    }

    public PollService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        if (!isNetworkAvailableAndConnected()) {
            return;
        }

        Resources resources = getResources();
        PendingIntent pendingIntent  = PendingIntent
                .getActivity(this, 0,new Intent(this,LobbyActivity.class),0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channelOne = new NotificationChannel(
                    CHANNEL_ID,
                    "channelOne",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channelOne.setDescription("This is from CoatHanger");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channelOne);
        }

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setTicker(resources.getString(R.string.app_name))
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(resources.getString(R.string.powered_by))
                .setContentText(resources.getString(R.string.app_name))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0,notification);

    }

    private boolean isNetworkAvailableAndConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        boolean isNetworkAvailable = connectivityManager.getActiveNetworkInfo() != null;
        boolean isNetworkConnected = isNetworkAvailable && connectivityManager.getActiveNetworkInfo().isConnected();

        return isNetworkConnected;
    }

    public static void setServiceAlarm(Context context, boolean isOn) {
        //Intent intent = PollService.newIntent(context);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);

        Intent intent = new Intent(context,PollService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context,0,intent,0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (isOn) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
        }
    }

    public static boolean isServiceAlarmOn(Context context) {
        Intent intent = PollService.newIntent(context);
        PendingIntent pendingIntent = PendingIntent.getService(context,0,intent,PendingIntent.FLAG_NO_CREATE);
        return pendingIntent != null;
    }

}
