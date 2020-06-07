package com.example.focus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.ServiceState
import kotlin.math.log

class BootUpBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            Intent(context, ExampleService::class.java).also {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //log("Starting the service in >=26 Mode from a BroadcastReceiver")
                    context?.startForegroundService(it)
                    return
                }
                //log("Starting the service in < 26 Mode from a BroadcastReceiver")
                context?.startService(it)
            }
        }}
}