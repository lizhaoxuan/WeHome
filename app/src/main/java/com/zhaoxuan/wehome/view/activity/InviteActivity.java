package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.baseclass.BaseActivity;
import com.zhaoxuan.wehome.view.widget.ImageEditText;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class InviteActivity extends BaseActivity {
    private static final int PICK_CONTACT_SUBACTIVITY = 1;

    @Bind(R.id.phoneEdit)
    protected ImageEditText phoneEdit;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, InviteActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
    }

    @Override
    protected void initView() {
        actionBar.setTitle("邀请家人");
    }


    @OnClick(R.id.sendBtn)
    protected void sendBtnOnClick() {
        Uri uri = Uri.parse("content://contacts/people");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, PICK_CONTACT_SUBACTIVITY);
    }

    @OnClick(R.id.contactBtn)
    protected void contactBtnOnClick() {
        String telStr = InviteActivity.this.phoneEdit.getText();    // 取得输入信息
        if (telStr.equals("")) {
            TopToast.makeText(InviteActivity.this, "电话号码为空怎么可以哦。。。")
                    .showPopupWindow(phoneEdit);
        } else {
            String note = "集合啦！我已经在爱+创建了一个小微家，超有爱的应用哦。。。满满的都是爱！微家的账号是 690770333@qq.com   这是下载链接。快来哦！" +
                    "1.myweijia.sinaapp.com/upload.php";    // 取得内容
            Uri uri = Uri.parse("smsto:" + telStr);    // 设置操作的路径
            Intent it = new Intent();
            it.setAction(Intent.ACTION_SENDTO);    // 设置要操作的Action
            it.putExtra("sms_body", note);    // 设置短信内容
            it.setType("vnd.android-dir/mms-sms");    // 短信的MIME类型
            it.setData(uri);    // 要设置的数据
            InviteActivity.this.startActivity(it);    // 执行跳转
        }

    }


}
