package com.zhaoxuan.wehome.framework.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zhaoxuan.wehome.view.widget.ToolBarHelper;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 16/3/30.
 */
public abstract class BaseViewActivity extends BaseActivity {

    protected Toolbar toolbar;

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
