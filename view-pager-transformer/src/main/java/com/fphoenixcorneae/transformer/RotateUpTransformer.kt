package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 右转一定角度的转换效果
 * @date 2017-06-30
 */
class RotateUpTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        val rotation = ROT_MOD * position
        ViewHelper.setPivotX(page, pageWidth * 0.5f)
        ViewHelper.setPivotY(page, 0f)
        ViewHelper.setTranslationX(page, 0f)
        ViewHelper.setRotation(page, rotation)
    }

    override val isPagingEnabled: Boolean = true

    companion object {
        private const val ROT_MOD = -15f
    }
}