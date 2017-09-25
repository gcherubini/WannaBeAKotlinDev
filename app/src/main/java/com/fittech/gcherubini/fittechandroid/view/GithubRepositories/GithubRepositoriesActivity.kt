package com.fittech.gcherubini.fittechandroid.view.GithubRepositories

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityListBinding
import com.fittech.gcherubini.fittechandroid.databinding.ActivityRepositoriesBinding
import com.fittech.gcherubini.fittechandroid.model.GithubRepository
import com.fittech.gcherubini.fittechandroid.model.ListSimpleModel
import com.fittech.gcherubini.fittechandroid.network.GithubApi
import com.fittech.gcherubini.fittechandroid.view.BaseActivity
import com.fittech.gcherubini.fittechandroid.view.List.ListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by guilherme on 22/09/17.
 */
class GithubRepositoriesActivity : BaseActivity() {

    //https://api.github.com/users/gcherubini/repos

    private lateinit var binding: ActivityRepositoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repositories)
        //binding.recyclerView.adapter = ListAdapter(items)
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.btnSearchGitRepos.setOnClickListener {
            onSearchGitReposBtnClick()
        }
    }

    private fun onSearchGitReposBtnClick() {
        Log.i("Value EditText", binding.etGithubUserName?.text.toString())

        if(binding.etGithubUserName?.text?.toString()!!.isBlank()) {
            showError("Please, fill input correctly")
            return
        }

        val githubApiServe by lazy {
            GithubApi.create()
        }
        var disposable: Disposable? = null

        disposable =
                githubApiServe.getRepositories(binding.etGithubUserName.text.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    for (repo: GithubRepository in result.repositories) {
                                        Log.i("REPO", repo.name)
                                    }
                                },
                                { error -> showError(error.message!!) }
                        )
    }
}