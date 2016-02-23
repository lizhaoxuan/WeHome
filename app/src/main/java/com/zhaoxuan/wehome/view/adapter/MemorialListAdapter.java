package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;
import com.zhaoxuan.wehome.view.holder.MemorialDayHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/5.
 */
public class MemorialListAdapter extends BaseAdapter<MemorialDayDto> {

    public MemorialListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<MemorialDayDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemorialDayHolder(context,R.layout.item_memorial,parent,itemClickListener);
    }

    @Override
    public long getItemId(int position) {
        return datas == null ? 0 : datas.get(position).getId();
    }


}
