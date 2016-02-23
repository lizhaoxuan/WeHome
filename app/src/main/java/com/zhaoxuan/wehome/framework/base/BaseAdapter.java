package com.zhaoxuan.wehome.framework.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/24.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder<T>> {

    protected Context context;
    protected List<T> datas;
    protected BaseRecyclerHolder.ItemClickListener itemClickListener;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public void setItemClickListener(BaseRecyclerHolder.ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder<T> holder, int position) {
        holder.updateView(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}
