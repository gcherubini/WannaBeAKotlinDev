package com.gcherubini.wannabeakotlindev.view.Home

import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivityHomeWithViewModelBinding

class HomeActivityWithViewModel : Activity() {
    val layoutFile = R.layout.activity_home_with_view_model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeWithViewModelBinding = DataBindingUtil.setContentView(this, layoutFile)
        binding?.viewModel = HomeViewModel(this)
    }
}