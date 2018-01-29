package net.hudsononline.beaconmonitor;

import android.app.Application;
import com.estimote.coresdk.common.config.EstimoteSDK;

/**
 * Created by Admin on 1/28/2018.
 */

public class MyApplication extends Application {
    private boolean beaconNotificationsEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: put your App ID and App Token here
        // You can get them by adding your app on https://cloud.estimote.com/#/apps
        EstimoteSDK.initialize(getApplicationContext(), "monitor-10w", "377e3af83babea885d8eda0133b67dee");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) { return; }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("B9407F30-F5F8-466E-AFF9-25556B57FE6D", 1003, 28743),
                "Enter the range of the beacon",
                "Going out of range.");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }
}
