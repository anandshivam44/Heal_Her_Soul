package com.example.healhersoul.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.R;
import com.example.healhersoul.Adapters.adapter_workshop;

import java.util.ArrayList;



public class fragment_workshop extends Fragment {


    adapter_workshop mAdapter;
    ArrayList<String> question = new ArrayList<>();
    ArrayList<Integer> answer = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Workshop");
        return inflater.inflate(R.layout.fragment_workshop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        question.add("workshop on nutrition");
        question.add(" workshop on daily routine");
        question.add("workshop on child safety");
        question.add("workshop on medicine");
        question.add("workshop on routine checkup");
        question.add("workshop on child growth");
        question.add("workshop on diet");
        question.add("workshop on parenting");
        question.add("workshop on nature mother");
        question.add("workshop on birthrate");

        answer.add(R.drawable.birthrate);
        answer.add(R.drawable.pregnant);
        answer.add(R.drawable.pregnantfirst);
        answer.add(R.drawable.parents123);
        answer.add(R.drawable.pregnanter);
        answer.add(R.drawable.fig_1);
        answer.add(R.drawable.fig_2);
        answer.add(R.drawable.fig_3);
        answer.add(R.drawable.fig_4);
        answer.add(R.drawable.fig_1);


        RecyclerView recyclerView = getView().findViewById(R.id.recycler_workshop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new adapter_workshop(question, answer);
        recyclerView.setAdapter(mAdapter);
    }
}
