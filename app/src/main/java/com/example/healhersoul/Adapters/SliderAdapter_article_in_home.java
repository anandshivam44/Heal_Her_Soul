package com.example.healhersoul.Adapters;

import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.healhersoul.Fragments.fragment_articles;
import com.example.healhersoul.Fragments.fragment_home;
import com.example.healhersoul.Objects.DetailsTransition;
import com.example.healhersoul.Objects.SliderItem;
import com.example.healhersoul.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter_article_in_home extends RecyclerView.Adapter<SliderAdapter_article_in_home.SliderViewHolder> {
    private List<SliderItem> sliderItems;
    private ViewPager2 viewPager2;
    ViewHolderItemClicked_Interface viewHolderItemClicked_interface;
    Fragment fragment;


    public SliderAdapter_article_in_home(List<SliderItem> sliderItems, ViewPager2 viewPager2, ViewHolderItemClicked_Interface viewHolderItemClicked_interface, Fragment fragment
    ) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
        this.viewHolderItemClicked_interface = viewHolderItemClicked_interface;
        this.fragment=fragment;
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

    class SliderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView text;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.article_image_view_home);
            text = itemView.findViewById(R.id.article_title_home);
            itemView.setOnClickListener((View.OnClickListener) this);
        }


        void setImage(SliderItem sliderItem) {
            //if we want to get image from internet through glide or picaso library ,we can add code here:
            imageView.setImageResource(sliderItem.getImage());
            text.setText(sliderItem.getText());
        }

        @Override
        public void onClick(View view) {
            viewHolderItemClicked_interface.viewHolderClicked(getAdapterPosition());

//            fragment_articles visitingFragment = new fragment_articles();
//            visitingFragment.setSharedElementEnterTransition(new DetailsTransition());
//            visitingFragment.setEnterTransition(new android.transition.Fade());
//            visitingFragment.setExitTransition(new Fade());
//            visitingFragment.setSharedElementReturnTransition(new DetailsTransition());
//
//
//
//            fragment.getActivity()
//                    .
//                    getSupportFragmentManager()
//                    .beginTransaction()
//                    .setReorderingAllowed(true) // Optimize for shared element transition
//                    .addSharedElement(imageView, "article_image")
//                    .replace(R.id.fragment_container, new fragment_articles())
//                    .addToBackStack(null)
//                    .commit();



        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    public interface ViewHolderItemClicked_Interface {

        void viewHolderClicked(int position);
    }

}
