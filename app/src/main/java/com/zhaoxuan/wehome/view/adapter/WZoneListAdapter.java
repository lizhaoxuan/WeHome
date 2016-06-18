package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.view.holder.WZoneHolder;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class WZoneListAdapter extends BaseAdapter<WZoneDto> {

    public WZoneListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<WZoneDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WZoneHolder(context, R.layout.item_wzone, parent, itemClickListener);
    }
}
