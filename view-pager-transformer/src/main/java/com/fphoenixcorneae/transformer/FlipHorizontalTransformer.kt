package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 水平快速翻转的转换效果
 * @date 2017-06-30
 */
class FlipHorizontalTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val rotation = 180.0f * position
        ViewHelper.setAlpha(page, if (rotation > 90.0f || rotation < -90.0f) 0f else 1f)
        ViewHelper.setPivotX(page, page.width * 0.5f)
        ViewHelper.setPivotY(page, page.height * 0.5f)
        ViewHelper.setRotationY(page, rotation)
    }
}