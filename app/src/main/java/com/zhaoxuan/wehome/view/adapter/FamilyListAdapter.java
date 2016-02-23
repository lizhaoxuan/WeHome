package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BaseAdapter;
import com.zhaoxuan.wehome.framework.base.BaseRecyclerHolder;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.view.holder.FamilyHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/12.
 */
public class FamilyListAdapter extends BaseAdapter<FamilyDto> {

    public FamilyListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseRecyclerHolder<FamilyDto> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new FamilyHolder(context, R.layout.item_family_left, parent, itemClickListener);
        } else {
            return new FamilyHolder(context, R.layout.item_family_right, parent, itemClickListener);
        }
    }

    @Override
    public long getItemId(int position) {
        return datas == null ? 0 : datas.get(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }


}
