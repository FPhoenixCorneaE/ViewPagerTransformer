package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator

/**
 * @desc 错帧的转换效果
 * @date 2020-04-09 11:20
 */
class FrameDifferenceTransformer : AbstractBaseTransformer() {

    private var speed = 0.01f

    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width
        when (page) {
            is ViewGroup -> {
                (0 until page.childCount).forEach { index ->
                    when {
                        position < -1 -> { // [-Infinity,-1)
                            // This page is way off-screen to the left. 出了左边屏幕
                            page.getChildAt(index).translationX = 0f
                        }
                        position <= 1 -> { // [-1,1]
                            val factor = page.childCount - index + 1
                            page.getChildAt(index).animate()
                                    .translationX(pageWidth * position * 0.25f * speed * factor)
                                    .setDuration(200)
                                    .setInterpolator(LinearInterpolator())
                                    .withLayer()
                                    .start()
                        }
                        else -> { // (1,+Infinity]
                            // This page is way off-screen to the right.    出了右边屏幕
                            page.getChildAt(index).translationX = 0f
                        }
                    }
                }
            }
        }
    }
}