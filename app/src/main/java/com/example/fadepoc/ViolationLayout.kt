package com.example.fadepoc

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout

class ViolationLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    fun setViolationColor(color: Int) {
        Log.d("foo", "pulseColor $color")
        background = ViewUtils.generateBackgroundWithShadow(
            this,
            android.R.color.white,
            R.dimen.radius_corner,
            color,
            R.dimen.elevation
        )
    }
}