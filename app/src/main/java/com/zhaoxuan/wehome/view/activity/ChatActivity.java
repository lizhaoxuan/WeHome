package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.baseclass.BaseActivity;

public class ChatActivity extends BaseActivity {


    public static void startActivity(Activity activity){
        activity.startActivity(new Intent(activity,ChatActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    @Override
    protected void initView() {

    }
}
