package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.lizhaoxuan.cakerun.CakeRun;
import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.base.BaseViewActivity;
import com.zhaoxuan.wehome.framework.presenter.IForgetPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.LoginPresenter;
import com.zhaoxuan.wehome.framework.view.IForgetView;
import com.zhaoxuan.wehome.view.widget.ImageEditText;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class ForgetActivity extends BaseViewActivity<IForgetPresenter> implements IForgetView {
    private static final String TAG = ForgetActivity.class.getName();

    @Bind(R.id.accountEdit)
    protected ImageEditText accountEdit;

    public static void startActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, ForgetActivity.class);
//        CakeRun.getInstance().startActivity(activity,ForgetActivity.class,intent);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        setPresenter(new LoginPresenter(this));

    }

    @Override
    protected void initView() {
        setTitle("忘记密码");
    }

    @OnClick(R.id.forgetBtn)
    public void forgetOnClick() {
        presenter.forgetPassword(accountEdit.getText());
    }

    /**
     * -------------- View方法 ----------------
     **/
    @Override
    public void sendSuccess(String account) {
        Intent in = getIntent();
        in.putExtra("account", account);
        setResult(RESULT_OK, in);
        finish();
    }

    @Override
    public void showToast(String tips) {
        TopToast.makeText(this, tips).show(accountEdit);
    }

    @Override
    public void requestEnd() {

    }
}
