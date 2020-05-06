package com.example.healhersoul;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgrammingAdapter {
    //extends RecyclerView.Adapter<ProgrammingAdapter.ProgramingViewHolder> {

//     ArrayList<String> data;
//     CityAdapterEvents cityAdapterEvents;
//    public ProgrammingAdapter(CityAdapterEvents cityAdapterEvents , ArrayList<String> data) {
//        this.data=data;
//        this.cityAdapterEvents=cityAdapterEvents;
//    }
//
//    @NonNull
//    @Override
//    public ProgramingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2
//        Log.d("MyTag", "onCreateViewHolder: ");
//        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
//        View view=inflater.inflate(R.layout.list_item_layout,parent,false);
//
//        return new ProgramingViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProgramingViewHolder holder, int position) {//execution order 4
//        Log.d("MyTag", "onBindViewHolder: ");
//        String title=data.get(position);
//        holder.textView.setText(title);
//
//    }
//
//    @Override
//    public int getItemCount() {//execution order 1
//        Log.d("MyTag", "getItemCount: ");
//
//        return data.size();
//    }
//
//    protected class ProgramingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener {
//        ImageView imageView;
//        TextView textView;
//        public ProgramingViewHolder(@NonNull View itemView) {//execution order 3
//            super(itemView);
//            Log.d("MyTag", "ProgramingViewHolder: ");
//            imageView=itemView.findViewById(R.id.imageView);
//            textView=itemView.findViewById(R.id.textView);
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            int position;
//            position=getAdapterPosition();
//            //Toast.makeText(v.getContext(), "position"+""+data.get(position), Toast.LENGTH_SHORT).show();
//            cityAdapterEvents.onCityClicked(position);
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            int position=getAdapterPosition();
//            Toast.makeText(v.getContext(), "To delete: "+data.get(position), Toast.LENGTH_LONG).show();
//            data.remove(position);
//            notifyItemRemoved(position);
//            return true;
//        }
//    }
//    public interface CityAdapterEvents{
//
//        void onCityClicked(int position);
//    }

}
