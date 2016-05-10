package com.mj.mvpdemo.model;

/**
 * 作者：Nick on 2016/5/10 11:54
 * 邮箱：mj0120@foxmail.com
 */
public interface IUserBiz {
        public void login(String username, String password, OnLoginListener loginListener);
}
