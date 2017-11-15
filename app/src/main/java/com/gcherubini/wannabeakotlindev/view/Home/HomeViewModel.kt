package com.gcherubini.wannabeakotlindev.view.Home

import android.app.Activity
import android.databinding.ObservableField
import android.view.View
import com.gcherubini.wannabeakotlindev.moveForward
import com.gcherubini.wannabeakotlindev.showAlertDialog
import com.gcherubini.wannabeakotlindev.view.Welcome.WelcomeActivity


class HomeViewModel(var act: Activity) {
    var userName = ObservableField<String>()

    fun onSendBtnClick(view: View) {
        if (userName?.get()?.isNotBlank()!!) {
            act?.moveForward(WelcomeActivity(), WelcomeActivity.EXTRA_PARAM_USER_NAME, userName.get())
            return
        }

        act?.showAlertDialog("Please, fill input correctly.")
    }
}