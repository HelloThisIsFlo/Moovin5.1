package com.shockn745.moovin5.data;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

/**
 * Main entry point for accessing the MVP Model
 */
public interface NetworkApiModel {

    ///////////////
    // CALLBACKS //
    ///////////////

    interface GetTransitTimeCallback {
        void onTransitTimeReady(int transitTime);
        void onTransitTimeError();
    }

    interface GetWeatherCallback {
        void onWeatherReady(String weatherDescription);
        void onWeatherError();
    }





    /////////////
    // METHODS //
    /////////////

    /**
     * Get the transit time from the Google Maps API
     * By foot for now
     */
    void getTransitTime(
            @NonNull LatLng originPosition,
            @NonNull LatLng destPosition,
            @NonNull GetTransitTimeCallback callback
    );

    void getWeatherForLocation(
            @NonNull LatLng location,
            @NonNull GetWeatherCallback callback
    );

    // todo add other network related operations


}
