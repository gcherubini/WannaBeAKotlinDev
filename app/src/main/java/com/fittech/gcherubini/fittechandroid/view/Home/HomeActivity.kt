package com.fittech.gcherubini.fittechandroid.view.Home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding
import com.fittech.gcherubini.fittechandroid.view.Welcome.WelcomeActivity
import com.fittech.gcherubini.fittechandroid.view.Welcome.WelcomeActivity.Companion.EXTRA_PARAM_USER_NAME
import com.fittech.gcherubini.fittechandroid.view.moveForward
import com.fittech.gcherubini.fittechandroid.view.showAlertDialog


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.btnSend.setOnClickListener {
            onBtnSendClickListener(binding)
        }
    }

    private fun onBtnSendClickListener(binding: ActivityHomeBinding) {
        if (binding.editTextUserName?.text?.toString()!!.isNotBlank()) {
            moveForward(WelcomeActivity(), EXTRA_PARAM_USER_NAME, binding.editTextUserName.text.toString())
            return
        }

        showAlertDialog("Please, fill input correctly.")
    }
}
