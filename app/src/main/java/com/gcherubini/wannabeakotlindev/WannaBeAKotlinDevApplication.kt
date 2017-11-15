package com.gcherubini.wannabeakotlindev

import android.app.Application
import com.gcherubini.wannabeakotlindev.storage.SharedPrefs
import io.realm.Realm


class WannaBeAKotlinDevApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        SharedPrefs.init(this)
    }
}