package com.example.android.quakereport;

/**
 * Created by anega on 9/19/17.
 */

public class Earthquake {
    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;

    public Earthquake(String magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
