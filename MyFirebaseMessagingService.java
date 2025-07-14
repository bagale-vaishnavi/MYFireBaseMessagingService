package com.notificationapp;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.util.Log;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title = "New Notification";
        String body = "You have a new message.";

        if (remoteMessage.getNotification() != null) {
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
        }

        showNotification(title, body);
    }

    private void showNotification(String title, String message) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channelId = "default_channel";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                channelId, "Default Channel", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true);

        manager.notify(1, builder.build());
    }
}