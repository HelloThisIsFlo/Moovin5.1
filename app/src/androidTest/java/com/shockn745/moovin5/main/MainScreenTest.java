package com.shockn745.moovin5.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.shockn745.moovin5.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * UI Test for the Main Screen
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainScreenTest {

    private final static String WRONG_DURATION = "hello";
    private final static String RIGHT_DURATION = "40";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initTest() {
        // Do nothing for now
    }

    @Test
    public void enterDuration_success() {
        // Type text and then press the button.
        onView(withId(R.id.main_edit_text))
                .perform(typeText(RIGHT_DURATION), closeSoftKeyboard());
        onView(withId(R.id.main_button)).perform(click());

        // Check that Motivation Activity is displayed
        onView(withId(R.id.motivation_toolbar)).check(matches(isDisplayed()));
    }

    @Test
    public void enterDuration_parse_error() {
        // Type text and then press the button.
        onView(withId(R.id.main_edit_text))
                .perform(typeText(WRONG_DURATION), closeSoftKeyboard());
        onView(withId(R.id.main_button)).perform(click());

        // Check that the text was changed.
        onView(allOf(
                withId(android.support.design.R.id.snackbar_text),
                withText(R.string.main_error_snackbar)
        )).check(matches(isDisplayed()));
    }

    @Test
    public void enterDuration_empty_error() {
        // Press the button. with no text
        onView(withId(R.id.main_button)).perform(click());

        // Check that the text was changed.
        onView(allOf(
                withId(android.support.design.R.id.snackbar_text),
                withText(R.string.main_error_snackbar)
        )).check(matches(isDisplayed()));
    }
}
