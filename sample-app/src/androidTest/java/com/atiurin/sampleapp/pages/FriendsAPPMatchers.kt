package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object FriendsAPPMatchers {

    val mainToolBar: Matcher<View> by lazy { Matchers.allOf(withId(R.id.toolbar)) }
    val mainChatBar: Matcher<View> by lazy { Matchers.allOf(withId(R.id.toolbar_title)) }
    val textInput: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text)) }
    val messageInputText: Matcher<View> by lazy {
        Matchers.allOf(
            withId(R.id.message_input_text),
            withText("Enter text")
        )
    }
    val sendBtn: Matcher<View> by lazy { Matchers.allOf(withId(R.id.send_button)) }
    val newText: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_text), withText("u're not funny")) }

    fun chooseFriend(name: String): Matcher<View> {
        return Matchers.allOf(withId(R.id.tv_name), withText(name))
    }
}
