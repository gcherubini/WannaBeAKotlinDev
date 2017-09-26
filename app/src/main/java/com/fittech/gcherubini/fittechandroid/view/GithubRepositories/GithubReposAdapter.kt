package com.fittech.gcherubini.fittechandroid.view.GithubRepositories

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fittech.gcherubini.fittechandroid.BR
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ViewHolderGithubRepoBinding
import com.fittech.gcherubini.fittechandroid.model.GithubRepository

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