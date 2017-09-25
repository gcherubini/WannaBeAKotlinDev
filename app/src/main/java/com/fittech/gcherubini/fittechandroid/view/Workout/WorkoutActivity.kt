package com.fittech.gcherubini.fittechandroid.view.Workout

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityWorkoutBinding
import com.fittech.gcherubini.fittechandroid.model.Workout
import com.fittech.gcherubini.fittechandroid.view.BaseActivity

/**
 * Created by guilherme on 22/09/17.
 */
class WorkoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWorkoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_workout)

        val workout1 = Workout("Peitola", null)
        val workout2 = Workout("Gluteos Intesivo", null)
        val workout3 = Workout("Rosca", null)
        var workouts = ArrayList<Workout>()
        workouts.add(workout1)
        workouts.add(workout2)
        workouts.add(workout3)

        binding.recyclerWorkout.adapter = WorkoutAdapter(workouts)
        binding.recyclerWorkout.layoutManager = LinearLayoutManager(this)
    }
}