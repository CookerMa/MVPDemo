package com.mj.mvpdemo.base;

import android.app.Application;
import android.location.LocationManager;
import android.util.Log;

import com.mj.mvpdemo.DemoActivity;
import com.mj.mvpdemo.dagger.AndroidModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：Nick on 2016/5/11 10:47
 * 邮箱：mj0120@foxmail.com
 */
public class BaseApplication extends Application {

    private  final  String TAG= this.getClass().getSimpleName();
    @Singleton
    @Component(modules = AndroidModule.class)
    public interface ApplicationComponent{
        void inject(BaseApplication application);
        void inject(DemoActivity activity);
    }

    @Inject
    LocationManager locationManager; // for some reason.

    private ApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerBaseApplication_ApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
        component().inject(this); // As of now, LocationManager should be injected into this.
        List<String> providers = locationManager.getProviders(true);
        if (!providers.isEmpty() && providers.size()>0){
            for (String provide :providers){
                Log.e(TAG, provide);
            }
        }

    }

    public ApplicationComponent component() {
        return component;
    }
}
