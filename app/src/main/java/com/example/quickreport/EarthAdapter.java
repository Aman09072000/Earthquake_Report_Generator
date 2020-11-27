package com.example.quickreport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.util.List;

public class EarthAdapter<adapter> extends ArrayAdapter<earthquake> {

    public EarthAdapter(Context context,  List<earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listIntemView = convertView;
        if(listIntemView == null){
            listIntemView = LayoutInflater.from(getContext()).inflate(R.layout.mulayout,parent,false);
        }

        earthquake current = getItem(position);
        TextView magnitude = (TextView)listIntemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(current.getMagnitude());
        magnitude.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        int magnitudeColor = getMagnitudeColor(current.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        TextView smallcity = (TextView)listIntemView.findViewById(R.id.smallcity);
        smallcity.setText(current.getSmallcity());

        TextView bigcity = (TextView)listIntemView.findViewById(R.id.bigcity);
        bigcity.setText(current.getBigcity());

        TextView date = (TextView)listIntemView.findViewById(R.id.date);
        date.setText(current.getDate());

        return listIntemView;


    }


    private int getMagnitudeColor(double magnitude) {

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }



    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }




}
