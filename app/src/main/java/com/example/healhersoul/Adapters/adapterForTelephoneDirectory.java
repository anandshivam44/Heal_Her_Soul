package com.example.healhersoul.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.healhersoul.R;

public class adapterForTelephoneDirectory extends RecyclerView.Adapter<adapterForTelephoneDirectory.workingWithViewHolderHere> {

    ArrayList<String> name;
    ArrayList<String> phone;
    AdapterClickEvents adapterClickEvents;


    public adapterForTelephoneDirectory(AdapterClickEvents adapterClickEvents,ArrayList<String> name, ArrayList<String> phone) {
        this.name = name;
        this.phone = phone;
        this.adapterClickEvents=adapterClickEvents;
    }


    @NonNull
    @Override
    public workingWithViewHolderHere onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        view = inflater.inflate(R.layout.view_holder_telephone, parent, false);

        return new workingWithViewHolderHere(view);
    }

    @Override
    public void onBindViewHolder(@NonNull workingWithViewHolderHere holder, int position) {//execution order 4
        String content_name = name.get(position);
        String content_phoneNo = phone.get(position);
        holder.textView_name.setText(content_name);
        holder.textView_phone.setText(content_phoneNo);

    }

    @Override
    public int getItemCount() {//execution order 1
        return name.size();
    }

    protected class workingWithViewHolderHere extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_name;
        TextView textView_phone;

        public workingWithViewHolderHere(@NonNull View itemView) {//execution order 3
            super(itemView);
            textView_phone = itemView.findViewById(R.id.tv_phone_number);
            textView_name = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position;
            position = getAdapterPosition();
//            Toast.makeText(v.getContext(), "position"+""+name.get(position), Toast.LENGTH_SHORT).show();
            adapterClickEvents.onItemClicked(position);

        }

    }
    public interface AdapterClickEvents{

        void onItemClicked(int position);
    }


}
