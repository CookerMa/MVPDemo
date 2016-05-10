package com.mj.mvpdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mj.mvpdemo.model.User;
import com.mj.mvpdemo.presenter.UserLoginPresenter;
import com.mj.mvpdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {




    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.editText);
        mEtPassword = (EditText) findViewById(R.id.editText2);

        mBtnLogin = (Button) findViewById(R.id.button);

        mPbLoading = (ProgressBar) findViewById(R.id.pb);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });


    }


    @Override
    public String getUserName()
    {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword()
    {
        return mEtPassword.getText().toString();
    }

    @Override
    public void showLoading()
    {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading()
    {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user)
    {
        Snackbar.make(mBtnLogin, "login success", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Override
    public void showFailedError()
    {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }





}
