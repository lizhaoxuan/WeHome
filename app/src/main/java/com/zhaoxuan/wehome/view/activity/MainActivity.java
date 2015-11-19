package com.zhaoxuan.wehome.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.baseclass.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, LoginActivity.class));
        this.finish();

    }

    @Override
    protected void initView() {

    }
}
