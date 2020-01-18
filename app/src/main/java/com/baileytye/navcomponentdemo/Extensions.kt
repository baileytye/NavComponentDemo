package com.baileytye.navcomponentdemo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder

const val NOTIFICATION_ID = 12
const val KEY_USER = "user"
const val KEY_FIRST_NAME = "firstName"

fun NotificationManagerCompat.sendNotification(
    message: String,
    applicationContext: Context
) {

    val bundle = Bundle()
    val user = User(firstName = "Bailey", lastName = "Tye")
    bundle.putParcelable(KEY_USER, user)
    bundle.putString(KEY_FIRST_NAME, user.firstName)

    val contentPendingIntent = NavDeepLinkBuilder(applicationContext)
        .setComponentName(MainActivity::class.java)
        .setGraph(R.navigation.mobile_navigation)
        .setDestination(R.id.firstNameFragment)
        .setArguments(bundle)
        .createPendingIntent()

    val builder = NotificationCompat.BigTextStyle(
        NotificationCompat.Builder(
            applicationContext,
            applicationContext.getString(R.string.notification_channel_id)
        )
            .setSmallIcon(R.drawable.ic_home_black_24dp)
            .setContentTitle(applicationContext.getString(R.string.notification_title))
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(contentPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    )

    notify(NOTIFICATION_ID, builder.build())
}