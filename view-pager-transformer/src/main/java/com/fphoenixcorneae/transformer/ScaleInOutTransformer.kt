package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 向内收缩向外扩展的转换效果
 * @date 2017-06-30
 */
class ScaleInOutTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.apply {
            pivotX = if (position < 0) {
                0f
            } else {
                width.toFloat()
            }
            pivotY = height / 2f
            val scale = if (position < 0) {
                1f + position
            } else {
                1f - position
            }
            scaleX = scale
            scaleY = scale
        }
    }
}