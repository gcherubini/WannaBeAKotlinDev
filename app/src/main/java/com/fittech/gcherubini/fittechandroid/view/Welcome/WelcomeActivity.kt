package com.fittech.gcherubini.fittechandroid.view.Welcome

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityWelcomeBinding
import com.fittech.gcherubini.fittechandroid.model.User
import com.fittech.gcherubini.fittechandroid.view.GithubRepositories.GithubReposActivity
import com.fittech.gcherubini.fittechandroid.view.RealmDatabase.RealmDbActivity
import com.fittech.gcherubini.fittechandroid.view.RecyclerList.ListActivity
import com.fittech.gcherubini.fittechandroid.view.SharedPrefs.SharedPrefsActivity
import com.fittech.gcherubini.fittechandroid.view.moveForward

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