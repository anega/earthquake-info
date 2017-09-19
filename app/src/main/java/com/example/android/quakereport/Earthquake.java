package com.example.android.quakereport;

import java.sql.Date;

/**
 * Created by anega on 9/19/17.
 */

public class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private Date mDate;

    public Earthquake(double magnitude, String place, Date date) {
        mMagnitude = magnitude;
        mPlace = place;
        mDate = date;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public Date getDate() {
        return mDate;
    }
}
