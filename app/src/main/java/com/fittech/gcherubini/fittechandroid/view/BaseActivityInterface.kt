package com.fittech.gcherubini.fittechandroid.view

import android.support.v7.app.AppCompatActivity


interface BaseActivityInterface {
    fun moveForward(activity: AppCompatActivity)
    fun showError(error: String)
}