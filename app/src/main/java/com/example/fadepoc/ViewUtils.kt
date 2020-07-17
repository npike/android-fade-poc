package com.example.fadepoc

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat

object ViewUtils {
    fun generateBackgroundWithShadow(
        view: View, @ColorRes backgroundColor: Int,
        @DimenRes cornerRadius: Int,
        @ColorInt shadowColor: Int,
        @DimenRes elevation: Int
    ): Drawable {
        val cornerRadiusValue =
            view.context.resources.getDimension(cornerRadius)
        val elevationValue = view.context.resources.getDimension(elevation).toInt()
        val backgroundColorValue = ContextCompat.getColor(view.context, backgroundColor)

        val outerRadius = floatArrayOf(
            cornerRadiusValue, cornerRadiusValue, cornerRadiusValue,
            cornerRadiusValue, cornerRadiusValue, cornerRadiusValue, cornerRadiusValue,
            cornerRadiusValue
        )

        val shapeDrawablePadding = Rect()
        shapeDrawablePadding.left = elevationValue
        shapeDrawablePadding.right = elevationValue
        shapeDrawablePadding.top = elevationValue
        shapeDrawablePadding.bottom = elevationValue

        val shapeDrawable = ShapeDrawable()
        shapeDrawable.setPadding(shapeDrawablePadding)
        shapeDrawable.paint.color = backgroundColorValue
        shapeDrawable.paint.setShadowLayer(cornerRadiusValue, 0f, 0f, shadowColor)

//        view.setLayerType(LAYER_TYPE_SOFTWARE, shapeDrawable.getPaint());
        shapeDrawable.shape = RoundRectShape(outerRadius, null, null)

        val drawable =
            LayerDrawable(arrayOf<Drawable>(shapeDrawable))
        drawable.setLayerInset(0, elevationValue, elevationValue, elevationValue, elevationValue)

        return drawable
    }
}