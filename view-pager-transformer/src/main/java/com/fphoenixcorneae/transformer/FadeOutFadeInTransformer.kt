package com.fphoenixcorneae.transformer

import android.view.View
import kotlin.math.abs

/**
 * @desc 淡出淡入的转换效果
 * @date 2019-06-29
 */
class FadeOutFadeInTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        // 得到view宽
        val pageWidth = page.width
        when {
            position < -1 -> {
                // [-Infinity,-1)
                // This page is way off-screen to the left. 出了左边屏幕
                page.alpha = 0f
            }
            position <= 1 -> {
                // [-1,1]
                if (position < 0) {
                    // 消失的页面
                    // 阻止消失页面的滑动
                    page.translationX = -pageWidth * position
                } else {
                    // 出现的页面
                    // 直接设置出现的页面到底
                    page.translationX = pageWidth.toFloat()
                    // 阻止出现页面的滑动
                    page.translationX = -pageWidth * position
                }
                // Fade the page relative to its size.
                val alphaFactor = max(MIN_ALPHA, 1 - abs(position))
                // 透明度改变Log
                page.alpha = alphaFactor
            }
            else -> { // (1,+Infinity]
                // This page is way off-screen to the right. 出了右边屏幕
                page.alpha = 0f
            }
        }
    }

    companion object {
        /**
         * 最小透明度
         */
        private const val MIN_ALPHA = 0.0f
    }
}