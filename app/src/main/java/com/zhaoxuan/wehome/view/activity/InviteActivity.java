package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IInvitePresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.InvitePresenter;
import com.zhaoxuan.wehome.framework.view.IInviteView;
import com.zhaoxuan.wehome.view.widget.ImageEditText;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class InviteActivity extends BaseActivity implements IInviteView{
    private static final int PICK_CONTACT_SUBACTIVITY = 1;

    @Bind(R.id.phoneEdit)
    protected ImageEditText phoneEdit;

    private IInvitePresenter mPresenter;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, InviteActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

//        mPresenter = new InvitePresenter(this);
    }

    protected void initView() {
        setTitle("邀请家人");
    }


    @OnClick(R.id.contactBtn)
    protected void contactBtnOnClick() {
        Uri uri = Uri.parse("content://contacts/people");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, PICK_CONTACT_SUBACTIVITY);
    }

    @OnClick(R.id.sendBtn)
    protected void sendBtnOnClick() {
        mPresenter.send(phoneEdit.getText());    // 取得输入信息
    }


    /**
     * -------------- View方法 ----------------
     **/

    @Override
    public void sendMessage(String phone,String message) {
        Uri uri = Uri.parse("smsto:" + phone);    // 设置操作的路径
        Intent it = new Intent();
        it.setAction(Intent.ACTION_SENDTO);    // 设置要操作的Action
        it.putExtra("sms_body", message);    // 设置短信内容
        it.setType("vnd.android-dir/mms-sms");    // 短信的MIME类型
        it.setData(uri);    // 要设置的数据
        InviteActivity.this.startActivity(it);    // 执行跳转
    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(InviteActivity.this,msg)
                .show(phoneEdit);
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
}
