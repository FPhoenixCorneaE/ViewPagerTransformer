package com.fphoenixcorneae.transformer

import android.view.View
import android.view.ViewGroup

/**
 * @desc 视觉差的转换效果
 * @date 2020-04-09 15:11
 */
class VisionDifferenceTransformer @JvmOverloads constructor(
        private var speed: Float = 0.5f
) : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        when (page) {
            is ViewGroup -> {
                (0 until page.childCount)
                        .asSequence()
                        .map { page.getChildAt(it) }
                        .forEach { it.translationX = -page.getWidth() * position * speed }
            }
        }
    }
}