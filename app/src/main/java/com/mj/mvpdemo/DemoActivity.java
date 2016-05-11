package com.mj.mvpdemo;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mj.mvpdemo.base.BaseApplication;
import com.mj.mvpdemo.base.DaggerBaseApplication_ApplicationComponent;
import com.mj.mvpdemo.dagger.AndroidModule;

import java.util.List;

import javax.inject.Inject;

public class DemoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ((BaseApplication) getApplication()).component().inject(this);


    }

}
