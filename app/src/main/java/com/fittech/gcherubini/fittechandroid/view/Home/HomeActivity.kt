package com.fittech.gcherubini.fittechandroid.view.Home

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding
import com.fittech.gcherubini.fittechandroid.view.Welcome.WelcomeActivity
import com.fittech.gcherubini.fittechandroid.view.Welcome.WelcomeActivity.Companion.EXTRA_PARAM_USER_NAME
import com.fittech.gcherubini.fittechandroid.view.moveForward
import com.fittech.gcherubini.fittechandroid.view.showAlertDialog


class HomeActivity : Activity() {
    val layoutFile = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, layoutFile)

        binding?.btnSend?.setOnClickListener {  btnSendActions(binding) }
    }

    private fun btnSendActions(binding: ActivityHomeBinding) {
        if (binding?.editTextUserName?.text?.toString()?.isNotBlank()!!) {
            val intent = Intent(this, WelcomeActivity().javaClass)
            intent.putExtra(EXTRA_PARAM_USER_NAME, binding.editTextUserName.text.toString())
            startActivity(intent)
            return
        }

        val alert = AlertDialog.Builder(this).create()
        alert.setMessage("Please, fill input correctly.")
        alert.setButton(Dialog.BUTTON_POSITIVE, "OK") { _, _ -> alert.dismiss() }
        alert.show()
    }
}
