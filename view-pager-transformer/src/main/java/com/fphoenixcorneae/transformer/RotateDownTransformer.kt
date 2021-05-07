package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 左转一定角度的转换效果
 * @date 2017-06-30
 */
class RotateDownTransformer : AbstractBaseTransformer() {

    override val isPagingEnabled: Boolean = true

    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        val pageHeight = page.height.toFloat()
        page.apply {
            pivotX = pageWidth * 0.5f
            pivotY = pageHeight
            rotation = ROT_MOD * position * -1.25f
        }
    }

    companion object {
        private const val ROT_MOD = -15f
    }
}