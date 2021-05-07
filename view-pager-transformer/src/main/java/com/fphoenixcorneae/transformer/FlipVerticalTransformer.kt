package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 垂直快速翻转的转换效果
 * @date 2017-06-30
 */
class FlipVerticalTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val rotation = -180.0f * position
        page.apply {
            alpha = if (rotation > 90.0f || rotation < -90.0f) {
                0f
            } else {
                1f
            }
            pivotX = width * 0.5f
            pivotY = height * 0.5f
            rotationX = rotation
        }
    }
}