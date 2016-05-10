package com.mj.mvpdemo.model;

public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}