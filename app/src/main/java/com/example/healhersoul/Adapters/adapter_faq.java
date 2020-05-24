package com.example.healhersoul.Adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healhersoul.R;

import java.util.ArrayList;

public class adapter_faq extends RecyclerView.Adapter<adapter_faq.ViewHolderClass> {

    ArrayList<String> question;
    ArrayList<String> answer;
    int toBeCollapsed = 0;
    //    fragment_faq context;
    String TAG = "MyTag";
    RecyclerView recyclerView;
    Context mContext;

    public adapter_faq(ArrayList<String> question, ArrayList<String> answer, RecyclerView recyclerView,Context mContext) {
        this.question = question;
        this.answer = answer;
        this.recyclerView = recyclerView;
        this.mContext=mContext;
    }


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

//        holder.textView_question.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation_1));

        // lets create the animation for the whole card
        // first lets create a reference to it
        // you ca use the previous same animation like the following

        // but i want to use a different one so lets create it ..
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation_1));
        holder.viewHolder.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

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

    protected class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_question;
        TextView textView_answer;
        ImageButton imageButton;
        TextView toBeCollapsedTextView;
        View viewHolder;


        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            viewHolder=itemView;
            textView_answer = itemView.findViewById(R.id.faq_text_answer);
            textView_question = itemView.findViewById(R.id.faq_text_question);
            imageButton = itemView.findViewById(R.id.arrow_down);
            itemView.setOnClickListener(this);
            imageButton.setOnClickListener(this);
            toBeCollapsedTextView = itemView.findViewById(R.id.faq_text_answer);
        }

        @Override
        public void onClick(View view) {
//            recyclerView.smoothScrollToPosition(getAdapterPosition());
            Log.d(TAG, "Button Clicked " + view.getId());
            if (textView_answer.getVisibility() == View.GONE) { //expand on clicking
//                if (getAdapterPosition() != toBeCollapsed) {
//                    notifyItemChanged(toBeCollapsed);
//                }
//                toBeCollapsed = getAdapterPosition();
                textView_answer.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation_2));
                textView_answer.setVisibility(View.VISIBLE);
//                textView_answer.animate()
//                        .translationY(view.getHeight())
//                        .alpha(1.0f)
//                        .setDuration(300)
//                        .setListener(new AnimatorListenerAdapter() {
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//                                super.onAnimationEnd(animation);
//                                textView_answer.setVisibility(View.VISIBLE);
//                            }
//                        });
                imageButton.setImageResource(R.drawable.vector_arror_up);
            } else {
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
