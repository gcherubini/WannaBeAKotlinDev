package com.fittech.gcherubini.fittechandroid.view.Realm

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.fittech.gcherubini.fittechandroid.R
import com.fittech.gcherubini.fittechandroid.databinding.ActivityRealmDbBinding
import com.fittech.gcherubini.fittechandroid.view.BaseActivity
import io.realm.Realm
import com.fittech.gcherubini.fittechandroid.model.UserRealm


class RealmDbActivity : BaseActivity() {
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
        if (binding.etUserName?.text?.toString()!!.isNotBlank()) {
            val newUser = UserRealm()
            newUser.name = binding.etUserName.text.toString()
            persistUser(newUser)
        } else {
            showError("Please, fill input correctly")
        }
    }

    private fun persistUser(user: UserRealm) {
        realm.executeTransactionAsync({ bgRealm ->
            bgRealm.copyToRealm(user)
        }, {
            showPersistedUsers()
        }) {
            showError("User already persisted")
        }
    }

    private fun showPersistedUsers() {
        val query = realm.where(UserRealm::class.java)
        binding.recyclerView.adapter = RealmDbAdapter(query.findAll())
        binding.recyclerView.adapter.notifyDataSetChanged()
    }
}