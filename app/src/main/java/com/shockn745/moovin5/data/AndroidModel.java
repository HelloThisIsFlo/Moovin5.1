package com.shockn745.moovin5.data;

import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Main entry point for Accessing android related functionalities
 */
public interface AndroidModel {

    /////////////////
    // PREFERENCES //
    /////////////////
    void setGymLocationInPreferences();
    boolean isGymLocationSetInPreferences();
    @Nullable LatLng getGymLocationFromPreferences();
}
