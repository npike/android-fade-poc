package com.example.fadepoc

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat

class ViolationLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private lateinit var severityShadowBackgroundFactory: SeverityShadowBackgroundFactory

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    // Can't really do better without introducing a DI library.
    fun setDependencies(severityShadowBackgroundFactory: SeverityShadowBackgroundFactory) {
        this.severityShadowBackgroundFactory = severityShadowBackgroundFactory
    }

    fun setLowSeverity() {
        setViolationColor(ResourcesCompat.getColor(resources, R.color.yellow, null))
    }

    fun setHighSeverity() {
        setViolationColor(ResourcesCompat.getColor(resources, R.color.red, null))
    }

    fun setViolationColor(@ColorInt color: Int) {
        background = severityShadowBackgroundFactory.makeShadow(color)
    }
}