package com.gcherubini.wannabeakotlindev.view.GithubRepositories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gcherubini.wannabeakotlindev.BR
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ViewHolderGithubRepoBinding
import com.gcherubini.wannabeakotlindev.model.GithubRepository

class GithubReposAdapter(private val list: List<GithubRepository>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewHolderGithubRepoBinding = DataBindingUtil.inflate(inflater, R.layout.view_holder_github_repo, parent, false)
        return ViewHolder(binding)
    }
}

class ViewHolder(val binding: ViewHolderGithubRepoBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Any) {
        binding.setVariable(BR.item, data)
        binding.executePendingBindings()
    }
}