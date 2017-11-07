package com.gcherubini.wannabeakotlindev.view.RealmDatabase

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gcherubini.wannabeakotlindev.R
import com.gcherubini.wannabeakotlindev.databinding.ActivityRealmDbBinding
import io.realm.Realm
import com.gcherubini.wannabeakotlindev.model.UserRealm
import com.gcherubini.wannabeakotlindev.showAlertDialog


class RealmDbActivity : AppCompatActivity() {
    lateinit private var binding: ActivityRealmDbBinding
    lateinit private var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_realm_db)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnPersistUser.setOnClickListener {
            onPersistUserBtnClick()
        }

        realm = Realm.getDefaultInstance()
    }

    override fun onResume() {
        super.onResume()
        showPersistedUsers()
    }

    private fun onPersistUserBtnClick() {
        if (binding.etUserName?.text?.toString()!!.isNotBlank()
                && binding.etUserAge?.text?.toString()!!.isNotBlank()) {
            val newUser = UserRealm()
            newUser.name = binding.etUserName.text.toString()
            newUser.age = Integer.parseInt(binding.etUserAge.text.toString())
            persistUser(newUser)
        } else {
            showAlertDialog("Please, fill input correctly")
        }
    }

    private fun persistUser(user: UserRealm) {
        realm.executeTransactionAsync({ bgRealm ->
            bgRealm.copyToRealmOrUpdate(user)
        }, {
            showPersistedUsers()
        }) {
            showAlertDialog("Error inserting/updating user")
        }
    }

    private fun showPersistedUsers() {
        val query = realm.where(UserRealm::class.java)
        binding.recyclerView.adapter = RealmDbAdapter(query.findAll())
        binding.recyclerView.adapter.notifyDataSetChanged()
    }
}