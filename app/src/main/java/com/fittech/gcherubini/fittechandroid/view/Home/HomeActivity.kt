package com.fittech.gcherubini.fittechandroid.view.Home

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.fittech.gcherubini.fittechandroid.BR
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding
import com.fittech.gcherubini.fittechandroid.model.User
import com.fittech.gcherubini.fittechandroid.view.BaseActivity
import com.fittech.gcherubini.fittechandroid.view.Workout.ListActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val user = User("Dr. Albert Eisten")
        binding.setVariable(BR.user, user)
        binding.executePendingBindings()

        binding.btnListRecyclerView.setOnClickListener {
            moveForward(ListActivity())
        }
    }
}
