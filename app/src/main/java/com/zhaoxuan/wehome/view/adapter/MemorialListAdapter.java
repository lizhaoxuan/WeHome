package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/5.
 */
public class MemorialListAdapter extends RecyclerView.Adapter<MemorialListAdapter.MyViewHolder>{

    private Context context;
    private List<WishDto> myDatas = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public MemorialListAdapter(Context context){
        this.context = context;

    }

    public void setDatas(List myDatas){
        this.myDatas = myDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_memorial, parent,
                false),itemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.titleText.setText(myDatas.get(position).getTitle());
        holder.dayText.setText(myDatas.get(position).getTime());
        //图片加载暂缺

    }

    @Override
    public int getItemCount()
    {
        return myDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return myDatas.get(position).getId();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView titleText;
        protected TextView dayText;
        protected ItemClickListener itemClickListener;

        public MyViewHolder(View view, ItemClickListener itemClickListener) {
            super(view);
            titleText = (TextView) view.findViewById(R.id.titleText);
            dayText = (TextView) view.findViewById(R.id.dayText);
            this.itemClickListener = itemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, (int)getItemId());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
