package com.mj.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mj.mvpdemo.dagger.ActivityComponent;
import com.mj.mvpdemo.dagger.ActivityModule;
import com.mj.mvpdemo.dagger.ContentComonent;
import com.mj.mvpdemo.dagger.ContentModule;
import com.mj.mvpdemo.dagger.DaggerActivityComponent;
import com.mj.mvpdemo.dagger.DaggerContentComonent;
import com.mj.mvpdemo.model.Mobile;
import com.mj.mvpdemo.model.User;

import javax.inject.Inject;

/**
 * 每次重新编译很麻烦
 */
public class DaggerActivity extends AppCompatActivity {


    @Inject
    User user;
    @Inject
    Mobile mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ActivityComponent component = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        ContentComonent comonent = DaggerContentComonent.builder().activityComponent(component).contentModule(new ContentModule()).build();

        comonent.inject(this);
        ((TextView) findViewById(R.id.tv)).setText("用户名" + user.userName + "\n\t 密码" + user.userPwd + "\n\t 手机" + mobile.num);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaggerActivity.this,DemoActivity.class));
            }
        });

    }
}
