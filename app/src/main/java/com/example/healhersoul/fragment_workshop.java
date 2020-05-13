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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_workshop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_workshop extends Fragment {


    adapter_workshop mAdapter;
    ArrayList<String> question = new ArrayList<>();
    ArrayList<Integer> answer = new ArrayList<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_workshop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_workshop.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_workshop newInstance(String param1, String param2) {
        fragment_workshop fragment = new fragment_workshop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("WORKSHOP");
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


        RecyclerView recyclerView = getView().findViewById(R.id.recycler_workshop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new adapter_workshop(question, answer);
        recyclerView.setAdapter(mAdapter);
    }
}
