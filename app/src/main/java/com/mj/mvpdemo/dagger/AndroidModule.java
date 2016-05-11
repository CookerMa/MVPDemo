package com.mj.mvpdemo.dagger;

import android.content.Context;
import android.location.LocationManager;

import com.mj.mvpdemo.base.BaseApplication;
import com.mj.mvpdemo.base.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;

/**
 * 作者：Nick on 2016/5/11 10:48
 * 邮箱：mj0120@foxmail.com
 */

@Module
public class AndroidModule {
    BaseApplication application;
    @Singleton

    public AndroidModule(BaseApplication application){
        this.application=application;
    }


    @Provides
    @Singleton @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }
}
