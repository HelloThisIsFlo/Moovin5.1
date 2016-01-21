package com.shockn745.moovin5.data;

import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Shock on 1/21/2016.
 */
public class MockAndroidModelImpl implements AndroidModel {


    @Override
    public void setGymLocationInPreferences() {

    }

    @Override
    public boolean isGymLocationSetInPreferences() {
        return false;
    }

    @Nullable
    @Override
    public LatLng getGymLocationFromPreferences() {
        return null;
    }
}
