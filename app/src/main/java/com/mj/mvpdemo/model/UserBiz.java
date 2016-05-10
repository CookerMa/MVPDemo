package com.mj.mvpdemo.model;

/**
 * 作者：Nick on 2016/5/10 11:54
 * 邮箱：mj0120@foxmail.com
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener)
    {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("name".equals(username) && "123".equals(password))
                {
                    User user = new User();

                    user.userName=username;
                    user.userPwd=password;
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
