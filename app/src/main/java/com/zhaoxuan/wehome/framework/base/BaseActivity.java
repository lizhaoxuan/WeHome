package com.zhaoxuan.wehome.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class BaseActivity<T> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BasePresenter)presenter).onCreate();
        DispenseBus.getInstance().register(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((BasePresenter)presenter).onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((BasePresenter)presenter).onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((BasePresenter)presenter).onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ((BasePresenter)presenter).onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BasePresenter)presenter).onDestroy();
        DispenseBus.getInstance().unRegister(this);
        ButterKnife.unbind(this);
    }
}
