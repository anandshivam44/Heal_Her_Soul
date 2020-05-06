package com.example.healhersoul;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Iterator;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class fragment_chat_bot extends Fragment {
    Button send;
    EditText input;
    //    Firebase mRef;
    private FirebaseListAdapter<ChatMessage> adapter;
    DatabaseReference groupName;
    ArrayList<String> user = new ArrayList<>();
    ArrayList<String> message = new ArrayList<>();
    ProgrammingAdapter mAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_bot, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input = (EditText) getView().findViewById(R.id.input);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Toast.makeText(getActivity(), "User not logged in", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getActivity(), "Welcome " + FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), Toast.LENGTH_LONG).show();

        }
        recyclerView = getView().findViewById(R.id.recyclerview_message);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ProgrammingAdapter(user, message,FirebaseAuth.getInstance().getCurrentUser().getUid().toString());
        recyclerView.setAdapter(mAdapter);


        groupName = FirebaseDatabase.getInstance().getReference("Group");
        groupName.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //Log.d("MyTag", "Child added ");
                if (dataSnapshot.exists()) {
                    DisplayMessages(dataSnapshot);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        send = getView().findViewById(R.id.fab);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();

                // Write a message to the database
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//                myRef.setValue("Shivama !");

                FirebaseDatabase.getInstance()
                        .getReference("Group")
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser().getUid())
                        );

                // Clear the input
                input.setText("");
//
//                FirebaseDatabase.getInstance().getReference().push().setValue(new ChatMessage(input.getText().toString(),
//                        FirebaseAuth.getInstance().getCurrentUser().getEmail()));
//                input.setText("");
//                input.requestFocus();
            }
        });
    }

    private void displayChatMessages() {


    }

    private void DisplayMessages(DataSnapshot dataSnapshot) {
        Iterator iterator = dataSnapshot.getChildren().iterator();
        while (iterator.hasNext()) {
//            String chatDate = (String) ((DataSnapshot) iterator.next()).getValue();
            String chatMessage = (String) ((DataSnapshot) iterator.next()).getValue().toString();
            String chatTime = (String) ((DataSnapshot) iterator.next()).getValue().toString();

            String chatName = (String) ((DataSnapshot) iterator.next()).getValue().toString();
            user.add(chatName);
            message.add(chatMessage);
            mAdapter.notifyItemInserted(user.size() - 1);
            recyclerView.smoothScrollToPosition(user.size()-1);


            //Log.d("MyTag", chatMessage + "                 " + chatName + " " + chatTime + " \n");

        }
    }

}