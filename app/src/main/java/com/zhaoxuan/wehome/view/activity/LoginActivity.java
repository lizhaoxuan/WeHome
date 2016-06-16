package com.zhaoxuan.wehome.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.ILoginPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.LoginPresenter;
import com.zhaoxuan.wehome.framework.view.ILoginView;
import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.constants.Ints;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<ILoginPresenter> implements ILoginView {
    private static final String TAG = LoginActivity.class.getName();

    @Bind(R.id.loginBtn)
    protected Button loginBtn;
    @Bind(R.id.accountEdit)
    protected EditText accountEdit;
    @Bind(R.id.passwordEdit)
    protected EditText passwordEdit;
    @Bind(R.id.logoLayout)
    protected LinearLayout logoLayout;
    @Bind(R.id.bottomLayout)
    protected RelativeLayout bottomLayout;

    // 用于计算logo布局的高度，从而监听软键盘的弹出与隐藏
    private int logoLayoutHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setPresenter(new LoginPresenter(this));

        initView();
    }

    private void initView() {
        //临时
        accountEdit.setText("690770333@qq.com");
        passwordEdit.setText("123456");

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //根据输入法调整View移动
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        /**
         * 软键盘的弹出和隐藏监听方法。（原理：通过监听布局变化判断软键盘是否弹出）
         * 通过监听键盘弹出和隐藏 从而改变布局效果
         * 纯View内部逻辑改变，且需求随时可能变化，不建议放入model层
         */
        logoLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                WLog.d("LoginActivity", "logoLayout.getHeight:  " + logoLayout.getHeight());
                WLog.d("LoginActivity", "logoLayoutHeight:  " + logoLayoutHeight);
                //初次情况，通常为View初次加载，或计算到logo布局的最大高度
                if (logoLayout.getHeight() > logoLayoutHeight) {
                    logoLayoutHeight = logoLayout.getHeight();
                    //logoIcon.setImageResource(R.drawable.ic_login_logo);
                    bottomLayout.setVisibility(View.VISIBLE);
                } else {
                    //当logo布局的最大高度与最小高度只差超过150时，通常为软键盘弹出
                    //大分辨率手机没有问题，可能有误差的是小分辨率手机，以测公司最小测试机--HTC
                    if (logoLayoutHeight - logoLayout.getHeight() > 250) {
                        WLog.v("LoginActivity", "open keyboard");
                        //logoIcon.setImageResource(R.drawable.ic_login_word);
                        bottomLayout.setVisibility(View.GONE);
                    } else {
                        WLog.v("LoginActivity", "close keyboard");
                        //logoIcon.setImageResource(R.drawable.ic_login_logo);
                        bottomLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    @OnClick(R.id.loginBtn)
    public void loginClick() {
        presenter.login(accountEdit.getText().toString(),
                passwordEdit.getText().toString());
    }

    @OnClick(R.id.registerText)
    protected void registerClick() {
        RegisterActivity.startActivity(this, Ints.INTENT_REGISTER);
    }

    @OnClick(R.id.forgetText)
    protected void forgetClick() {
        ForgetActivity.startActivity(this, Ints.INTENT_FORGET);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            presenter.onActivityResult(requestCode, resultCode, data.getStringExtra("account"));
        }
    }

    /**
     * -------------- View方法 ----------------
     **/
    @Override
    public void loginSuccess(Class clazz) {
        startActivity(new Intent(this, clazz));
        this.finish();
    }

    @Override
    public void showToast(String tips) {
        TopToast.makeText(this, tips).show(loginBtn, TopToast.StateHeight);
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
    public void setAccountEdit(String account) {
        accountEdit.setText(account);
    }

    @Override
    public void clearEdit() {
        accountEdit.setText("");
        passwordEdit.setText("");
    }
}
