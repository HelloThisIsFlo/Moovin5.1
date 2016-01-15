package com.shockn745.moovin5.main;

/**
 * MVP Contract for the main Activity
 */
public interface MainContract {

    interface View {

        int DURATION_ERROR = -1;

        /**
         * Show the MotivationActivity
         * @param workoutDuration Workout duration to init processing of
         */
        void showMotivationActivity(int workoutDuration);

        /**
         * Get the workout duration
         * @return Workout duration or DURATION_ERROR
         */
        int getWorkoutDuration();

        /**
         * Check if the workout duration has been set
         * @return True if workout duration is set
         */
        boolean isWorkoutDurationSet();

        /**
         * Show an error Snackbar.
         */
        void showErrorSnackbar();

    }

    interface Presenter {

        /**
         * Start the motivation Activity if the Workout duration is set
         */
        void startMotivationIfPossible();

    }

}
