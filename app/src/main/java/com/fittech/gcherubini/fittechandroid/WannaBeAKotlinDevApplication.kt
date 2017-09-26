package com.fittech.gcherubini.fittechandroid

import android.app.Application
import io.realm.Realm


class WannaBeAKotlinDevApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}