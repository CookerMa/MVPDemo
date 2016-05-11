package com.mj.mvpdemo.dagger;

import com.mj.mvpdemo.DaggerActivity;

import dagger.Component;

/**
 * 作者：Nick on 2016/5/11 10:16
 * 邮箱：mj0120@foxmail.com
 */

@Component(dependencies = ActivityComponent.class,modules = ContentModule.class)
public interface ContentComonent {
    void inject(DaggerActivity activity);
}
