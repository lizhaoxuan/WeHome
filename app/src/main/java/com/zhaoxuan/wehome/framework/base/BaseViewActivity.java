package com.zhaoxuan.wehome.framework.base;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.support.embedview.EmbedManager;
import com.zhaoxuan.wehome.support.embedview.EmbedView;
import com.zhaoxuan.wehome.view.widget.NoDataTips;

import butterknife.ButterKnife;

/**
 * Created by lizhaoxuan on 16/3/30.
 */
public abstract class BaseViewActivity<T> extends BaseActivity<T> implements IBaseView{

    /**
     * 子类可以通过rootView获取提前包装好的公共控件
     */
    protected EmbedView rootView;
    protected Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        initEmbedView(layoutResID);

        setContentView(rootView);
        /*把 toolbar 设置到Activity 中*/
        setSupportActionBar(toolbar);
        /*自定义的一些操作*/
        onCreateCustomToolBar(toolbar);
        ButterKnife.bind(this);
        initView();

    }

    private void initEmbedView(int layoutResID){
        EmbedManager embedManager = new EmbedManager.Builder(this, layoutResID)
                .addToolbar(R.layout.widget_toolbar, R.id.id_tool_bar)
                .addCenterTipView(new NoDataTips(this))
                .addLoadView(LayoutInflater.from(this).inflate(R.layout.widget_loading_view, null))
                .build();
        rootView = embedManager.getEmbedView();
        toolbar = rootView.getToolbar();
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


    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        rootView.showLoadView();
    }

    @Override
    public void hideLoading() {
        rootView.hideLoadView();
    }
}
