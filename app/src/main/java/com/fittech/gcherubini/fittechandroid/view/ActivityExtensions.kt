package com.fittech.gcherubini.fittechandroid.view

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.moveForward(activity: Activity) {
    startActivity(Intent(this, activity.javaClass))
}

fun AppCompatActivity.moveForward(activity: Activity, param: String, paramValue: String) {
    val intent = Intent(this, activity.javaClass)
    intent.putExtra(param, paramValue)
    startActivity(intent)
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