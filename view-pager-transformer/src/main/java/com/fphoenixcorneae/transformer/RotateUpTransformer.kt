package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 右转一定角度的转换效果
 * @date 2017-06-30
 */
class RotateUpTransformer : AbstractBaseTransformer() {

    override val isPagingEnabled: Boolean = true

    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        page.apply {
            pivotX = pageWidth * 0.5f
            pivotY = 0f
            translationX = 0f
            rotation = ROT_MOD * position
        }
    }

    companion object {
        private const val ROT_MOD = -15f
    }
}