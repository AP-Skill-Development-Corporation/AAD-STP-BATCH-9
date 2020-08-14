package com.example.cherry.examplework;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ThirdWork extends Worker {
    NotificationManager nm;
    public ThirdWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        nm= (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
    @NonNull
    @Override
    public Result doWork() {
        createNotification();
        sendNotification();
        return Result.success();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder = new NotificationCompat
                .Builder(getApplicationContext(),"Cherry");
        builder.setContentTitle("Notification");
        builder.setContentText("This is my notification");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        nm.notify(0,builder.build());
    }

    private void createNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc=new NotificationChannel("Cherry",
                    "Apssdc",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.RED);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }


}
