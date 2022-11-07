package com.example.inventory.addModule.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.example.inventory.R
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue

@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest{
    @Test
    fun createDialogNotNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{ fragmen ->
            assertThat(fragmen.dialog, Matchers.`is`(notNullValue()))
        }
    }

    @Test
    fun cancelDialog_isNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{ fragmen ->
            (fragmen.dialog as? AlertDialog)?.let {
                it.getButton(DialogInterface.BUTTON_NEGATIVE).performClick()
                assertThat(fragmen.dialog, Matchers.`is`(nullValue()))
            }
        }
    }

}