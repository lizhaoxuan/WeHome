package com.zhaoxuan.wehome.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.module.weather.Weather;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/12.
 */
public class FamilyListAdapter extends RecyclerView.Adapter<FamilyListAdapter.MyViewHolder> {

    private Context context;
    private List<FamilyDto> myDatas = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public FamilyListAdapter(Context context) {
        this.context = context;

    }

    public void setDatas(List<FamilyDto> myDatas) {
        this.myDatas = myDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_family_left, parent,
                    false), itemClickListener);
        } else {
            return new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.item_family_right, parent,
                    false), itemClickListener);
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        FamilyDto familyDto = myDatas.get(position);

        holder.nameText.setText(familyDto.getFullName());
        holder.cityText.setText(familyDto.getCity());
        Weather.getWeather(familyDto.getCity(), new Weather.WeatherCallBack() {
            @Override
            public void onSuccess(String weather) {
                holder.weatherText.setText(weather);
            }
        });
    }

    @Override
    public int getItemCount() {

        return myDatas == null ? 0 : myDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return myDatas == null ? 0 : myDatas.get(position).getId();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView headImg;
        protected ImageView electricImg;
        protected TextView nameText;
        protected TextView cityText;
        protected TextView weatherText;
        protected ItemClickListener itemClickListener;

        public MyViewHolder(View view, ItemClickListener itemClickListener) {
            super(view);
            headImg = (ImageView) view.findViewById(R.id.headImg);
            electricImg = (ImageView) view.findViewById(R.id.electricImg);
            nameText = (TextView) view.findViewById(R.id.nameText);
            cityText = (TextView) view.findViewById(R.id.cityText);
            weatherText = (TextView) view.findViewById(R.id.weatherText);

            this.itemClickListener = itemClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, (int) getItemId());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }


}
