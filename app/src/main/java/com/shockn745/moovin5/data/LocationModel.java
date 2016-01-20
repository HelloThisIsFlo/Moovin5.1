package com.shockn745.moovin5.data;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

/**
 * MVP Model for the Location
 */
public interface LocationModel {

    interface GetLocationCallback {
        void onLocationReady(LatLng location);
        void onLocationError();
    }

    void getLocation(@NonNull GetLocationCallback callback);


}
