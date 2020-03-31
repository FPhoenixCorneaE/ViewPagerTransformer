package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 深度页面的转换效果
 * @date 2017-06-30
 */
class DepthPageTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        if (position <= 0f) {
            ViewHelper.setTranslationX(page, 0f)
            ViewHelper.setScaleX(page, 1f)
            ViewHelper.setScaleY(page, 1f)
        } else if (position <= 1f) {
            val scaleFactor = MIN_SCALE + (1f - MIN_SCALE) * (1f - abs(position))
            ViewHelper.setTranslationX(page, page.width * -position)
            ViewHelper.setScaleX(page, scaleFactor)
            ViewHelper.setScaleY(page, scaleFactor)
            ViewHelper.setPivotY(page, page.height * 0.5f)
            ViewHelper.setAlpha(page, 1f - position)
        }
    }

    override val isPagingEnabled: Boolean = true

    companion object {
        private const val MIN_SCALE = 0.75f
    }
}