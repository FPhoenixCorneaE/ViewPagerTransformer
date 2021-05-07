package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 深度页面的转换效果
 * @date 2017-06-30
 */
class DepthPageTransformer : AbstractBaseTransformer() {

    override val isPagingEnabled: Boolean = true

    override fun onTransform(page: View, position: Float) {
        page.apply {
            if (position <= 0f) {
                translationX = 0f
                scaleX = 1f
                scaleY = 1f
            } else if (position <= 1f) {
                val scaleFactor = MIN_SCALE + (1f - MIN_SCALE) * (1f - abs(position))
                translationX = page.width * -position
                scaleX = scaleFactor
                scaleY = scaleFactor
                pivotY = page.height * 0.5f
                alpha = 1f - position
            }
        }
    }

    companion object {
        private const val MIN_SCALE = 0.75f
    }
}