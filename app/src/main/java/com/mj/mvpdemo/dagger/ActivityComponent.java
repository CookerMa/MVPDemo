package com.mj.mvpdemo.dagger;

import com.mj.mvpdemo.model.User;

import dagger.Component;

/**
 * 作者：Nick on 2016/5/11 09:29
 * 邮箱：mj0120@foxmail.com
 */
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
//    void inject(DaggerActivity activity);
    User user();
}
