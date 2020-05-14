package com.example.healhersoul;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_workshop extends RecyclerView.Adapter<adapter_workshop.ViewHolderClass> {

    ArrayList<String> title;
    ArrayList<Integer> image;
    //    fragment_faq context;
    String TAG = "MyTag";
    boolean count = false;

    public adapter_workshop(ArrayList<String> title, ArrayList<Integer> image) {
        this.title = title;
        this.image = image;
    }


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        view = inflater.inflate(R.layout.view_holder_workshop, parent, false);
        return new ViewHolderClass(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {//execution order 4
        String content_title = title.get(position);
        Integer content_image = image.get(position);

        holder.textView_title.setText(content_title);
        holder.imageView.setImageResource(content_image);

//        holder.relativeLayout.setBackgroundResource(content_image);

    }

    @Override
    public int getItemCount() {//execution order 1
        return title.size();
    }

    protected class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_title;
        Button btn_remainder;
        RelativeLayout relativeLayout;
        ImageView imageView;

        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            textView_title = itemView.findViewById(R.id.workshop_title);
            imageView = itemView.findViewById(R.id.workshop_image_view);
//            relativeLayout= itemView.findViewById(R.id.workshop_relative_layout);

            btn_remainder = itemView.findViewById(R.id.workshop_remainder);
            btn_remainder.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (count == true) {//improper implementation
                btn_remainder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vector_notifications_none, 0);
                count = !count;
            } else {
                btn_remainder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vector_notifications_active, 0);
                count = !count;
            }


        }
    }
//    public interface ArrowButtonClicked{
//
//        void onCityClicked(int position);
//    }


}
