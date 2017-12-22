package com.rxjavasample;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.rxjavasample.test.common.TestComponentRule;
import com.rxjavasample.view.activity.home.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class HomActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<HomeActivity> home =
            new ActivityTestRule<HomeActivity>(HomeActivity.class, false, false) {
                @Override
                protected Intent getActivityIntent() {
                    // Override the default intent so we pass a false flag for syncing so it doesn't
                    // start a sync service in the background that would affect  the behaviour of
                    // this test.
                    return HomeActivity.getStartIntent(InstrumentationRegistry.getContext(), false);
                }
            };

    // TestComponentRule needs to go first to make sure the Dagger ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule
    public final TestRule chain = RuleChain.outerRule(component).around(home);

    @Test
    public void searchButtonEnabledWhenTypedValidUsername() {
        home.launchActivity(null);
        String validUsername = "validusername";
        String invalidUsername = "@invalid";

        onView(withId(R.id.activity_main_username))
                .perform(typeText(validUsername), closeSoftKeyboard());
        onView(withId(R.id.activity_main_search)).check(matches(isEnabled()));

        onView(withId(R.id.activity_main_username))
                .perform(clearText(), typeText(invalidUsername), closeSoftKeyboard());
        onView(withId(R.id.activity_main_search)).check(matches(not(isEnabled())));
    }
}