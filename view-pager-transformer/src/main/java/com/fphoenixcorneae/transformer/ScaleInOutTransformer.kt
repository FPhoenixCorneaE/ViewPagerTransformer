package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 向内收缩向外扩展的转换效果
 * @date 2017-06-30
 */
class ScaleInOutTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        ViewHelper.setPivotX(page, if (position < 0) 0f else page.width.toFloat())
        ViewHelper.setPivotY(page, page.height / 2f)
        val scale = if (position < 0) 1f + position else 1f - position
        ViewHelper.setScaleX(page, scale)
        ViewHelper.setScaleY(page, scale)
    }
}