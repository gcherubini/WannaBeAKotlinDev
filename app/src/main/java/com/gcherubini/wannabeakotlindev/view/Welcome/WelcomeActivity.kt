package com.gcherubini.wannabeakotlindev.view.Welcome

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivityWelcomeBinding
import com.gcherubini.wannabeakotlindev.model.User
import com.gcherubini.wannabeakotlindev.view.GithubRepositories.GithubReposActivity
import com.gcherubini.wannabeakotlindev.view.RealmDatabase.RealmDbActivity
import com.gcherubini.wannabeakotlindev.view.RecyclerList.ListActivity
import com.gcherubini.wannabeakotlindev.view.SharedPrefs.SharedPrefsActivity
import com.gcherubini.wannabeakotlindev.moveForward

class WelcomeActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PARAM_USER_NAME = "EXTRA_PARAM_USER_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWelcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        loadUser(binding)

        binding.btnRecyclerList.setOnClickListener {
            moveForward(ListActivity())
        }

        binding.btnNetworkCommunication.setOnClickListener {
            moveForward(GithubReposActivity())
        }

        binding.btnSharedPrefs.setOnClickListener {
            moveForward(SharedPrefsActivity())
        }

        binding.btnRealmDatabase.setOnClickListener {
            moveForward(RealmDbActivity())
        }
    }

    private fun loadUser(binding: ActivityWelcomeBinding) {
        intent?.extras?.getString(EXTRA_PARAM_USER_NAME)?.let {
            binding?.user = User(it)
        }
    }
}