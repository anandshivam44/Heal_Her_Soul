package com.example.healhersoul.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_profile extends Fragment {

    public Fragment_profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Profile");
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
