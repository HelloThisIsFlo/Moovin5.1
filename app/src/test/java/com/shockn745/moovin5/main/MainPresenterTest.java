package com.shockn745.moovin5.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for MainPresenter
 */
public class MainPresenterTest {

    private static final int TEST_WORKOUT_DURATION = 30;

    @Mock
    private MainContract.View mView;

    private MainPresenter mMainPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mMainPresenter = new MainPresenter(mView);
    }

    @Test
    public void testStartMotivationIfPossible_success() throws Exception {
        // Setup success mock response
        when(mView.isWorkoutDurationSet()).thenReturn(true);
        when(mView.getWorkoutDuration()).thenReturn(TEST_WORKOUT_DURATION);

        // Call method
        mMainPresenter.startMotivationIfPossible();

        // Test
        verify(mView).isWorkoutDurationSet();
        verify(mView).getWorkoutDuration();
        verify(mView).showMotivationActivity(eq(TEST_WORKOUT_DURATION));
    }

    @Test
    public void testStartMotivationIfPossible_fail() throws Exception {
        // Setup success mock response
        when(mView.isWorkoutDurationSet()).thenReturn(false);
        when(mView.getWorkoutDuration()).thenReturn(MainContract.View.DURATION_ERROR);

        // Call method
        mMainPresenter.startMotivationIfPossible();

        // Test
        verify(mView).isWorkoutDurationSet();
        verify(mView).showErrorSnackbar();
    }
}