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

import java.util.List;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.MyViewHolder>{
    private Context context;
    private List<WishDto> myDatas;
    private ItemClickListener itemClickListener;

    public WishListAdapter(Context context){
        this.context = context;

    }

    public void setDatas(List myDatas){
        this.myDatas = myDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_wish, parent,
                false),itemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.titleText.setText(myDatas.get(position).getTitle());
        holder.timeText.setText(myDatas.get(position).getTime());
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

    public WishDto getItemData(int position){
        return myDatas.get(position);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView wishImg;
        protected TextView titleText;
        protected TextView timeText;
        protected ItemClickListener itemClickListener;

        public MyViewHolder(View view, ItemClickListener itemClickListener) {
            super(view);
            wishImg = (ImageView) view.findViewById(R.id.wishImg);
            titleText = (TextView) view.findViewById(R.id.titleText);
            timeText = (TextView) view.findViewById(R.id.timeText);
            this.itemClickListener = itemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
