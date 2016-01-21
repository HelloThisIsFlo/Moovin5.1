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

    private Context mContext;

    public AndroidModelImpl(Context context) {
        this.mContext = context;
    }

    @Nullable
    @Override
    public LatLng getGymLocationFromPreferences() {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);



        return null;
    }
}
