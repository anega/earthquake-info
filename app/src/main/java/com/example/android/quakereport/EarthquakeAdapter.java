package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        TextView place = (TextView) listItemView.findViewById(R.id.tv_layout_place);
        place.setText(earthquake.getPlace());

        TextView date = (TextView) listItemView.findViewById(R.id.tv_layout_date);
        date.setText(earthquake.getDate());

        return listItemView;
    }
}
