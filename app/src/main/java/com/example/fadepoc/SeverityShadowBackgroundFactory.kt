package com.example.fadepoc

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt

/**
 * An interface that wraps the construction of the drawables that are used for severity shadows
 * so that it can be replaced during a test.
 */
interface SeverityShadowBackgroundFactory {
    fun makeShadow(@ColorInt color: Int): Drawable
}