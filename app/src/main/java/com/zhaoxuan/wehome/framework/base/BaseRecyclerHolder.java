package com.zhaoxuan.wehome.framework.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public abstract class BaseRecyclerHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected View view;

    protected ItemClickListener itemClickListener;

    public BaseRecyclerHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.view = itemView;
        this.itemClickListener = itemClickListener;
        this.view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null){
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public abstract void updateView(T data);

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
