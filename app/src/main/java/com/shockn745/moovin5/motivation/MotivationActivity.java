package com.shockn745.moovin5.motivation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.shockn745.moovin5.R;

import butterknife.ButterKnife;

/**
 * MVP View for the Motivation screen
 */
public class MotivationActivity extends AppCompatActivity implements MotivationContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        ButterKnife.bind(this);

        // Set Toolbar as ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.motivation_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading(boolean show) {


    }

    @Override
    public void showFeelGoodTime(int time) {

    }

    @Override
    public void showWeather(String weatherDescription) {

    }

    @Override
    public void showTransitTime(int transitTime) {

    }

    @Override
    public void showRoute() {

    }

    @Override
    public void showCalories() {

    }

    @Override
    public void showLocationError() {

    }

    @Override
    public void showTransitDurationError() {

    }

    @Override
    public void showWeatherError() {

    }
}
