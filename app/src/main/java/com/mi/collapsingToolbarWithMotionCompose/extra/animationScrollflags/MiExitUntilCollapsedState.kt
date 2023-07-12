package com.mi.collapsingToolbarWithMotionCompose.extra.animationScrollflags

import androidx.compose.runtime.saveable.mapSaver
import com.mi.collapsingToolbarWithMotionCompose.ui.management.MiScrollFlagState

class MiExitUntilCollapsedState(
    heightRange: IntRange,
    scrollValue: Int = 0
) : MiScrollFlagState(heightRange, scrollValue) {

    override val offset: Float = 0f

    override val height: Float
        get() = (maxHeight.toFloat() - scrollValue).coerceIn(minHeight.toFloat(), maxHeight.toFloat())

    override var scrollValue: Int
        get() = scrollFlagValue
        set(value) {
            scrollFlagValue = value.coerceAtLeast(0)
        }

    companion object {
        val Saver = run {

            val minHeightKey = "MinHeight"
            val maxHeightKey = "MaxHeight"
            val scrollValueKey = "ScrollValue"

            mapSaver(
                save = {
                    mapOf(
                        minHeightKey to it.minHeight,
                        maxHeightKey to it.maxHeight,
                        scrollValueKey to it.scrollValue
                    )
                },
                restore = {
                    MiExitUntilCollapsedState(
                        heightRange = (it[minHeightKey] as Int)..(it[maxHeightKey] as Int),
                        scrollValue = it[scrollValueKey] as Int
                    )
                }
            )
        }
    }
}