package com.example.inventory.mainModule.view

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.inventory.R

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun actionBar_menuItemClick_returnMessage() {
        onView(withId(R.id.recyclerView)).perform(click())

        onView(withId(R.id.action_history)).perform(click())

        var snackbarMsg = ""
        activityScenarioRule.scenario.onActivity {
            snackbarMsg = it.getString(R.string.main_accion_text)
        }

        onView(withId(com.google.android.material.R.id.snackbar_text)).check(
            matches(
                withText(snackbarMsg)
            )
        )
    }

    @Test
    fun contextMenu_click_returnMessage(){
        onView(withId(R.id.recyclerView)).perform(click())

        var snackbarMsg = ""
        var menuTitle = ""
        activityScenarioRule.scenario.onActivity { activity ->
            snackbarMsg = activity.getString(R.string.main_accion_text_exit)
            menuTitle = activity.getString(R.string.main_menu)
        }


        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
        onView(withText(menuTitle)).perform(click())

        onView(withId(com.google.android.material.R.id.snackbar_text)).check(
            matches(
                withText(snackbarMsg)
            )
        )
    }
}
