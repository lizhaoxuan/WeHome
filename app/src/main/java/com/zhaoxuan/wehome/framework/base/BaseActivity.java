package com.zhaoxuan.wehome.framework.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class BaseActivity<T> extends AppCompatActivity {

    protected T presenter;

    protected void setPresenter(T presenter){
        DispenseBus.getInstance().register(presenter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null){
            ((BasePresenter) presenter).onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null){
            ((BasePresenter) presenter).onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null){
            ((BasePresenter) presenter).onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null){
            ((BasePresenter) presenter).onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            ((BasePresenter) presenter).onDestroy();
        }
        DispenseBus.getInstance().unRegister(this);
        ButterKnife.unbind(this);
    }
}
