package com.shockn745.moovin5.main;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.shockn745.moovin5.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Bind(R.id.main_edit_text)
    EditText mEditText;

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenter(this);

    }

    @OnClick(R.id.main_button)
    void onMotivationClicked() {
        mPresenter.startMotivationIfPossible();
    }

    @Override
    public void showMotivationActivity(int workoutDuration) {
        // todo implement
        showErrorSnackbar("Not implemented : " + workoutDuration);
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
    public void showErrorSnackbar(String message) {
        Snackbar.make(mEditText, message, Snackbar.LENGTH_SHORT).show();
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
