package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;

import butterknife.Bind;

public class ChatActivity extends BaseActivity {
    @Bind(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

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

    public void hideDrawerLayout(){
        drawerLayout.closeDrawers();
    }

}
