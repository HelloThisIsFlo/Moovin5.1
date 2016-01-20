package com.shockn745.moovin5.motivation;

import com.shockn745.moovin5.data.LocationModel;
import com.shockn745.moovin5.data.NetworkApiModel;

/**
 * MVP Presenter for the MotivationScreen
 */
public class MotivationPresenter implements MotivationContract.Presenter {

    MotivationContract.View mView;
    NetworkApiModel mApiModel;
    LocationModel mLocationModel;

    public MotivationPresenter(
            MotivationContract.View view,
            NetworkApiModel apiModel,
            LocationModel locationModel) {
        this.mView = view;
        this.mApiModel = apiModel;
        this.mLocationModel = locationModel;
    }

    @Override
    public void processFeelGoodTime(int workoutDuration) {


    }


}
