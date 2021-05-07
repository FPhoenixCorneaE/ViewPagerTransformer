package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 后景到前景的转换效果
 * @date 2017-06-30
 */
class BackgroundToForegroundTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        val pageHeight = page.height.toFloat()
        val scale = max(
            if (position < 0) {
                1f
            } else {
                abs(1f - position)
            },
            0.25f
        )
        page.apply {
            scaleX = scale
            scaleY = scale
            pivotX = pageWidth * 0.5f
            pivotY = pageHeight * 0.5f
            translationX = if (position < 0) pageWidth * position else -pageWidth * position * 0.25f
        }
    }
}