package com.gcherubini.wannabeakotlindev.view.SharedPrefs

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gcherubini.wannabeakotlindev.BR
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivitySharedPrefsBinding
import com.gcherubini.wannabeakotlindev.storage.SharedPrefs

class SharedPrefsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPrefsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_prefs)
        binding.setVariable(BR.prefs, SharedPrefs)
        binding.executePendingBindings()

        binding.btnSharedPrefsPersist.setOnClickListener {
            onPersistBtnClick()
        }
    }

    private fun onPersistBtnClick() {
        binding.etUserName?.text?.toString()!!.apply {
            persistUserName(binding.etUserName.text.toString())
        }
    }

    private fun persistUserName(userName: String) {
        SharedPrefs.userName = userName
        binding.notifyPropertyChanged(BR.prefs)
    }
}