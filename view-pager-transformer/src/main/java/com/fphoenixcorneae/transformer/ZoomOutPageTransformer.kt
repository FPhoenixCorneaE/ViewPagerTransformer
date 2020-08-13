package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 缩小滑动的转换效果
 * @date 2020-08-13 17:31
 */
class ZoomOutPageTransformer : AbstractBaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height
        when {
            position < -1 -> {
                page.alpha = 0f
            }
            position <= 1 -> {
                val scaleFactor = max(MIN_SCALE, 1 - abs(position))
                val verticalMargin = pageHeight * (1 - scaleFactor) / 2
                val horizontalMargin = pageWidth * (1 - scaleFactor) / 2
                if (position < 0) {
                    page.translationX = horizontalMargin - verticalMargin / 2
                } else {
                    page.translationX = -horizontalMargin + verticalMargin / 2
                }
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
            }
            else -> {
                page.alpha = 0f
            }
        }
    }

    override fun onTransform(page: View, position: Float) {}

    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }
}