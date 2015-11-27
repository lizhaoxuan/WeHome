package com.zhaoxuan.wehome.view.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 家庭计划页ViewPager Adapter
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPagerAdapter extends PagerAdapter {
    private List<View> viewList;

    public WishPagerAdapter(List viewList){
        this.viewList = viewList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)   {
        container.removeView(viewList.get(position));
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position), 0);
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return  viewList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
}
