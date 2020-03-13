package com.duxetech.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * * Created by Karthik Swamy - http://duxetech.com on 12/02/19
 **/
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Item> items;


    public Adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.items,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tv_likes.setText(items.get(i).getLikes());
        viewHolder.tv_creator.setText(items.get(i).getCreator());
        //Picasso.with(context).load(url)
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv_creator, tv_likes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv_creator=itemView.findViewById(R.id.tv_creator);
            tv_likes=itemView.findViewById(R.id.tv_likes);
        }
    }
}
