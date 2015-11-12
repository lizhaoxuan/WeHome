package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }


    @Override
    public void loginSuccess() {

    }

    @Override
    public void showToast() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
