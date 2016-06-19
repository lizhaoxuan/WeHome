package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.ISetPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.SetPresenter;
import com.zhaoxuan.wehome.framework.view.ISetView;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.view.widget.MessageDialog;
import com.zhaoxuan.wehome.view.widget.SetDialog;
import com.zhaoxuan.wehome.view.widget.TopToast;
import com.zhaoxuan.wehome.view.widget.ValueSetLabel;

import butterknife.Bind;
import butterknife.OnClick;

public class SetActivity extends BaseViewActivity<ISetPresenter> implements ISetView, SetDialog.ISetDialogListener {
    protected static final int RESULT_LOAD_IMAGE = 1;

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
    protected ValueSetLabel passwordLabel;
    @Bind(R.id.nameImg)
    protected ImageView nameImg;
    @Bind(R.id.logoutBtn)
    protected Button logoutBtn;

    private SetDialog setDialog;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, SetActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        setPresenter(new SetPresenter(this));
    }

    @Override
    protected void initView() {
        setTitle("设置");
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateView();
    }

    @OnClick({R.id.nameImg, R.id.nameText, R.id.headImg, R.id.postLabel, R.id.homeIdLabel,
            R.id.homeNameLabel, R.id.accountLabel, R.id.passwordLabel,
            R.id.cityLabel, R.id.logoutBtn})
    public void onClick(View v) {
        //不可重复使用
        setDialog = SetDialog.makeDialog(this, this);
        int viewId = v.getId();
        switch (viewId) {
            case R.id.headImg:
                Intent i=new Intent(Intent.ACTION_PICK , android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
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
                MessageDialog.makeDialog(this, new MessageDialog.IDialogListener() {
                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onEnter() {
                        presenter.logout();
                    }
                }).show("退出登录", "你确定要注销账号登出吗？");
                return;
                default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            presenter.setHeadImg(picturePath);
        }
    }

    /**
     * -------------- View方法 ----------------
     **/
    @Override
    public void updateView(String name, String post, String homeId, String homeName, String city, String account) {
        nameText.setText(name);
        postLabel.setText(post);
        homeIdLabel.setText(homeId);
        homeNameLabel.setText(homeName);
        cityLabel.setText(city);
        accountLabel.setText(account);
    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(this, msg).show(nameText);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void requestEnd() {

    }

    @Override
    public void updateHeadImg(Drawable drawable) {
        headImg.setImageDrawable(drawable);
    }

    public void hideDialog() {
        if (setDialog != null && setDialog.isShowing()) {
            setDialog.dismiss();
        }
    }

    @Override
    public void toLoginActivity() {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    /**
     * Set Dialog 事件方法
     **/
    @Override
    public void enterClick(int key, String args1, String args2, String args3) {
        presenter.changePassword(args1, args2, args3);
    }

    @Override
    public void enterClick(int key, String textStr, String hintStr) {
        presenter.setValue(key, textStr, hintStr);
    }
}
