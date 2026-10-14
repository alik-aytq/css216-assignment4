package com.example.tiptime

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.NumberFormat

@RunWith(AndroidJUnit4::class)
class TipCalculatorUITests {

    @get:Rule
    val composeTestRule =
        createAndroidComposeRule<MainActivity>()

    @Test
    fun calculateTip_20Percent() {
        composeTestRule
            .onNodeWithTag("billAmount")
            .performTextInput("10")

        composeTestRule
            .onNodeWithTag("tipPercentage")
            .performTextInput("20")

        val expectedTip =
            NumberFormat.getCurrencyInstance().format(2)

        composeTestRule
            .onNodeWithText("Tip Amount: $expectedTip")
            .assertIsDisplayed()
    }
}
