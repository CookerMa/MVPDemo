package com.mj.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mj.mvpdemo.dagger.ActivityComponent;
import com.mj.mvpdemo.dagger.ActivityModule;
import com.mj.mvpdemo.dagger.DaggerActivityComponent;
import com.mj.mvpdemo.model.User;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {


    @Inject
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ActivityComponent component = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        component.inject(this);

        ((TextView) findViewById(R.id.tv)).setText(user.userName+"\n\t"+user.userPwd);

    }
}
