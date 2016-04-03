package com.werockstar.calculatorwithespresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivity =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testLoginSuccessful() {
        onView(withId(R.id.edtUsername))
                .perform(typeText("WeRockStar"));
        onView(withId(R.id.edtPassword))
                .perform(typeText("root"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.tvResult)).check(matches(withText("Successful")));
    }

    @Test
    public void testLoginUnsuccessful() {
        onView(withId(R.id.edtUsername))
                .perform(typeText("WeRockStar"));
        onView(withId(R.id.edtPassword))
                .perform(typeText("root2"), closeSoftKeyboard());

        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.tvResult)).check(matches(withText("Unsuccessful")));
    }
}