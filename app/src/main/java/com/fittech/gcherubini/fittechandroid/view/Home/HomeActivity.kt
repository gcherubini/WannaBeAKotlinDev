package com.fittech.gcherubini.fittechandroid.view.Home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fittech.gcherubini.fittechandroid.BR
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding
import com.fittech.gcherubini.fittechandroid.model.User
import com.fittech.gcherubini.fittechandroid.view.GithubRepositories.GithubReposActivity
import com.fittech.gcherubini.fittechandroid.view.RecyclerList.ListActivity
import com.fittech.gcherubini.fittechandroid.view.RealmDatabase.RealmDbActivity
import com.fittech.gcherubini.fittechandroid.view.moveForward


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val user = User("Albert Eisten")
        binding.setVariable(BR.user, user)
        binding.executePendingBindings()

        binding.btnListRecyclerView.setOnClickListener {
            moveForward(ListActivity())
        }

        binding.btnGithubUserRepos.setOnClickListener{
            moveForward(GithubReposActivity())
        }

        binding.btnRealmDatabase.setOnClickListener{
            moveForward(RealmDbActivity())
        }
    }
}
