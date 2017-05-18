package com.example.abdul_wahab.uolmads17secbbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";

    IntentFilter inf;


    BroadcastReceiver mreceiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "onReceive: " + intent.getAction() + intent.getIntExtra(WifiManager.EXTRA_NEW_STATE ,-1));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inf = new IntentFilter();
        inf.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        inf.addAction("android.net.wifi.STATE_CHANGE");

        /*

        Intent intent = new Intent("android.provider.Telephony.SMS_RECEIVED");
        List<ResolveInfo> infos = getPackageManager().queryBroadcastReceivers(intent, 0);
        for (ResolveInfo info : infos) {
            System.out.println("Receiver name:" + info.activityInfo.name + "; priority=" + info.priority);
        }
        */

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mreceiver2,inf);

    }

    @Override
    protected void onPause() {
        unregisterReceiver(mreceiver2);
        super.onPause();
    }
}
