package com.example.healhersoul.Fragments;

import android.content.Intent;
import android.net.Uri;
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
import com.example.healhersoul.Adapters.adapterForTelephoneDirectory;

import java.util.ArrayList;

public class fragment_telephone_directory extends Fragment implements adapterForTelephoneDirectory.AdapterClickEvents {
    adapterForTelephoneDirectory mAdapter;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> number = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Call from App");
        return inflater.inflate(R.layout.fragment_telephone_directory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name.add("Mom");
        number.add("8864038169");
        name.add("Dad");
        number.add("8603803436");
        name.add("Person A");
        number.add("7645088895");
        name.add("Person B");
        number.add("7979010458");
        name.add("Doctor");
        number.add("7979716172");
        name.add("Ambulance");
        number.add("102");

        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view_telephone_directory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new adapterForTelephoneDirectory(this, name, number);
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onItemClicked(int position) {
//        Toast.makeText(getContext(), "position" + ":" + name.get(position), Toast.LENGTH_SHORT).show();
        Uri u = Uri.parse("tel:" + number.get(position));
        Intent i = new Intent(Intent.ACTION_DIAL, u);
        startActivity(i);
    }
}
