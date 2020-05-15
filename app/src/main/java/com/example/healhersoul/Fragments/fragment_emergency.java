package com.example.healhersoul.Fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.healhersoul.R;


public class fragment_emergency extends Fragment {
    Button emergencyButtonn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_emergency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emergencyButtonn = getView().findViewById(R.id.emergency_button);
        emergencyButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                String messageToSend = "Automated message from Shivam";//tested and working
                String number = "+917645088895";
                SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);

//                Intent myIntent = new Intent("android.intent.action.MAIN");
//                myIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
//                myIntent.putExtra("abc", PhoneNumberUtils.stripSeparators("+917645088895") + "@s.whatsapp.net");
//                startActivity(myIntent);

//                SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
//                try {
//                    String text = "CHECK";// Replace with your message.
//
//                    String toNumber = "918709885367"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
//                    //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
//
//
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
//                    startActivity(intent);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }



            }
        });
    }
}
