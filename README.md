# AlarmHelper

Helper class that provides Alarm functionalities in a more simplified way.

## Install Instructions

Build.gradle (root):
```gradle
allprojects {
	repositories {
		(...)
		mavenCentral()
		maven{
		    url  'https://oss.sonatype.org/content/repositories/snapshots/'
		    name 'OSS-Sonatype'
		}
		maven { url "https://jitpack.io" }
		(...)
	}
}
```

Build.gradle (app):
```gradle
dependencies
{
    (...)
    implementation 'com.github.perezjquim:alarmhelper:master-SNAPSHOT'
    (...)
}
```

## Examples of use

Create a BroadcastReceiver - e.g. Action:
(here you can define what happens when the alarm is triggered)
```java
public class Action extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		System.out.println("WHATEVER");
	}
}
```

Put your BroadcastReceiver in the manifest:
```gradle
<receiver android:name=".Action" android:exported="true">
	<intent-filter>
		<action android:name="myalarm" >
		</action>
	</intent-filter>
</receiver>
```

Schedule an alarm that is triggered every 5 minutes:
```java
{
	(...)
	AlarmHelper.scheduleRepeatingAlarm(context,"myalarm",5*60*1000);
	(...)

	// OR

	(...)
	Calendar trigger = (...)
	AlarmHelper.scheduleRepeatingAlarm(context,"myalarm",trigger,5*60*1000);
	(...)
}
```

Standard alarm - an alarm that is triggered in 10 minutes (one-time only):
```java
{
	(...)
	AlarmHelper.scheduleStandardAlarm(context,"myalarm",10*60*1000);
	(...)

	// OR

	(...)
	Calendar c = (...)
	AlarmHelper.scheduleStandardAlarm(context,"myalarm",c);
	(...)
}
```