package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 放大的转换效果
 * @date 2017-06-30
 */
class ZoomInTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val scale = if (position < 0) position + 1f else abs(1f - position)
        page.apply {
            scaleX = scale
            scaleY = scale
            pivotX = page.width * 0.5f
            pivotY = page.height * 0.5f
            alpha = if (position < -1f || position > 1f) {
                0f
            } else {
                1f - (scale - 1f)
            }
        }
    }
}