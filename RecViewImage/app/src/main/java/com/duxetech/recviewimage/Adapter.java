package com.duxetech.recviewimage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String names[];
    int images[];

    public Adapter(Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.items,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(names[i]);
        viewHolder.iv.setImageResource(images[i]);
        //Handling click events on the views
        viewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,detail.class);
                intent.putExtra("image",images[i]);
                intent.putExtra("text",names[i]);
                context.startActivity(intent);
                }
        });

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            ll=itemView.findViewById(R.id.ll);
        }
    }
}
