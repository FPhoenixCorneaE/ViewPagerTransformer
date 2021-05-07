package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 像手风琴一样折叠的转换效果
 * @date 2017-06-30
 */
class AccordionTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.apply {
            pivotX = if (position < 0) {
                0f
            } else {
                page.width.toFloat()
            }
            scaleX = if (position < 0) {
                1f + position
            } else {
                1f - position
            }
        }
    }
}