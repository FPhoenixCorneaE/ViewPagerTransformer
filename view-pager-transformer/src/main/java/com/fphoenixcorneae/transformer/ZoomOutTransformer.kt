package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 缩小的转换效果
 * @date 2017-06-30
 */
class ZoomOutTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val scale = 1f + abs(position)
        page.apply {
            scaleX = scale
            scaleY = scale
            pivotX = page.width * 0.5f
            pivotY = page.height * 0.5f
            alpha = if (position < -1f || position > 1f) 0f else 1f - (scale - 1f)
            if (position == -1f) {
                translationX = page.width * -1f
            }
        }
    }
}