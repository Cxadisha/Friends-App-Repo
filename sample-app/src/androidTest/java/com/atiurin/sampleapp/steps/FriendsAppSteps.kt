package com.atiurin.sampleapp.steps

import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.pages.FriendsAPPMatchers
import com.atiurin.ultron.extensions.tap

object FriendsAppSteps {

    fun openChatOf(friend: String) {
        with(FriendsAPPMatchers) {
            chooseFriend(friend).isViewDisplayed()
            chooseFriend(friend).tap()
        }
    }

    fun sendText(text: String) {
        with(FriendsAPPMatchers) {
            textInput.typeText(text)
            messageInputText.isViewDisplayed()
            sendBtn.tap()
        }
    }
}
