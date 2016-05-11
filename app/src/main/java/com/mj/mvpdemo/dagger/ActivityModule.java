package com.mj.mvpdemo.dagger;

import com.mj.mvpdemo.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：Nick on 2016/5/11 09:25
 * 邮箱：mj0120@foxmail.com
 */

@Module
public class ActivityModule {
    @Provides
    User providesUser(){
        User user =new User();
        user.userPwd="23232";
        user.userName="what";
        return user;
    };
}
