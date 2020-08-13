package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 抽屉转换效果
 * @date 2020-08-13 17:24
 */
class DrawerTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        if (position <= 0) {
            page.translationX = 0f
        } else if (position > 0 && position <= 1) {
            page.translationX = (-page.width shr 1) * position
        }
    }
}