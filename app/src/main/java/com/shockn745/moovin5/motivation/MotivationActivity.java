package com.shockn745.moovin5.motivation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.shockn745.moovin5.R;

import butterknife.ButterKnife;

public class MotivationActivity extends AppCompatActivity {

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
}
