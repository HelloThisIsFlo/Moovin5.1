package com.shockn745.moovin5.motivation;

import android.nfc.NfcEvent;

import com.google.android.gms.maps.model.LatLng;
import com.shockn745.moovin5.data.LocationModel;
import com.shockn745.moovin5.data.NetworkApiModel;
import com.shockn745.moovin5.main.MainContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test for the MotivationPresenter
 */
public class MotivationPresenterTest {

    private final static LatLng WORKOUT_LOCATION = new LatLng(52.489872, 13.437069); // Freeletics

    private static final int SUCCESS_WORKOUT_DURATION = 10;
    private static final LatLng SUCCESS_LOCATION = new LatLng(52.518778, 13.405282); //AlexPlatz

    @Mock
    private MotivationContract.View mView;
    @Mock
    private NetworkApiModel mNetworkApiModel;
    @Mock
    private LocationModel mLocationModel;

    @Captor
    private ArgumentCaptor<LocationModel.GetLocationCallback> mGetLocationCallbackCaptor;
    @Captor
    private ArgumentCaptor<NetworkApiModel.GetTransitTimeCallback> mGetTransitTimeCallbackCaptor;

    private MotivationPresenter mMotivationPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mMotivationPresenter = new MotivationPresenter(mView, mNetworkApiModel, mLocationModel);
    }

    @Test
    public void processFeelgood_success() throws Exception {
        // Call method
        mMotivationPresenter.processFeelGoodTime(SUCCESS_WORKOUT_DURATION);

        // Check call & simulate location
        verify(mLocationModel).getLocation(mGetLocationCallbackCaptor.capture());
        mGetLocationCallbackCaptor.getValue().onLocationReady(SUCCESS_LOCATION);

        // Check call & simulate transit time
        verify(mNetworkApiModel).getTransitTime(
                eq(SUCCESS_LOCATION),
                any(LatLng.class),
                mGetTransitTimeCallbackCaptor.capture()
        );
        mGetTransitTimeCallbackCaptor.getValue().onTransitTimeReady(anyInt());

        /*
        At this point all the information required to calculate the FeelGood time are available
         */

        // Check that the FeelGood time is displayed
        verify(mView).showFeelGoodTime(anyInt());

    }

}