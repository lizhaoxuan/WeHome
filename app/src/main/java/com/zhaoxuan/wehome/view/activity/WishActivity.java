package com.zhaoxuan.wehome.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseActivity;
import com.zhaoxuan.wehome.framework.presenter.IWishDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWishPresenter;
import com.zhaoxuan.wehome.framework.presenter.impl.WishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.support.dto.WishDto;
import com.zhaoxuan.wehome.view.adapter.WishListAdapter;
import com.zhaoxuan.wehome.view.adapter.WishPagerAdapter;
import com.zhaoxuan.wehome.view.widget.TopToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class WishActivity extends BaseActivity implements IWishView {

    @Bind(R.id.refreshLayout)
    protected SwipeRefreshLayout refreshLayout;
    /**
     * tab页卡标签  用作添加点击事件，保证整个标签都可以点击
     **/
    @Bind(R.id.finishLayout)
    protected LinearLayout finishLayout;
    @Bind(R.id.unFinishLayout)
    protected LinearLayout unFinishLayout;
    @Bind(R.id.finishCursor)
    protected View finishCursor;
    @Bind(R.id.unFinishCursor)
    protected View unFinishCursor;
    @Bind(R.id.finishImg)
    protected ImageView finishImg;
    @Bind(R.id.unFinishImg)
    protected ImageView unFinishImg;
    @Bind(R.id.viewPager)
    protected ViewPager viewPager;

    /*viewPager 子view*/
    private View finishView;
    private View unFinishView;
    /*子ListView*/
    private RecyclerView finishListView;
    private RecyclerView unFinishListView;

    /*Tab页面列表  */
    private List<View> views = new ArrayList<>();

    private WishListAdapter unFinishlistAdapter;
    private WishListAdapter finishlistAdapter;

    private IWishPresenter presenter;

    public static void stratActivity(Activity activity) {
        Intent intent = new Intent(activity, WishActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish);

        presenter = new WishPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    @Override
    protected void initView() {
        actionBar.setTitle("家庭计划");

        LayoutInflater inflater = getLayoutInflater();
        finishView = inflater.inflate(R.layout.layout_wish_list, null);
        unFinishView = inflater.inflate(R.layout.layout_wish_list, null);
        finishListView = (RecyclerView) finishView.findViewById(R.id.recyclerView);
        unFinishListView = (RecyclerView) unFinishView.findViewById(R.id.recyclerView);

        views.add(finishView);
        views.add(unFinishView);

        viewPager.setAdapter(new WishPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPagerOnPageChangeListener());
        setViewPagerCursor(viewPager.getCurrentItem());

        unFinishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        finishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });



        unFinishlistAdapter = new WishListAdapter(this);
        finishlistAdapter = new WishListAdapter(this);
        finishListView.setLayoutManager(new LinearLayoutManager(this));
        finishListView.setAdapter(finishlistAdapter);
        unFinishListView.setLayoutManager(new LinearLayoutManager(this));
        unFinishListView.setAdapter(unFinishlistAdapter);

        presenter.initData();
    }



    /***
     * View 方法
     */

    /**
     * 数据源有P进行存储
     * 之前只有一个updateView  为了避免每一次小修改都导致整个ListView全部替换
     * 改为initData    updateData
     */
    @Override
    public void initData(List<WishDto> unFinishList, List<WishDto> finishList) {
        finishlistAdapter.setDatas(finishList);
        unFinishlistAdapter.setDatas(unFinishList);
    }

    @Override
    public void updateData() {
        finishlistAdapter.notifyDataSetChanged();
        unFinishlistAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String msg) {
        TopToast.makeText(this, msg).showPopupWindow(viewPager);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void doNoDataTip() {

    }

    /**
     * 设置 ViewPager 光标
     *
     * @param position
     */
    private void setViewPagerCursor(int position) {

        switch (position) {
            case 0:
                unFinishCursor.setVisibility(View.VISIBLE);
                finishCursor.setVisibility(View.GONE);
                unFinishImg.setImageResource(R.drawable.btn_un_finish_light);
                finishImg.setImageResource(R.drawable.btn_finish);
                return;
            case 1:
                unFinishCursor.setVisibility(View.GONE);
                finishCursor.setVisibility(View.VISIBLE);
                unFinishImg.setImageResource(R.drawable.btn_un_finish);
                finishImg.setImageResource(R.drawable.btn_finish_light);
                return;
        }
    }

    /**
     * ViewPager 切换监听
     */
    public class ViewPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

        public void onPageScrollStateChanged(int arg0) {
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageSelected(int arg0) {
            /**
             * ViewPager 切换时，改变光标
             */
            setViewPagerCursor(viewPager.getCurrentItem());
            Toast.makeText(WishActivity.this, "第" + arg0 + "页", Toast.LENGTH_SHORT).show();
        }
    }
}
