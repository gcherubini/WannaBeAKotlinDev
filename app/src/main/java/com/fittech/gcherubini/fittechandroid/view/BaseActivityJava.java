package com.fittech.gcherubini.fittechandroid.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class BaseActivityJava extends android.support.v7.app.AppCompatActivity {

    public void moveForward(AppCompatActivity activity) {
        startActivity(new Intent(this, activity.getClass()));
    }

    public void showAlertDialog(String message) {
        showAlertDialog(message, null);
    }

    public void showAlertDialog(String message, DialogInterface.OnClickListener onClickListener) {
        final AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setMessage(message);

        if (onClickListener != null) {
            alert.setButton(Dialog.BUTTON_POSITIVE, "OK", onClickListener);
        } else {
            alert.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alert.dismiss();
                }
            });
        }

        alert.show();
    }

}
