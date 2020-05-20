package com.example.healhersoul.Adapters;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healhersoul.AlertReceiver;
import com.example.healhersoul.R;

import java.util.ArrayList;
import java.util.Calendar;

public class adapter_workshop extends RecyclerView.Adapter<adapter_workshop.ViewHolderClass> {

    ArrayList<String> title;
    ArrayList<Integer> image;
    //    fragment_faq context;
    String TAG = "MyTag";
    boolean count = false;

    public adapter_workshop(ArrayList<String> title, ArrayList<Integer> image) {
        this.title = title;
        this.image = image;
    }


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        view = inflater.inflate(R.layout.view_holder_workshop, parent, false);
        return new ViewHolderClass(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {//execution order 4
        String content_title = title.get(position);
        Integer content_image = image.get(position);

        holder.textView_title.setText(content_title);
        holder.imageView.setImageResource(content_image);

//        holder.relativeLayout.setBackgroundResource(content_image);

    }

    @Override
    public int getItemCount() {//execution order 1
        return title.size();
    }

    protected class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView_title;
        Button btn_remainder;
        RelativeLayout relativeLayout;
        ImageView imageView;

        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            textView_title = itemView.findViewById(R.id.workshop_title);
            imageView = itemView.findViewById(R.id.workshop_image_view);
//            relativeLayout= itemView.findViewById(R.id.workshop_relative_layout);

            btn_remainder = itemView.findViewById(R.id.workshop_remainder);
            btn_remainder.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if (count == true) {//improper implementation
                btn_remainder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vector_notifications_none, 0);
                count = !count;
                stopNotification();

            } else {
                btn_remainder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.vector_notifications_active, 0);
                count = !count;
                Calendar calendar=Calendar.getInstance();
                //TODO: instead of manual input of DATE and TIME we need to fecth the details from server and pass those values here:
                //TODO: here we need to pass DATE and TIME as parameter,in future for different workshops.
                calendar.set(Calendar.HOUR_OF_DAY,15); //setting the hours in 24 hour format
                calendar.set(Calendar.MINUTE,45);       //setting the minutes
                calendar.set(Calendar.SECOND,0);//setting the second
//        calendar.set(Calendar.DAY_OF_MONTH,22);
//        calendar.set(Calendar.MONTH,5);
//        calendar.set(Calendar.YEAR,2020);
                sendNotification(calendar);

            }
        }

        private  void sendNotification(Calendar c)
        {
            AlarmManager alarmManager=(AlarmManager) itemView.getContext().getSystemService(Context.ALARM_SERVICE);
            Intent intent=new Intent(itemView.getContext(), AlertReceiver.class);
            PendingIntent pendingIntent= PendingIntent.getBroadcast(itemView.getContext(),1,intent,0);/**request code for each pending intent should be different.*/
            if(c.before(Calendar.getInstance()))//checking the selected time with current time ,if it is before or not
            {
                c.add(Calendar.DATE,1);//alarm will start on next day
            }

            alarmManager.setExact(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
            Toast.makeText(itemView.getContext(),"notificatio on",Toast.LENGTH_SHORT).show();
        }

        private void stopNotification()
        {
            AlarmManager alarmManager=(AlarmManager) itemView.getContext().getSystemService(Context.ALARM_SERVICE);
            Intent intent=new Intent(itemView.getContext(), AlertReceiver.class);
            PendingIntent pendingIntent= PendingIntent.getBroadcast(itemView.getContext(),1,intent,0);/**request code for each pending intent should be different.*/

            alarmManager.cancel(pendingIntent);
            Toast.makeText(itemView.getContext(),"notificatio off",Toast.LENGTH_SHORT).show();
        }
    }
//    public interface ArrowButtonClicked{
//
//        void onCityClicked(int position);
//    }


}
