package com.example.android.quakereport;

import java.sql.Date;

/**
 * Created by anega on 9/19/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mPlace;
    private String mDate;

    public Earthquake(String magnitude, String place, String date) {
        mMagnitude = magnitude;
        mPlace = place;
        mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getDate() {
        return mDate;
    }
}
