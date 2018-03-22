# AlarmHelper

Helper class that provides Alarm functionalities in a more simplified way.

## Instructions

Build.gradle:
```gradle
dependencies
{
	(...)
	implementation 'com.github.perezjquim:alarmhelper:master-SNAPSHOT'
	(...)
}
```

## Examples of use

Schedule an alarm that is triggered every 5 minutes:
```java
{
	(...)
	AlarmManager.scheduleAlarm(context,"nameofthereceiver",5*1000,false);
	(...)
}
```

Schedule an alarm that is triggered in 10 minutes (one-time only):
```java
{
	(...)
	AlarmManager.scheduleAlarm(context,"nameofthereceiver",10*1000,true);
	(...)
}
```