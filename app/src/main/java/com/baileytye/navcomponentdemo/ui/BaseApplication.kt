package com.baileytye.navcomponentdemo.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import com.baileytye.navcomponentdemo.R
import com.baileytye.navcomponentdemo.sendNotification

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.sendNotification("Deep linked", this)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                getString(R.string.notification_channel_id),
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.apply {
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
                description = "Notification description"
            }

            val notificationManager =
                getSystemService(NotificationManager::class.java) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

}