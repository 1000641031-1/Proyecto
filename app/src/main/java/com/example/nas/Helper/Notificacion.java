package com.example.nas.Helper;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Notificacion extends Application {
    private static final String ENVIAR_1_ID="enviar";
    private static final String ENVIAR_1_CANTIDAD="enviar c";

    public void onCreate() {
        super.onCreate();
        EnviarNotificacion();
    }

    private void EnviarNotificacion() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel enviar = new NotificationChannel(
                    ENVIAR_1_ID, ENVIAR_1_CANTIDAD, NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(enviar);
        }
    }
}
