package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 立方体向内的转换效果
 * @date 2017-06-30
 */
class CubeInTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.apply {
            pivotX = if (position > 0) {
                0f
            } else {
                page.width.toFloat()
            }
            pivotY = page.height * 0.5f
            rotationY = -90.0f * position
        }
    }

    override val isPagingEnabled: Boolean = true
}