package com.shockn745.moovin5.main;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.shockn745.moovin5.R;
import com.shockn745.moovin5.motivation.MotivationActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MVP View for the Main screen
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Bind(R.id.main_edit_text)
    EditText mEditText;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Set Toolbar as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new MainPresenter(this);

    }

    @OnClick(R.id.main_button)
    void onMotivationClicked() {
        mPresenter.startMotivationIfPossible();
    }

    @Override
    public void showMotivationActivity(int workoutDuration) {
        // todo implement
        Intent startMotivation = new Intent(this, MotivationActivity.class);
        startActivity(startMotivation);
    }

    @Override
    public int getWorkoutDuration() {
        return parseWorkoutDuration();
    }

    @Override
    public boolean isWorkoutDurationSet() {
        return getWorkoutDuration() != DURATION_ERROR;
    }

    @Override
    public void showErrorSnackbar() {
        Snackbar.make(
                mEditText,
                getString(R.string.main_error_snackbar),
                Snackbar.LENGTH_SHORT
        ).show();
    }

    /**
     * Try to parse the workout duration
     * @return Workout duration or DURATION_ERROR
     */
    private int parseWorkoutDuration() {
        // Get the text
        String text = mEditText.getText().toString();

        // Try to parse the workout duration
        int workoutDuration;
        try {
            workoutDuration = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            workoutDuration = DURATION_ERROR;
        }
        return workoutDuration;
    }
}
