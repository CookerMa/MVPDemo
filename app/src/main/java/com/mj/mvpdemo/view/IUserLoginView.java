package com.mj.mvpdemo.view;

import com.mj.mvpdemo.model.User;



public interface IUserLoginView
{
    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}