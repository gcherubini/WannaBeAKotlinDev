package com.fittech.gcherubini.fittechandroid.view.SharedPrefs

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityGithubUserReposBinding
import com.fittech.gcherubini.fittechandroid.databinding.ActivitySharedPrefsBinding
import com.fittech.gcherubini.fittechandroid.model.GithubRepository
import com.fittech.gcherubini.fittechandroid.model.User
import com.fittech.gcherubini.fittechandroid.model.UserRealm
import com.fittech.gcherubini.fittechandroid.network.GithubApi
import com.fittech.gcherubini.fittechandroid.view.GithubRepositories.GithubReposAdapter
import com.fittech.gcherubini.fittechandroid.view.showError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SharedPrefsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPrefsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_prefs)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnSharedPrefsPersist.setOnClickListener {
            onPersistBtnClick()
        }
    }

    private fun onPersistBtnClick() {
        if (binding.etUserName?.text?.toString()!!.isNotBlank()) {
            val newUser = User(binding.etUserName.text.toString())
            persistUser(newUser)
        } else {
            showError("Please, fill input correctly")
        }
    }

    private fun persistUser(newUser: User) {

    }
}