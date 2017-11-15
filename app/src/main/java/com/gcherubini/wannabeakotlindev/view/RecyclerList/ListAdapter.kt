package com.gcherubini.wannabeakotlindev.view.RecyclerList

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gcherubini.wannabeakotlindev.BR
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ViewHolderListBinding
import com.gcherubini.wannabeakotlindev.model.ListSimpleModel


class ListAdapter(private val list: ArrayList<ListSimpleModel>) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewHolderListBinding = DataBindingUtil.inflate(inflater, R.layout.view_holder_list, parent, false)
        return ViewHolder(binding)
    }

    fun removeItem(pos: Int) {
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun addItem(pos: Int, item: ListSimpleModel) {
        list.add(pos, item)
        notifyItemInserted(pos)
    }
}

class ViewHolder(val binding: ViewHolderListBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Any) {
        binding.setVariable(BR.item, data)
        binding.executePendingBindings()
    }
}
