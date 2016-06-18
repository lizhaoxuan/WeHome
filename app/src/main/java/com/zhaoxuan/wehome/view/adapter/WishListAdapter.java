package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.WishDto;
import com.zhaoxuan.wehome.view.holder.WishHolder;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishListAdapter extends BaseAdapter<WishDto> {

    public WishListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<WishDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WishHolder(context, R.layout.item_wish, parent, itemClickListener);
    }
}
