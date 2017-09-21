package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by anega on 9/19/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.tv_layout_magnitude);
        magnitude.setText(earthquake.getMagnitude());

        String locationStr = earthquake.getPlace();
        int splitStrPosition = locationStr.indexOf(" of ");
        String locationOffsetStr;
        String locationPlaceStr;

        if (splitStrPosition == -1) {
            locationOffsetStr = "Near the";
            locationPlaceStr = locationStr;
        } else  {
            locationOffsetStr = locationStr.substring(0, splitStrPosition);
            locationPlaceStr = locationStr.substring(splitStrPosition + 4);
        }

        TextView locationOffset = (TextView) listItemView.findViewById(R.id.tv_layout_location_offset);
        locationOffset.setText(locationOffsetStr);

        TextView location = (TextView) listItemView.findViewById(R.id.tv_layout_location);
        location.setText(locationPlaceStr);

        Date earthquakeDate = new Date(earthquake.getTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.tv_layout_date);
        String formattedDate = formatDate(earthquakeDate);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.tv_layout_time);
        String formattedTime = formatTime(earthquakeDate);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObj) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObj);
    }

    private String formatTime(Date dateObj) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObj);
    }
}
