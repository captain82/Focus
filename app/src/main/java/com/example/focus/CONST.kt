package com.example.focus

import android.content.Context

object CONST {

    const val TITLE = "TITLE"
    const val DESC = "DESC"
    const val IS_EDIT = "IS_EDIT"
    const val ID = "ID"


    fun convertDpToPixels(dp: Float, context: Context): Int {
        val res = context.resources
        val metrics = res.displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.toInt()
    }
}