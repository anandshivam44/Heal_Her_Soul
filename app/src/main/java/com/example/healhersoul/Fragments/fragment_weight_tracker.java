package com.example.healhersoul.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.healhersoul.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class fragment_weight_tracker extends Fragment {
    GraphView graphView;
    EditText X;
    EditText Y;
    Button add;
    int x;
    LineGraphSeries<DataPoint> series;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight_tracker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        graphView = getView().findViewById(R.id.graph_view);
        Y = getView().findViewById(R.id.point_y);
        add = getView().findViewById(R.id.add_weight);
        x = -1;
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMinY(0);
        graphView.getViewport().setMaxY(100);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(8);
        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScalableY(true);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x == -1) {
                    x = x + 1;
                    series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, Integer.valueOf(Y.getText().toString()))});
                    series.setDrawDataPoints(true);
                    series.setDataPointsRadius(10);
                    graphView.addSeries(series);
                } else {
                    x = x + 1;
                    int y = Integer.valueOf(Y.getText().toString());
                    series.appendData(new DataPoint(x, y), false, 40);
                    if (x >= 8) {
                        graphView.getViewport().setMinX(1);
                        graphView.getViewport().setMaxX(x + 1);
                        series.appendData(new DataPoint(x, y), true, 40);
                    } else if (x < 8) {
                        series.appendData(new DataPoint(x, y), false, 40);
                    }
                }
                Y.setText("");
            }
        });


    }
}
