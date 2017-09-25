package com.fittech.gcherubini.fittechandroid.view.List

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityListBinding
import com.fittech.gcherubini.fittechandroid.model.ListSimpleModel
import com.fittech.gcherubini.fittechandroid.view.BaseActivity

/**
 * Created by guilherme on 22/09/17.
 */
class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        val item1 = ListSimpleModel("List Item 1")
        val item2 = ListSimpleModel("List Item 2")
        val item3 = ListSimpleModel("List Item 3")
        var items = ArrayList<ListSimpleModel>()
        items.add(item1)
        items.add(item2)
        items.add(item3)

        binding.recyclerView.adapter = ListAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}