package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
import com.zhaoxuan.wehome.view.widget.SetDialog;
import com.zhaoxuan.wehome.view.widget.TopToast;
import com.zhaoxuan.wehome.view.widget.ValueSetLabel;

import butterknife.Bind;

public class SetActivity extends BaseActivity implements ISetView, View.OnClickListener, SetDialog.ISetDialogListener {

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

    private SetDialog setDialog;

    private ISetPresenter presenter;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, SetActivity.class);
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
        setTitle("设置");

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
        //不可重复使用
        setDialog = SetDialog.makeDialog(this, this);
        int viewId = v.getId();
        switch (viewId) {
            case R.id.headImg:
                return;
            case R.id.nameText:
                setDialog.show(UserDto.KEY_NAME, "修改昵称", nameText.getText().toString());
                return;
            case R.id.nameImg:
                setDialog.show(UserDto.KEY_NAME, "修改昵称", nameText.getText().toString());
                return;
            case R.id.postLabel:
                setDialog.show(UserDto.KEY_POST, "修改" + postLabel.getKeyText()
                        , postLabel.getText());
                return;
            case R.id.homeIdLabel:
                setDialog.show(UserDto.KEY_HOME_ID, homeIdLabel.getKeyText()
                        , homeIdLabel.getText());
                return;
            case R.id.homeNameLabel:
                setDialog.show(UserDto.KEY_HOME_NAME, "修改" + homeNameLabel.getKeyText()
                        , homeNameLabel.getText());
                return;
            case R.id.accountLabel:
                setDialog.show(UserDto.KEY_ACCOUNT, accountLabel.getKeyText()
                        , accountLabel.getText());
                return;
            case R.id.cityLabel:
                setDialog.show(UserDto.KEY_CITY, "修改" + cityLabel.getKeyText()
                        , cityLabel.getText());
                return;
            case R.id.passwordLabel:
                setDialog.show(UserDto.KEY_PASSWORD, "修改密码", "");
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

    @Override
    public void hideDialog() {
        if (setDialog != null && setDialog.isShowing()) {
            setDialog.dismiss();
        }
    }

    /**
     * Set Dialog 事件方法
     **/
    @Override
    public void enterClick(int key, String args1, String args2, String args3) {
        presenter.changePassword(args1, args2, args3);
    }

    @Override
    public void enterClick(int key, String args1) {
        presenter.setValue(key, args1);
    }
}
