package com.example.healhersoul.Fragments;

import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.Activity.MainActivity;
import com.example.healhersoul.R;
import com.example.healhersoul.Adapters.adapterForTelephoneDirectory;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class fragment_telephone_directory extends Fragment implements adapterForTelephoneDirectory.AdapterClickEvents {
    adapterForTelephoneDirectory mAdapter;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> number = new ArrayList<>();
    RecyclerView recyclerView;

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

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    String deletedName,deletedNumber;

ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
        //fro rearranging the items
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        int position =viewHolder.getAdapterPosition();
        switch (direction)
        {
            case ItemTouchHelper.LEFT:
                deletedName=name.get(position);
                deletedNumber=number.get(position);
                name.remove(position);
                number.remove(position);
                mAdapter.notifyItemRemoved(position);

                Snackbar.make(getView(),deletedName+" removed",Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                name.add(position,deletedName);
                                number.add(position,deletedNumber);
                                mAdapter.notifyItemInserted(position);
                            }
                        }).show();
                break;
        }

    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                .addBackgroundColor(ContextCompat.getColor(getContext(), R.color.monuRed))
                .addActionIcon(R.drawable.ic_delete_sweep_black_24dp)
                .create()
                .decorate();

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
};
    @Override
    public void onItemClicked(int position) {
//        Toast.makeText(getContext(), "position" + ":" + name.get(position), Toast.LENGTH_SHORT).show();
        Uri u = Uri.parse("tel:" + number.get(position));
        Intent i = new Intent(Intent.ACTION_DIAL, u);
        startActivity(i);
    }
}
