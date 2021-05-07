package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 堆叠的转换效果
 * @date 2017-06-30
 */
class StackTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        page.translationX = if (position < 0) {
            0f
        } else {
            -page.width * position
        }
    }
}