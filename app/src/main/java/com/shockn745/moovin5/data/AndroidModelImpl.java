package com.shockn745.moovin5.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Implementation of the Android model
 */
public class AndroidModelImpl implements AndroidModel {

    private final SharedPreferences mSharedPreferences;

    public AndroidModelImpl(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

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
