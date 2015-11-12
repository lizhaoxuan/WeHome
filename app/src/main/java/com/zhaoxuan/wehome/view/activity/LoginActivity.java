package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
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
import com.zhaoxuan.wehome.framework.view.ILoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends Activity implements ILoginView{

    @Bind(R.id.forgetText)
    protected TextView forgetText;
    @Bind(R.id.registerText)
    protected TextView registerText;
    @Bind(R.id.loginBtn)
    protected Button loginBtn;
    @Bind(R.id.accountEdit)
    protected EditText AccountEdit;
    @Bind(R.id.passwordEdit)
    protected EditText PasswordEdit;
    @Bind(R.id.logoLayout)
    protected LinearLayout logoLayout;
    @Bind(R.id.logoIcon)
    protected ImageView logoIcon ;
    @Bind(R.id.concealView)
    protected View concealView;  //为了撑开布局的透明View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //根据输入法调整View移动
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        

    }


    @OnClick(R.id.loginBtn)
    public void loginClick(){
        System.out.println("asdadasdas");
    }

    @OnClick(R.id.registerText)
    protected void registerClick(){

    }

    @OnClick(R.id.forgetText)
    protected void forgetClick(){

    }



    @Override
    public void loginSuccess() {

    }

    @Override
    public void showToast() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
