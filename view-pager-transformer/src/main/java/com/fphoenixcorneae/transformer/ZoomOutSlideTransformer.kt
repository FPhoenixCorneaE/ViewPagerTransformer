package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 缩小滑动的转换效果
 * @date 2017-06-30
 */
class ZoomOutSlideTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        if (position >= -1 || position <= 1) {
            // Modify the default slide transition to shrink the page as well
            val height = page.height.toFloat()
            val scaleFactor = max(MIN_SCALE, 1 - abs(position))
            val vertMargin = height * (1 - scaleFactor) / 2
            val horzMargin = page.width * (1 - scaleFactor) / 2

            // Center vertically
            ViewHelper.setPivotY(page, 0.5f * height)
            when {
                position < 0 -> {
                    ViewHelper.setTranslationX(page, horzMargin - vertMargin / 2)
                }
                else -> {
                    ViewHelper.setTranslationX(page, -horzMargin + vertMargin / 2)
                }
            }

            // Scale the page down (between MIN_SCALE and 1)
            ViewHelper.setScaleX(page, scaleFactor)
            ViewHelper.setScaleY(page, scaleFactor)

            // Fade the page relative to its size.
            ViewHelper.setAlpha(page, MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA))
        }
    }

    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }
}