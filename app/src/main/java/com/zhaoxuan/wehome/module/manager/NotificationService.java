package com.zhaoxuan.wehome.module.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.view.activity.ChatActivity;


/**
 * 通知栏通知管理中心
 */
public class NotificationService {

    private static NotificationService instance = null;
    private NotificationManager notificationManager;


    private NotificationService() {
        notificationManager = (NotificationManager) WeHomeApplication.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static synchronized NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void pushNotification(String title, String des) {
        PendingIntent pendingIntent = PendingIntent.getActivity(WeHomeApplication.getInstance(), -5, new Intent(WeHomeApplication.getInstance(), ChatActivity.class), 0);
        Notification notification = new Notification.Builder(WeHomeApplication.getInstance())
                .setSmallIcon(R.drawable.logo)
                .setTicker(getString(R.string.app_name))
                .setContentTitle(title)
                .setContentText(des)
                .setContentIntent(pendingIntent)
                .build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults = Notification.DEFAULT_SOUND;
        notificationManager.notify(100, notification);
    }

    private String getString(int res) {
        return WeHomeApplication.getInstance().getString(res);
    }
}
