package com.gcherubini.wannabeakotlindev.view.RealmDatabase

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gcherubini.wannabeakotlindev.BR
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ViewHolderRealmDbUserBinding
import com.gcherubini.wannabeakotlindev.model.UserRealm

class RealmDbAdapter(private val list: List<UserRealm>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewHolderRealmDbUserBinding = DataBindingUtil.inflate(inflater, R.layout.view_holder_realm_db_user, parent, false)
        return ViewHolder(binding)
    }
}

class ViewHolder(val binding: ViewHolderRealmDbUserBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Any) {
        binding.setVariable(BR.user, data)
        binding.executePendingBindings()
    }
}