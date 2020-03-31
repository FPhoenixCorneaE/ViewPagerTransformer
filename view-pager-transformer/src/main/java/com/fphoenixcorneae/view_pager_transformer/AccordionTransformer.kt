package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 像手风琴一样折叠的转换效果
 * @date 2017-06-30
 */
class AccordionTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        ViewHelper.setPivotX(page, if (position < 0) 0f else page.width.toFloat())
        ViewHelper.setScaleX(page, if (position < 0) 1f + position else 1f - position)
    }
}