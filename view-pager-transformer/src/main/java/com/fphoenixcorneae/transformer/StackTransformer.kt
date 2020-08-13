package com.fphoenixcorneae.transformer

import android.view.View
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 堆叠的转换效果
 * @date 2017-06-30
 */
class StackTransformer : AbstractBaseTransformer() {
    override fun onTransform(page: View, position: Float) {
        ViewHelper.setTranslationX(page, if (position < 0) 0f else -page.width * position)
    }
}