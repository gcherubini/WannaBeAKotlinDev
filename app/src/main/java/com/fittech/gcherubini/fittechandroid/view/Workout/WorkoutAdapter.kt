package com.fittech.gcherubini.fittechandroid.view.Workout

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fittech.gcherubini.fittechandroid.BR
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ViewHolderWorkoutBinding
import com.fittech.gcherubini.fittechandroid.model.Workout


class WorkoutAdapter(private val list: ArrayList<Workout>) : RecyclerView.Adapter<WorkoutAdapterViewHolder>() {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WorkoutAdapterViewHolder?, position: Int) {
        holder?.bind(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WorkoutAdapterViewHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val binding: ViewHolderWorkoutBinding = DataBindingUtil.inflate(inflater, R.layout.view_holder_workout, parent, false)
        return WorkoutAdapterViewHolder(binding)
    }
}

class WorkoutAdapterViewHolder(val binding: ViewHolderWorkoutBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Any) {
        binding.setVariable(BR.workout, data)
        binding.executePendingBindings()
    }
}
