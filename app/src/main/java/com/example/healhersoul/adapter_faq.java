package com.example.healhersoul;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_faq extends RecyclerView.Adapter<adapter_faq.ViewHolderClass> {

    ArrayList<String> question;
    ArrayList<String> answer;
//    fragment_faq context;
    String TAG="MyTag";

    public adapter_faq(ArrayList<String> question, ArrayList<String> answer) {
        this.question = question;
        this.answer = answer;
    }

//    @Override
//    public int getItemViewType(int position) {
//        Log.d("MyTag",currentUsername+"     "+user.get(position));
//        if (user.get(position).equals(currentUsername)){
//            Log.d("MyTag", "Current USER TRUE ");
//            return VIEW_TYPE_MESSAGE_SENT;
//        }
//        else{
//            Log.d("MyTag", "Current USER False ");
//            return VIEW_TYPE_MESSAGE_RECEIVED;
//        }
//    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        view = inflater.inflate(R.layout.view_holder_faq, parent, false);
        return new ViewHolderClass(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {//execution order 4
        String content_question = question.get(position);
        String content_answer = answer.get(position);
//        holder.textView_username.setText(content_user);
        holder.textView_question.setText(content_question);
        holder.textView_answer.setText(content_answer);

    }

    @Override
    public int getItemCount() {//execution order 1
        return question.size();
    }

    protected class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView_question;
        TextView textView_answer;
        ImageButton imageButton;

        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            textView_answer = itemView.findViewById(R.id.faq_text_answer);
            textView_question = itemView.findViewById(R.id.faq_text_question);
            imageButton=itemView.findViewById(R.id.arrow_down);
            imageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "Button Clicked "+view.getId());
            if (textView_answer.getVisibility()==View.GONE){ //expand on clicking
                textView_answer.setVisibility(View.VISIBLE);
                imageButton.setImageResource(R.drawable.vector_arror_up);
            }
            else{
                textView_answer.setVisibility(View.GONE);//collapse on clicking
                imageButton.setImageResource(R.drawable.vector_arrow_down);

            }


        }
    }
//    public interface ArrowButtonClicked{
//
//        void onCityClicked(int position);
//    }


}
