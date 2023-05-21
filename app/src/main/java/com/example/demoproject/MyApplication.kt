package com.example.demoproject

import com.moengage.core.DataCenter
import com.moengage.core.MoEngage
import android.app.Application
import com.moengage.core.LogLevel.VERBOSE
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig

class MyApplication:Application() {

    override fun onCreate(){
        super.onCreate()

        val moEngage = MoEngage.Builder(this, "YSUSKQXZSREHDMDXD0HDE7WJ", DataCenter.DATA_CENTER_1)
            .configureLogs(LogConfig(level = VERBOSE))
            .configureNotificationMetaData(NotificationConfig(R.drawable.small_icon, R.drawable.large_icon))
            .configureFcm(FcmConfig(true))
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)

    }
}