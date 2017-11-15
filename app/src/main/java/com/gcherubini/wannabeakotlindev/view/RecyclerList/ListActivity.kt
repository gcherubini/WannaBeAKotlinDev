package com.gcherubini.wannabeakotlindev.view.RecyclerList

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivityListBinding
import com.gcherubini.wannabeakotlindev.model.ListSimpleModel


class ListActivity : AppCompatActivity() {

    lateinit var binding: ActivityListBinding
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        var items = loadList()

        adapter = ListAdapter(items)
        binding.recyclerView?.adapter = adapter
        binding.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding.addItemsBtn?.setOnClickListener{ onAddItemsBtnClick() }
        binding.removeItemsBtn?.setOnClickListener{ onRemoveItemsBtnClick() }
    }

    private fun loadList(): ArrayList<ListSimpleModel> {
        val item1 = ListSimpleModel("List Item 1", false)
        val item2 = ListSimpleModel("List Item 2", false)
        val item3 = ListSimpleModel("List Item 3", false)
        val item4 = ListSimpleModel("List Item 4", false)
        val item5 = ListSimpleModel("List Item 5", false)
        val item6 = ListSimpleModel("List Item 6", false)
        val item7 = ListSimpleModel("List Item 7", false)
        val item8 = ListSimpleModel("List Item 8", false)
        val item9 = ListSimpleModel("List Item 9", false)

        var items = ArrayList<ListSimpleModel>()
        items.add(item1)
        items.add(item2)
        items.add(item3)
        items.add(item4)
        items.add(item5)
        items.add(item6)
        items.add(item7)
        items.add(item8)
        items.add(item9)
        return items
    }

    fun onRemoveItemsBtnClick() {
        adapter.removeItem(0)
        adapter.removeItem(0)
        adapter.removeItem(0)
    }

    fun onAddItemsBtnClick() {
        adapter.addItem(0, ListSimpleModel("New List Item 1", true))
        adapter.addItem(0, ListSimpleModel("New List Item 2", true))
        adapter.addItem(0, ListSimpleModel("New List Item 3", true))
        binding.recyclerView?.smoothScrollToPosition(0)
    }
}