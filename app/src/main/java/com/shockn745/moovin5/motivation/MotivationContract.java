package com.shockn745.moovin5.motivation;


import java.util.List;

/**
 * MVP Contract for the Motivation screen
 */
public interface MotivationContract {

    interface View {

        /**
         * Show/hide the loading indicator
         * @param show True to show / False to hide
         */
        void showLoading(boolean show);

        void showFeelGoodTime(int time);

        void showWeather(String weatherDescription);

        void showTransitTime(int transitTime);

        void showRoute();

        void showCalories();

        ///////////
        // ERROR //
        ///////////

        void showLocationError();
        void showTransitDurationError();
        void showWeatherError();
    }

    interface Presenter {

        /**
         * Start the background process :
         *      - Get the location
         *      - Get the transit duration
         */
        void processFeelGoodTime(int workoutDuration);



    }
}
