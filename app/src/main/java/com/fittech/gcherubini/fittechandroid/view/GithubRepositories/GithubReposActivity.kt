package com.fittech.gcherubini.fittechandroid.view.GithubRepositories

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityGithubUserReposBinding
import com.fittech.gcherubini.fittechandroid.model.GithubRepository
import com.fittech.gcherubini.fittechandroid.network.GithubApi
import com.fittech.gcherubini.fittechandroid.view.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_github_user_repos.*

/**
 * Created by guilherme on 22/09/17.
 */
class GithubReposActivity : BaseActivity() {

    private lateinit var binding: ActivityGithubUserReposBinding
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_github_user_repos)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnSearchGitRepos.setOnClickListener {
            onSearchGitReposBtnClick()
        }
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    private fun onSearchGitReposBtnClick() {
        if(binding.etGithubUserName?.text?.toString()!!.isBlank()) {
            showError("Please, fill input correctly")
            return
        }

        val githubApiServe by lazy {
            GithubApi.create()
        }

        loading.visibility = VISIBLE

        disposable =
                githubApiServe.getRepositories(binding.etGithubUserName.text.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> successResponseActions(result) },
                                { error -> failResponseActions(error) }
                        )
    }

    private fun successResponseActions(result: List<GithubRepository>) {
        loading.visibility = GONE
        binding.recyclerView.adapter = GithubReposAdapter(result)
        binding.recyclerView.adapter.notifyDataSetChanged()
    }

    private fun failResponseActions(error: Throwable) {
        loading.visibility = GONE
        binding.recyclerView.adapter = GithubReposAdapter(ArrayList())
        binding.recyclerView.adapter.notifyDataSetChanged()
        showError(error.message!!)
    }
}