package com.atiurin.sampleapp.steps

import android.app.Instrumentation
import android.os.SystemClock
import android.view.MotionEvent
import androidx.test.platform.app.InstrumentationRegistry
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.swiper
import com.atiurin.sampleapp.pages.FriendsAPPMatchers

object FriendsAppSteps2 {

    private fun swipeToBottom2() {
        swiperCustom(50, 10, 20)
    }

    fun findFriend(friend: String) {
        with(FriendsAPPMatchers) {
            chooseFriend(friend).isViewDisplayed()
        }
    }

    fun scrollTo(friend: String) {
        while (!FriendsAPPMatchers.chooseFriend(friend).isViewDisplayed()) {
            swiperCustom(50, 10, 20)
        }
    }

    private fun swiperCustom(start: Int, end: Int, delay: Int) {
        val downTime: Long = SystemClock.uptimeMillis()
        var eventTime: Long = SystemClock.uptimeMillis()
        val inst: Instrumentation = InstrumentationRegistry.getInstrumentation()
        var event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 500f, start.toFloat(), 0)
        inst.sendPointerSync(event)
        eventTime = SystemClock.uptimeMillis() + delay
        event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, 500f, end.toFloat(), 0)
        inst.sendPointerSync(event)
        event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 500f, end.toFloat(), 0)
        inst.sendPointerSync(event)
        SystemClock.sleep(2000) // The wait is important to scroll
    }
}