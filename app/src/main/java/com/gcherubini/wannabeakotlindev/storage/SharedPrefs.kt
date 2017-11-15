package com.gcherubini.wannabeakotlindev.storage

import android.content.Context
import android.content.SharedPreferences
import com.gcherubini.wannabeakotlindev.R

object SharedPrefs {
    val KEY_USER_NAME = "USER_NAME"
    lateinit var instance: SharedPreferences

    var userName: String
        get() = instance.getString(KEY_USER_NAME, "")
        set(value) = instance.edit().putString(KEY_USER_NAME, value).apply()

    fun init(context: Context) {
        instance = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    }
}