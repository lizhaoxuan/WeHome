package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.ISetPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.SetPresenter;
import com.zhaoxuan.wehome.framework.view.ISetView;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.view.widget.TopToast;
import com.zhaoxuan.wehome.view.widget.ValueSetLabel;

import butterknife.Bind;

public class SetActivity extends BaseActivity implements ISetView,View.OnClickListener{

    @Bind(R.id.headImg)
    protected ImageView headImg;
    @Bind(R.id.nameText)
    protected TextView nameText;
    @Bind(R.id.postLabel)
    protected ValueSetLabel postLabel;
    @Bind(R.id.homeNameLabel)
    protected ValueSetLabel homeNameLabel;
    @Bind(R.id.homeIdLabel)
    protected ValueSetLabel homeIdLabel;
    @Bind(R.id.cityLabel)
    protected ValueSetLabel cityLabel;
    @Bind(R.id.accountLabel)
    protected ValueSetLabel accountLabel;
    @Bind(R.id.passwordLabel)
    protected ValueSetLabel passwrodLabel;
    @Bind(R.id.nameImg)
    protected ImageView nameImg;
    @Bind(R.id.logoutBtn)
    protected Button logoutBtn;

    private ISetPresenter presenter;

    public static void startActivity(Activity activity){
        Intent intent = new Intent(activity,SetActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        presenter = new SetPresenter(this);
    }

    @Override
    protected void initView() {
        nameImg.setOnClickListener(this);
        nameText.setOnClickListener(this);
        headImg.setOnClickListener(this);
        postLabel.setOnClickListener(this);
        homeIdLabel.setOnClickListener(this);
        homeNameLabel.setOnClickListener(this);
        accountLabel.setOnClickListener(this);
        passwrodLabel.setOnClickListener(this);
        cityLabel.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateView();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId){
            case R.id.headImg:
                return;
            case R.id.nameText:
                return;
            case R.id.nameImg:
                return;
            case R.id.postLabel:
                return;
            case R.id.homeIdLabel:
                return;
            case R.id.homeNameLabel:
                return;
            case R.id.accountLabel:
                return;
            case R.id.cityLabel:
                return;
            case R.id.passwordLabel:
                return;
            case R.id.logoutBtn:
                return;
        }
    }

    /**
     * -------------- View方法 ----------------
     **/
    @Override
    public void updateView(UserDto user) {
        nameText.setText(user.getName());
        postLabel.setText(user.getPost());
        homeIdLabel.setText(user.getHomeId());
        homeNameLabel.setText(user.getHomeName());
        cityLabel.setText(user.getCity());
        accountLabel.setText(user.getAccount());
    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(this, msg).showPopupWindow(nameText);
    }

    @Override
    public void updateHeadImg(Bitmap bitmap) {
        headImg.setImageBitmap(bitmap);
    }
}
