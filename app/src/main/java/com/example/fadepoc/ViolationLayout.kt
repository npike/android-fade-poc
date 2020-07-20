package com.example.fadepoc

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout

class ViolationLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    fun setViolationColor(color: Int) {
        Log.d("foo", "pulseColor $color")
        background = ViewUtils.generateBackgroundWithShadow(
            this,
            android.R.color.transparent,
            R.dimen.radius_corner,
            color,
            R.dimen.elevation
        )
    }
}