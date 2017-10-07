package com.fittech.gcherubini.fittechandroid.view.Home

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding
import com.fittech.gcherubini.fittechandroid.view.Welcome.WelcomeActivity
import com.fittech.gcherubini.fittechandroid.view.moveForward
import com.fittech.gcherubini.fittechandroid.view.showAlertDialog

class HomeActivityBkp : Activity() {
    val layoutFile = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, layoutFile)

        binding?.btnSend?.setOnClickListener {  btnSendActions(binding) }
    }

    private fun btnSendActions(binding: ActivityHomeBinding) {
        if (binding?.editTextUserName?.text?.toString()?.isNotBlank()!!) {
            moveForward(WelcomeActivity(), WelcomeActivity.EXTRA_PARAM_USER_NAME, binding.editTextUserName.text.toString())
            return
        }

        showAlertDialog("Please, fill input correctly.")
    }
}