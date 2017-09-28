package com.fittech.gcherubini.fittechandroid.storage

import android.content.Context
import com.fittech.gcherubini.fittechandroid.R

object SharedPrefs {
    fun init(ctx: Context) {
        ctx.getSharedPreferences(ctx.getString(R.string.app_name), Context.MODE_PRIVATE)
    }
}