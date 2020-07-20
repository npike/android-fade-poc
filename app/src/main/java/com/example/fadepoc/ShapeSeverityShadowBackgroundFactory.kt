package com.example.fadepoc

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.content.res.ResourcesCompat

class ShapeSeverityShadowBackgroundFactory(private val context: Context) :
    SeverityShadowBackgroundFactory {
    override fun makeShadow(@ColorInt color: Int): Drawable {
        return ViewUtils.generateBackgroundWithShadow(
            backgroundColor = ResourcesCompat.getColor(
                context.resources,
                android.R.color.transparent,
                null
            ),
            cornerRadius = context.resources.getDimension(R.dimen.radius_corner),
            elevation = context.resources.getDimension(R.dimen.elevation).toInt(),
            shadowColor = color
        )
    }
}