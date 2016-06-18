package com.zhaoxuan.wehome.module.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zhaoxuan.wehome.module.event.ElectricEvent;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;

public class BatteryInfoBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
            int level = intent.getIntExtra("level", 0);
            int scale = intent.getIntExtra("scale", 100);
            int electric = level * 100 / scale;
            UserManager.getInstance().setElectricLevel(electric);
            DispenseBus.getInstance().post(new ElectricEvent(electric));
        }
    }

}