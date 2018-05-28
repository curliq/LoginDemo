package johnsardinha.logindemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import johnsardinha.logindemo.app.SplashActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogInTest {

    private val validEmail = "p1@gmail.com"
    private val validPassword = "qweasdzxc"
    private val emailEditText = R.id.loginFragment_et_email
    private val passwordEditText = R.id.loginFragment_et_password
    private val loginButton = R.id.loginFragment_btn_login

    // this starts SplashActivity
    @get:Rule
    val activityTestRule: ActivityTestRule<SplashActivity> = ActivityTestRule(SplashActivity::class.java)

    /**
     * Check if the the password editText and the button get enabled and disabled properly
     */
    @Test
    fun viewsEnableDisable() {
        // check if password editText and button are disabled
        onView(withId(passwordEditText)).check(matches(not(isEnabled())))
        onView(withId(loginButton)).check(matches(not(isEnabled())))

        // type email and check if password is enabled, but button still disabled
        onView(withId(emailEditText)).perform(typeText(validEmail))
        onView(withId(passwordEditText)).check(matches(isEnabled()))
        onView(withId(loginButton)).check(matches(not(isEnabled())))

        // type password and check if button is enabled
        onView(withId(passwordEditText)).perform(typeText(validPassword))
        onView(withId(loginButton)).check(matches(isEnabled()))
    }

    /**
     * Check if log in works, response is as expected and MainActivity is started
     */
    @Test
    fun login() {
        onView(withId(emailEditText)).perform(typeText(validEmail))
        onView(withId(passwordEditText)).perform(typeText(validPassword))
        onView(withId(loginButton)).perform(click()).check(matches(not(isEnabled())))

        //todo check if MainActivity is opened after http request's response
    }

}
