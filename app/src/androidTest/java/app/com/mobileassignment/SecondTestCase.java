package app.com.mobileassignment;

/**
 * Created by madhu on 02-12-2017.
 */

        import android.support.test.filters.LargeTest;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import app.com.mobileassignment.views.MainActivity;
        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.Espresso.onData;
        import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
        import static android.support.test.espresso.action.ViewActions.typeText;
        import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.assertion.ViewAssertions.matches;
        import static org.hamcrest.Matchers.allOf;
        import static org.hamcrest.Matchers.anything;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class SecondTestCase {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    private MainActivity mActivity = null;

    @Test
    public void VerifyCityNames() throws InterruptedException {
        onView(withId(R.id.citiesList)).check(matches(isDisplayed()));
        onView(withId(R.id.search)).perform(typeText("Amste"));
        onView(withId(R.id.search)).perform(closeSoftKeyboard());
        Thread.sleep(5000);
        onData(anything()).inAdapterView(withId(R.id.citiesList)).onChildView(allOf(withId(R.id.cityName))).atPosition(0).check(matches(withText("Amsteg, CH")));
        onData(anything()).inAdapterView(withId(R.id.citiesList)).onChildView(allOf(withId(R.id.cityName))).atPosition(1).check(matches(withText("Amstelveen, NL")));
    }
}