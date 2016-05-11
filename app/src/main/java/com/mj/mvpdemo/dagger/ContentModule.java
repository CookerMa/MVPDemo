package com.mj.mvpdemo.dagger;

import com.mj.mvpdemo.model.Mobile;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：Nick on 2016/5/11 10:12
 * 邮箱：mj0120@foxmail.com
 */
@Module
public class ContentModule {
    @Provides
    Mobile getMoblie(){
      return new Mobile("18956364521");
    };
}
