package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 后景到前景的转换效果
 * @date 2017-06-30
 */
class BackgroundToForegroundTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        val pageHeight = page.height.toFloat()
        val scale = max(if (position < 0) 1f else abs(1f - position), 0.25f)
        ViewHelper.setScaleX(page, scale)
        ViewHelper.setScaleY(page, scale)
        ViewHelper.setPivotX(page, pageWidth * 0.5f)
        ViewHelper.setPivotY(page, pageHeight * 0.5f)
        ViewHelper.setTranslationX(page, if (position < 0) pageWidth * position else -pageWidth * position * 0.25f)
    }
}