package com.fittech.gcherubini.fittechandroid

import android.app.Application
import com.fittech.gcherubini.fittechandroid.storage.SharedPrefs
import io.realm.Realm


class WannaBeAKotlinDevApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        SharedPrefs.init(this)
    }
}