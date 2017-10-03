package com.fittech.gcherubini.fittechandroid.view

import android.app.Dialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.support.v7.app.AlertDialog

fun AppCompatActivity.moveForward(activity: AppCompatActivity) {
    startActivity(Intent(this, activity.javaClass))
}

fun AppCompatActivity.showAlertDialog(message: String) {
    showAlertDialog(message, null)
}

fun AppCompatActivity.showAlertDialog(message: String, onClickListener: DialogInterface.OnClickListener?) {
    val alert = AlertDialog.Builder(this).create()
    alert.setMessage(message)

    if (onClickListener != null) {
        alert.setButton(Dialog.BUTTON_POSITIVE, "OK", onClickListener)
    } else {
        alert.setButton(Dialog.BUTTON_POSITIVE, "OK") { _, _ -> alert.dismiss() }
    }

    alert.show()
}