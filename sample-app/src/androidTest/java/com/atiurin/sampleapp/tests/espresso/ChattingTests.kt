package com.atiurin.sampleapp.tests.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.helper.getText
import com.atiurin.sampleapp.helper.isTextOnScreen
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.pages.FriendsAPPMatchers
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.steps.FriendsAppSteps
import com.atiurin.ultron.extensions.tap
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)
    val friend = "Chandler Bing"
    val text = "u're not funny"

    @Test
    fun textWithMyFriend() {
        with(UIElementPage) {
            isTextOnScreen("Friends")
            nameChandler.isViewDisplayed()
            nameChandler.tap()
            textInput.typeText("Hello Rachel")

            messageInputText.isViewDisplayed()
        }
    }

    // task 4-1
    @Test
    fun sendMessageToFriend() {
        with(FriendsAPPMatchers) {
            onView(mainToolBar)
                .check(matches(isDisplayed()))
        }

        with(FriendsAppSteps) {
            openChatOf(friend)
            sendText(text)
        }

        with(FriendsAPPMatchers) {
            onView(mainChatBar)
                .check(matches(isDisplayed()))
                .check(matches(withText(friend)))
            Assert.assertEquals(newText.getText(), text)
        }
    }
}
