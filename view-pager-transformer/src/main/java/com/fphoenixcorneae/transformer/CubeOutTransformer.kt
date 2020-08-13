package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 立方体向外的转换效果
 * @date 2017-06-30
 */
class CubeOutTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        ViewHelper.setPivotX(page, if (position > 0) 0f else page.width.toFloat())
        ViewHelper.setPivotY(page, page.height * 0.5f)
        ViewHelper.setRotationY(page, 90.0f * position)
    }

    override val isPagingEnabled: Boolean = true
}