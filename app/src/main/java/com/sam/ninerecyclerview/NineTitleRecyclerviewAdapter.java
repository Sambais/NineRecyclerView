package com.sam.ninerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NineTitleRecyclerviewAdapter extends RecyclerView.Adapter<NineTitleRecyclerviewAdapter.ViewHolder> {
    //标题九宫格内容
    private List<List> lists;
    //默认处理的行数填满
    private int rowsnum = 3;
    //默认字体大小
    private int textSize = 12;

    public NineTitleRecyclerviewAdapter(List<List> lists) {
        this.lists = lists;
    }

    public NineTitleRecyclerviewAdapter(int rowsnum, List<List> lists) {
        this.rowsnum = rowsnum;
        this.lists = lists;
    }

    public NineTitleRecyclerviewAdapter(int rowsnum, List<List> lists, int textSize) {
        this.rowsnum = rowsnum;
        this.lists = lists;
        this.textSize = textSize;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建ViewHolder，返回每一项的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_online_gridnavigation2, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position < lists.size()) {
            holder.navigationPhoto.setImageResource((Integer) lists.get(position).get(1));
            holder.navigationText.setText(lists.get(position).get(0) + "");
        } else {
            holder.navigationPhoto.setImageResource((Integer) lists.get(1).get(1));
            holder.navigationPhoto.setVisibility(View.INVISIBLE);
            holder.navigationText.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return lists.size() + (rowsnum - lists.size() % rowsnum);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView navigationPhoto;
        private TextView navigationText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            navigationPhoto = (ImageView) itemView.findViewById(R.id.navigation_photo);
            navigationText = (TextView) itemView.findViewById(R.id.navigation_text);
            navigationText.setTextSize(textSize);
        }
    }
}
