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
import com.zhaoxuan.wehome.framework.presenter.IRegisterPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.LoginPresenter;
import com.zhaoxuan.wehome.framework.view.IRegisterView;
import com.zhaoxuan.wehome.view.widget.ImageEditText;
import com.zhaoxuan.wehome.view.widget.TopToast;

import butterknife.Bind;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements IRegisterView{
    private static final String TAG = RegisterActivity.class.getName();

    @Bind(R.id.accountEdit)
    protected ImageEditText accountEdit;
    @Bind(R.id.passwordEdit)
    protected ImageEditText passwordEdit;
    @Bind(R.id.passwordAgainEdit)
    protected ImageEditText passwordAgainEdit;
    @Bind(R.id.registerBtn)
    protected Button registerBtn;

    private IRegisterPresenter presenter ;

    public static void startActivity(Activity activity , int requestCode){
        Intent intent = new Intent(activity,RegisterActivity.class);
        activity.startActivityForResult(intent,requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new LoginPresenter(this);

    }

    @OnClick(R.id.registerBtn)
    public void registerOnClick(){
        presenter.register(accountEdit.getText().toString(), passwordEdit.getText().toString(),
                passwordAgainEdit.getText().toString());
    }


    @Override
    public void sendSuccess() {
        ChatActivity.startActivity(this);
    }

    @Override
    public void showToast(String tips) {
        TopToast.makeText(this,tips).showPopupWindow(accountEdit);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
