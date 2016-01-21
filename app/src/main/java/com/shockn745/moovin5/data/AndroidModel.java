package com.shockn745.moovin5.data;

import android.support.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Main entry point for Accessing android related functionalities
 *
 *
 *
 * TODO README :
 * Idea : Abstract the Android environement for everything not realted to the View in this model.
 *    It allows to not have any android related dependencies in the presenter, but still have
 *    access to cool android features such as SharedPreferences and . . . . other stuff I guess ^_^
 */
public interface AndroidModel {


    @Nullable LatLng getGymLocationFromPreferences();
}
