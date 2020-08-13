package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 垂直转换效果
 * @date 2020-08-13 17:24
 */
class VerticalTransformer : AbstractBaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        var alpha = 0f
        if (position in 0.0..1.0) {
            alpha = 1 - position
        } else if (-1 < position && position < 0) {
            alpha = position + 1
        }
        page.alpha = alpha
        val transX = page.width * -position
        page.translationX = transX
        val transY = position * page.height
        page.translationY = transY
    }

    override fun onTransform(page: View, position: Float) {}
}