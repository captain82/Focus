package com.example.focus

import android.content.Context
import android.os.Handler
import android.widget.Toast
import java.util.*


class CustomTimerTask(val context: Context) : TimerTask() {

    val handler = Handler()
    override fun run() {
        Thread(Runnable {
            handler.post {
                Toast.makeText(
                    context,
                    "Toast showing now",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }).start()
    }

}