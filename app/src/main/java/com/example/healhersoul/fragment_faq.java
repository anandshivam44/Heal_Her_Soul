package com.example.healhersoul;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        answer.add("Answer 0");
        answer.add("Answer 1");
        answer.add("Answer 2");
        answer.add("Answer 3");
        answer.add("Answer 4");
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
        mAdapter = new adapter_faq(question, answer);
        recyclerView.setAdapter(mAdapter);
    }
}
