package com.example.fadepoc

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import androidx.annotation.ColorInt

object ViewUtils {
    fun generateBackgroundWithShadow(
        @ColorInt backgroundColor: Int,
        cornerRadius: Float,
        @ColorInt shadowColor: Int,
        elevation: Int
    ): Drawable {
//        val cornerRadiusValue =
//            context.resources.getDimension(cornerRadius)
//        val elevationValue = context.resources.getDimension(elevation).toInt()
//        val backgroundColorValue = ContextCompat.getColor(context, backgroundColor)

        val outerRadius = floatArrayOf(
            cornerRadius, cornerRadius, cornerRadius,
            cornerRadius, cornerRadius, cornerRadius, cornerRadius,
            cornerRadius
        )

        val shapeDrawablePadding = Rect()
        shapeDrawablePadding.left = elevation
        shapeDrawablePadding.right = elevation
        shapeDrawablePadding.top = elevation
        shapeDrawablePadding.bottom = elevation

        val shapeDrawable = ShapeDrawable()
        shapeDrawable.setPadding(shapeDrawablePadding)
        shapeDrawable.paint.color = backgroundColor
        shapeDrawable.paint.setShadowLayer(cornerRadius, 0f, 0f, shadowColor)

        shapeDrawable.shape = RoundRectShape(outerRadius, null, null)

        val drawable =
            LayerDrawable(arrayOf<Drawable>(shapeDrawable))
        drawable.setLayerInset(0, elevation, elevation, elevation, elevation)

        return drawable
    }
}