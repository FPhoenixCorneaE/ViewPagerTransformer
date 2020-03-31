package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 放大的转换效果
 * @date 2017-06-30
 */
class ZoomInTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val scale = if (position < 0) position + 1f else abs(1f - position)
        ViewHelper.setScaleX(page, scale)
        ViewHelper.setScaleY(page, scale)
        ViewHelper.setPivotX(page, page.width * 0.5f)
        ViewHelper.setPivotY(page, page.height * 0.5f)
        ViewHelper.setAlpha(page, if (position < -1f || position > 1f) 0f else 1f - (scale - 1f))
    }
}