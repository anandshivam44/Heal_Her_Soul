package com.example.healhersoul.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healhersoul.Objects.SliderItem;
import com.example.healhersoul.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter_article_in_home extends RecyclerView.Adapter<SliderAdapter_article_in_home.SliderViewHolder> {
    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapter_article_in_home(List<SliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_article_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
        if (position == sliderItems.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView text;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.article_image_view_home);
            text = itemView.findViewById(R.id.article_title_home);
        }

        void setImage(SliderItem sliderItem) {
            //if we want to get image from internet through glide or picaso library ,we can add code here:
            imageView.setImageResource(sliderItem.getImage());
            text.setText(sliderItem.getText());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}
