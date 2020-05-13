package com.example.healhersoul;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SilderViewHolder>{

    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;
    String body;

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2,String body) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
        this.body=body;
    }

    @NonNull
    @Override
    public SilderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SilderViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slide_item_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SilderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
        holder.articleBody.setText(body);
//        if (position==sliderItems.size()-2){
//            viewPager2.post(runnable);
//        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SilderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;
        private TextView articleBody;

        SilderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageSlide);
            articleBody=itemView.findViewById(R.id.article_body);
        }



        void setImage(SliderItem sliderItem){
            imageView.setImageResource(sliderItem.getImage());
        }
    }

//    private Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            sliderItems.addAll(sliderItems);
//            notifyDataSetChanged();
//        }
//    };
}
