package com.fittech.gcherubini.fittechandroid.view.Home;


import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.fittech.gcherubini.fittechandroid.BR;
import com.fittech.gcherubini.fittechandroid.R;
import com.fittech.gcherubini.fittechandroid.databinding.ActivityHomeBinding;
import com.fittech.gcherubini.fittechandroid.model.User;
import com.fittech.gcherubini.fittechandroid.view.BaseActivityJava;
import com.fittech.gcherubini.fittechandroid.view.RecyclerList.ListActivity;

public class HomeActivityJava extends BaseActivityJava {
    private final String USER_NAME =  "Albert Eisten";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding =  DataBindingUtil.setContentView(this, R.layout.activity_home);
        User user = new User(USER_NAME);
        binding.setVariable(BR.user, user);
        binding.executePendingBindings();

        showAlertDialog("Press OK and move to next View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveForward(new ListActivity());
            }
        });
    }
}