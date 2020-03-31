package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 缩小的转换效果
 * @date 2017-06-30
 */
class ZoomOutTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val scale = 1f + abs(position)
        ViewHelper.setScaleX(page, scale)
        ViewHelper.setScaleY(page, scale)
        ViewHelper.setPivotX(page, page.width * 0.5f)
        ViewHelper.setPivotY(page, page.height * 0.5f)
        ViewHelper.setAlpha(page, if (position < -1f || position > 1f) 0f else 1f - (scale - 1f))
        if (position == -1f) {
            ViewHelper.setTranslationX(page, page.width * -1f)
        }
    }
}