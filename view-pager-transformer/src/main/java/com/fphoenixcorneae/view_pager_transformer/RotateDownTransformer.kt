package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 左转一定角度的转换效果
 * @date 2017-06-30
 */
class RotateDownTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        val pageHeight = page.height.toFloat()
        val rotation = ROT_MOD * position * -1.25f
        ViewHelper.setPivotX(page, pageWidth * 0.5f)
        ViewHelper.setPivotY(page, pageHeight)
        ViewHelper.setRotation(page, rotation)
    }

    override val isPagingEnabled: Boolean = true

    companion object {
        private const val ROT_MOD = -15f
    }
}