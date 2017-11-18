package com.gcherubini.wannabeakotlindev

import android.app.Activity
import com.gcherubini.wannabeakotlindev.view.Home.HomeViewModel
import com.gcherubini.wannabeakotlindev.view.Welcome.WelcomeActivity
import org.junit.Test

import org.mockito.Mockito.verify


class ExampleUnitTest {

    val activity = Activity()
    var viewModel = HomeViewModel(activity)

    @Test
    fun moveForward() {
        viewModel.userName.set("Jogado")
        viewModel.onSendBtnClick(null)
        verify(activity).moveForward(WelcomeActivity(), WelcomeActivity.EXTRA_PARAM_USER_NAME, viewModel.userName.get())
    }
}
