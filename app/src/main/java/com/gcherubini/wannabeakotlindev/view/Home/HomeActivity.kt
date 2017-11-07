package com.gcherubini.wannabeakotlindev.view.Home

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivityHomeBinding
import com.gcherubini.wannabeakotlindev.moveForward
import com.gcherubini.wannabeakotlindev.showAlertDialog
import com.gcherubini.wannabeakotlindev.view.Welcome.WelcomeActivity
import com.gcherubini.wannabeakotlindev.view.Welcome.WelcomeActivity.Companion.EXTRA_PARAM_USER_NAME

class HomeActivity : Activity() {
    val layoutFile = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, layoutFile)

        binding?.btnSend?.setOnClickListener {  btnSendActions(binding) }
    }

    private fun btnSendActions(binding: ActivityHomeBinding) {
        if (binding?.editTextUserName?.text?.toString()?.isNotBlank()!!) {
            moveForward(WelcomeActivity(), EXTRA_PARAM_USER_NAME, binding.editTextUserName.text.toString())
            return
        }

        showAlertDialog("Please, fill input correctly.")
    }
}