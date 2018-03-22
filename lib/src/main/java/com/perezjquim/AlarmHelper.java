package com.perezjquim;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public abstract class AlarmHelper
{
    public static void scheduleAlarm(Context context, String receiverName, long triggerTime, boolean repeating)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(receiverName);
        PendingIntent pi = PendingIntent.getBroadcast(context,0,i,0);
        if(!repeating)
        {
            alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() +
                            triggerTime, pi);
        }
        else
        {
            alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    SystemClock.elapsedRealtime() + triggerTime,
                    triggerTime, pi);
        }
    }
}
