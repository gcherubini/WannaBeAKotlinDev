package com.fittech.gcherubini.fittechandroid.view

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.support.v7.app.AlertDialog

fun AppCompatActivity.moveForward(activity: AppCompatActivity) {
    startActivity(Intent(this, activity.javaClass))
}

fun AppCompatActivity.showError(error: String) {
    val alert = AlertDialog.Builder(this).create()
    alert.setMessage(error)

    alert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { _, _ ->
        alert.dismiss()
    })

    alert.show()
}