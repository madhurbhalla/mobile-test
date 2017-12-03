package app.com.mobileassignment;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import app.com.mobileassignment.views.MainActivity;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by madhu on 01-12-2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest


public class FirstTestCase extends ActivityInstrumentationTestCase2<MainActivity> {

    public FirstTestCase() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    // verify if the search field is displayed or not and also verify if user is able to enter any text
    public void UserInputTest1() {
        getActivity();
        Espresso.onView(withId(R.id.search)).check(matches(isDisplayed()));
        // Type any random text to check if the user is able to enter any text or not
        Espresso.onView(withId(R.id.search)).perform(typeText("Amsterdam"));
        closeSoftKeyboard();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
