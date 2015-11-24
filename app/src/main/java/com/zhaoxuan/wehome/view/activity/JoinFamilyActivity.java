package com.zhaoxuan.wehome.view.activity;

import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

public class JoinFamilyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_family);
    }

    @Override
    protected void initView() {
        actionBar.setTitle("创建家庭");
    }
}
