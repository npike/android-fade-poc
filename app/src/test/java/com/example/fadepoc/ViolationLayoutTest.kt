package com.example.fadepoc

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import androidx.core.content.res.ResourcesCompat
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class ViolationLayoutTest {
    private lateinit var severityShadowBackgroundFactory: TestSeverityShadowBackgroundFactory
    private lateinit var viewUnderTest: ViolationLayout
    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()

        severityShadowBackgroundFactory = TestSeverityShadowBackgroundFactory()

        viewUnderTest = ViolationLayout(context)
        viewUnderTest.setDependencies(
            severityShadowBackgroundFactory
        )
    }

    @Test
    fun `when low severity, verify yellow shadow is created`() {
        // Act
        viewUnderTest.setLowSeverity()

        // Assert
        assertEquals(
            ResourcesCompat.getColor(context.resources, R.color.yellow, null),
            severityShadowBackgroundFactory.lastShadowColor
        )
    }

    @Test
    fun `when high severity, verify red shadow is created`() {
        // Act
        viewUnderTest.setHighSeverity()

        // Assert
        assertEquals(
            ResourcesCompat.getColor(context.resources, R.color.red, null),
            severityShadowBackgroundFactory.lastShadowColor
        )
    }

    /**
     * A test fake that captures the last requested shadow color.
     */
    class TestSeverityShadowBackgroundFactory : SeverityShadowBackgroundFactory {
        var lastShadowColor: Int = -1

        override fun makeShadow(color: Int): Drawable {
            lastShadowColor = color

            // return doesnt matter, we wont actually use it
            return ShapeDrawable()
        }

    }
}