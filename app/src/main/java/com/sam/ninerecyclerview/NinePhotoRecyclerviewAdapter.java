package com.sam.ninerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NinePhotoRecyclerviewAdapter extends RecyclerView.Adapter<NinePhotoRecyclerviewAdapter.ViewHolder> {
    //标题九宫格内容
    private List list;
    private Context context;

    public NinePhotoRecyclerviewAdapter(MainActivity mainActivity, List list) {
        this.list = list;
        this.context = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建ViewHolder，返回每一项的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_online_gridnavigation1, parent, false);
        final NinePhotoRecyclerviewAdapter.ViewHolder holder = new NinePhotoRecyclerviewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.navigationPhoto.setImageResource((Integer) list.get(position));

        holder.navigationPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击的是：" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() > 9 ? 9 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView navigationPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            navigationPhoto = (ImageView) itemView.findViewById(R.id.navigation_photo);
        }
    }
}
