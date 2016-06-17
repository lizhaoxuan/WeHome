package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.view.holder.MemorialDayHolder;

/**
 * Created by lizhaoxuan on 16/1/5.
 */
public class MemorialListAdapter extends BaseAdapter<MemorialDto> {

    public MemorialListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<MemorialDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemorialDayHolder(context, R.layout.item_memorial, parent, itemClickListener);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
