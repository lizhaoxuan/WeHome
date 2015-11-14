package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.presenter.ILoginPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.LoginPresenter;
import com.zhaoxuan.wehome.framework.view.ILoginView;
import com.zhaoxuan.wehome.support.constants.Ints;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends Activity implements ILoginView{
    private static final String TAG = LoginActivity.class.getName();

    @Bind(R.id.forgetText)
    protected TextView forgetText;
    @Bind(R.id.registerText)
    protected TextView registerText;
    @Bind(R.id.loginBtn)
    protected Button loginBtn;
    @Bind(R.id.accountEdit)
    protected EditText accountEdit;
    @Bind(R.id.passwordEdit)
    protected EditText passwordEdit;
    @Bind(R.id.logoLayout)
    protected LinearLayout logoLayout;
    @Bind(R.id.logoIcon)
    protected ImageView logoIcon ;
    @Bind(R.id.concealView)
    protected View concealView;  //为了撑开布局的透明View

    private ILoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //根据输入法调整View移动
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


    }


    @OnClick(R.id.loginBtn)
    public void loginClick(){
        mPresenter.login(accountEdit.getText().toString(),
                passwordEdit.getText().toString());
    }

    @OnClick(R.id.registerText)
    protected void registerClick(){
        RegisterActivity.startActivity(this, Ints.INTENT_REGISTER);
    }

    @OnClick(R.id.forgetText)
    protected void forgetClick(){
        ForgetActivity.startActivity(this,Ints.INTENT_FORGET);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mPresenter.onActivityResult(requestCode,resultCode,data.getStringExtra("account"));

    }

    @Override
    public void loginSuccess(Class clazz) {
        startActivity(new Intent(this,clazz));
    }

    @Override
    public void showToast(String tips) {
        TopToast.makeText(this,tips).showPopupWindow(loginBtn,TopToast.StateHeight);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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
