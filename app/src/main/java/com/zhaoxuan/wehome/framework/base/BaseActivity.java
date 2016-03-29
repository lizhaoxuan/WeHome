package com.zhaoxuan.wehome.framework.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zhaoxuan.wehome.view.widget.ToolBarHelper;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected Toolbar toolbar;

    private T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        ToolBarHelper toolBarHelper = new ToolBarHelper(this, layoutResID);
        toolbar = toolBarHelper.getToolBar();

        setContentView(toolBarHelper.getContentView());
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(toolbar);
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar);
        ButterKnife.bind(this);
        initView();
    }

    public T setPresenter(Class<T> pClazz) {
        try {
            presenter = pClazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presenter;
    }

    final public T getPresenter() {
        return presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void onCreateCustomToolBar(Toolbar toolbar) {
        toolbar.setContentInsetsRelative(0, 0);
    }

    protected abstract void initView();

    protected void setTitle(String title) {
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
