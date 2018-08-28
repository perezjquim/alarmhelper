package com.perezjquim;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public abstract class AlarmHelper
{
    public static void scheduleStandardAlarm(Context context, Class receiver, Calendar trigger, int requestCode)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,receiver);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmMgr != null)
        {
            alarmMgr.cancel(pi);
            alarmMgr.set(AlarmManager.RTC_WAKEUP,
                    trigger.getTimeInMillis(), pi);
        }
        else
        {
            System.err.println("AlarmManager has a null pointer");
        }
    }
    public static void scheduleStandardAlarm(Context context, Class receiver, Calendar trigger)
    {
        scheduleStandardAlarm(context,receiver,trigger,0);
    }
    public static void scheduleStandardAlarm(Context context, Class receiver, long triggerTime, int requestCode)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,receiver);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmMgr != null)
        {
            alarmMgr.cancel(pi);
            alarmMgr.set(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis()+
                            triggerTime, pi);
        }
        else
        {
            System.err.println("AlarmManager has a null pointer");
        }
    }
    public static void scheduleStandardAlarm(Context context, Class receiver, long triggerTime)
    {
        scheduleStandardAlarm(context,receiver,triggerTime,0);
    }

    public static void scheduleRepeatingAlarm(Context context, Class receiver, long interval, int requestCode)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,receiver);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmMgr != null)
        {
            alarmMgr.cancel(pi);
            alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + interval,
                    interval, pi);
        }
        else
        {
            System.err.println("AlarmManager has a null pointer");
        }
    }
    public static void scheduleRepeatingAlarm(Context context, Class receiver, long interval)
    {
        scheduleRepeatingAlarm(context, receiver, interval ,0);
    }
    public static void scheduleRepeatingAlarm(Context context, Class receiver, Calendar trigger, long interval, int requestCode)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,receiver);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmMgr != null)
        {
            alarmMgr.cancel(pi);
            alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,
                    trigger.getTimeInMillis(),
                    interval, pi);
        }
        else
        {
            System.err.println("AlarmManager has a null pointer");
        }
    }
    public static void scheduleRepeatingAlarm(Context context, Class receiver, Calendar trigger, long interval)
    {
        scheduleRepeatingAlarm(context, receiver, trigger, interval, 0);
    }

    public static void cancelAlarm(Context context, Class receiver, int requestCode)
    {
        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context,receiver);
        PendingIntent pi = PendingIntent.getBroadcast(context,requestCode,i,PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmMgr != null)
        {
            alarmMgr.cancel(pi);
        }
        else
        {
            System.err.println("AlarmManager has a null pointer");
        }
    }
    public static void cancelAlarm(Context context, Class receiver)
    {
        cancelAlarm(context, receiver, 0);
    }
}
