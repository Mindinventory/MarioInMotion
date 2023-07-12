package com.mi.collapsingToolbarWithMotionCompose.ui.management

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy

abstract class MiScrollFlagState(heightRange: IntRange, scrollValue: Int) : MiToolbarState {
    protected var scrollFlagValue by mutableStateOf(
        value = scrollValue.coerceAtLeast(0),
        policy = structuralEqualityPolicy()
    )
    protected val rangeDifference = heightRange.last - heightRange.first
    protected val minHeight = heightRange.first
    protected val maxHeight = heightRange.last

    init {
        require(heightRange.first >= 0 && heightRange.last >= heightRange.first) {
            "The lowest height value must be >= 0 and the highest height value must be >= the lowest value."
        }
    }

    final override val progress: Float
        get() = 1 - (maxHeight - height) / rangeDifference
}