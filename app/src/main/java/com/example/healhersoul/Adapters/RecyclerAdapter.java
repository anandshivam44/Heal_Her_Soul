package com.example.healhersoul.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.healhersoul.Objects.Data;
import com.example.healhersoul.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{

    private Context context;
    private List<Data> data;
    public RecyclerAdapter(Context context, List<Data> data)
    {
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Data currentData=data.get(position);
        Glide.with(context).load(currentData.getImage_url()).into(holder.image); //Glide library for loading image
        holder.title.setText(currentData.getNews_title());
        holder.description.setText(currentData.getNews_description());
        holder.content.setText(currentData.getContent());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,description,content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.newsImg);
            title=itemView.findViewById(R.id.txt_title);
            description=itemView.findViewById(R.id.txt_description);
            content=itemView.findViewById(R.id.txt_content);
        }
    }
}
