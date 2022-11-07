package com.example.inventory.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.inventory.entities.Product
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

@RunWith(AndroidJUnit4::class)
class AddViewModelTest{

    @get:Rule
    var instantExcecuteRule = InstantTaskExecutorRule()

    @Test
    fun addProductTest(){
        val addViewModel = AddViewModel()
        val product = Product(117,"prueba", 20, "https://images.squarespace-cdn.com/content/v1/53aadf1de4b0a0a817640cca/1541718896630-ZH3U5WZ8097TMISDOVA3/bigstock--220184203.jpg",
            4.8,56)

        val observer = Observer<Boolean>{}
            try {
                addViewModel.getResult().observeForever(observer)
                addViewModel.addProduct(product)
                val result = addViewModel.getResult().value
                //assertThat(result, Matchers.`is`(true))
                assertThat(result, Matchers.not(nullValue()))
            } finally {
                addViewModel.getResult().removeObserver(observer)
            }
    }

}