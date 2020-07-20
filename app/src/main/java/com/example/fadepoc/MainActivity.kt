package com.example.fadepoc

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.REVERSE
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        violationLayout.setDependencies(
            severityShadowBackgroundFactory = ShapeSeverityShadowBackgroundFactory(this)
        )

        violationLayout.setOnClickListener {
            pulseColor(ContextCompat.getColor(this, R.color.yellow))
        }

        pulseColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
    }

    private fun pulseColor(@ColorInt color: Int) {
        (violationLayout.tag as ObjectAnimator?)?.cancel()

        val startColor = ContextCompat.getColor(this, android.R.color.transparent)

        // calls setPulseColor on our [ViolationLayout].  This should probably be encapsulated
        // within the layout itself, but this is a proof of concept.
        val colorAnim = ObjectAnimator.ofInt(violationLayout, "violationColor", startColor, color, startColor)
        colorAnim.duration = 2000
        colorAnim.setEvaluator(ArgbEvaluator())
        colorAnim.repeatMode = REVERSE
        colorAnim.repeatCount = INFINITE

        // Save the ObjectAnimator in the view tag so that we can cancel it later.
        violationLayout.tag = colorAnim

        colorAnim.start()
    }
}