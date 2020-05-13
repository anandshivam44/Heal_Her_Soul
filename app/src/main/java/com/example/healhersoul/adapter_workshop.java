package com.example.healhersoul;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_workshop extends RecyclerView.Adapter<adapter_workshop.ViewHolderClass> {

    ArrayList<String> question;
    ArrayList<Integer> answer;
    //    fragment_faq context;
    String TAG="MyTag";
    boolean count=true;

    public adapter_workshop(ArrayList<String> question, ArrayList<Integer> answer) {
        this.question = question;
        this.answer = answer;
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
        String content_question = question.get(position);
        Integer content_answer = answer.get(position);
//        holder.textView_username.setText(content_user);
        holder.textView_title.setText(content_question);
        holder.imageView_workshop.setImageResource(content_answer);

    }

    @Override
    public int getItemCount() {//execution order 1
        return question.size();
    }

    protected class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView_title;
        ImageView imageView_workshop;
        Button btn_remainder;

        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            textView_title = itemView.findViewById(R.id.workshop_title);
            imageView_workshop = itemView.findViewById(R.id.workshop_image);
            btn_remainder=itemView.findViewById(R.id.workshop_remainder);
            btn_remainder.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (count==true){
                btn_remainder.setBackgroundResource(R.drawable.ic_reminder_done_black_24dp);
                count=!count;
            }
            else
                {
                btn_remainder.setBackgroundResource(R.drawable.ic_add_reminder_black_24dp);
                count=!count;
                }


        }
    }
//    public interface ArrowButtonClicked{
//
//        void onCityClicked(int position);
//    }


}
