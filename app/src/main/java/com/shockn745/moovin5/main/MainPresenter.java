package com.shockn745.moovin5.main;

/**
 * MVP Presenter for the Main Activity
 */
public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void startMotivationIfPossible() {

    }
}
