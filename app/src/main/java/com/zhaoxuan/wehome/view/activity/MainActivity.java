package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.loadImg)
    protected ImageView loadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init(){
        if (UserManager.getInstance().getUserDto() == null){
            initView(LoginActivity.class);
        }else {
            initView(ChatActivity.class);
        }
    }

    private void initView(final Class<? extends Activity> clazz) {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.main_loading);
        loadImg.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this, clazz));
                MainActivity.this.finish();
                overridePendingTransition(R.anim.activity_enter,R.anim.activity_exit);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
