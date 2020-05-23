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
import com.example.healhersoul.Adapters.adapter_faq;

import java.util.ArrayList;

public class fragment_faq extends Fragment {

    adapter_faq mAdapter;
    ArrayList<String> question = new ArrayList<>();
    ArrayList<String> answer = new ArrayList<>();

    public fragment_faq() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("FAQ");
        return inflater.inflate(R.layout.fragment_faq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        question.add("Question 0");
        question.add("Question 1");
        question.add("Question 2");
        question.add("Question 3");
        question.add("Question 4");
        question.add("Question 5");
        question.add("Question 6");
        question.add("Question 7");
        question.add("Question 8");
        question.add("Question 9");
        question.add("Question 10");
        question.add("Question 11");
        question.add("Question 12");
        question.add("Question 13");
        question.add("Question 14");
        question.add("Question 15");
        question.add("Question 16");

        answer.add("Answer 0 " +
                "Now, more than ever before, we have tools that help us to harness the power of data. To collect, process and analyze data faster than ever before. To understand the world – and to change it for the better.");
        answer.add("Answer 1");
        answer.add("Answer 2");
        answer.add("Answer 3  This year’s World Health Statistics report makes clear that the global efforts in recent decades have been paying off. Looking at the most up-to-date data we have on some of these vital SDG indicators, it reveals health trends across Member States, regions and the entire world. ");
        answer.add("Answer 4 This year’s World Health Statistics report makes clear that the global efforts in recent decades have been paying off. Looking at the most up-to-date data we have on some of these vital SDG indicators, it reveals health trends across Member States, regions and the entire world. \n" +
                "\n" +
                "The data shows that we are continuing to make enormously encouraging progress in many ways – but also that we lack progress in other ways. Inequality persists, with some regions still falling behind. We must continue to work together to remain focused on our goals. \n" +
                "\n" +
                "Data blindspots – lack of available data, infrequency of data collection – remain an urgent challenge but also a great opportunity. Because wherever we can measure, we can make progress. \n" +
                "\n" +
                "This report gives us further galvanising evidence, not only of what has been achieved but what can be.");
        answer.add("Answer 5");
        answer.add("Answer 6");
        answer.add("Answer 7");
        answer.add("Answer 8");
        answer.add("Answer 9");
        answer.add("Answer 10");
        answer.add("Answer 11");
        answer.add("Answer 12");
        answer.add("Answer 13");
        answer.add("Answer 14");
        answer.add("Answer 15");
        answer.add("Answer 16");

        RecyclerView recyclerView = getView().findViewById(R.id.recycler_faq);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new adapter_faq(question, answer,recyclerView);
        recyclerView.setAdapter(mAdapter);

    }
}
