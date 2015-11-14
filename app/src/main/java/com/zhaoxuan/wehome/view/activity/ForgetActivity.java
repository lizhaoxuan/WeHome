package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.baseclass.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IForgetPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.LoginPresenter;
import com.zhaoxuan.wehome.framework.view.IForgetView;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class ForgetActivity extends BaseActivity implements IForgetView {
    private static final String TAG = ForgetActivity.class.getName();

    @Bind(R.id.accountEdit)
    protected EditText accountEdit;
    @Bind(R.id.passwordEdit)
    protected EditText passwordEdit;
    @Bind(R.id.passwordAgainEdit)
    protected EditText passwordAgainEdit;
    @Bind(R.id.forgetBtn)
    protected Button forgetBtn;

    private IForgetPresenter presenter;

    public static void startActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, ForgetActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        presenter = new LoginPresenter(this);

    }


    @OnClick(R.id.forgetBtn)
    public void forgetOnClick(){
        presenter.forgetPassword(accountEdit.getText().toString());
    }



    @Override
    public void sendSuccess(String account) {
        Intent in = getIntent();
        in.putExtra("account", account);
        setResult(RESULT_OK, in);
        finish();
    }

    @Override
    public void showToast(String tips) {
        TopToast.makeText(this, tips).showPopupWindow(accountEdit);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
