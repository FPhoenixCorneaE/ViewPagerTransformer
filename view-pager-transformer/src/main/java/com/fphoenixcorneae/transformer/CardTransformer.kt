package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 卡片堆叠的转换效果，需要设置 viewpager2.offscreenPageLimit = 2
 * @date 2021-05-06 15:35
 */
class CardTransformer(
    private val translationOffset: Float = 100f,
    private val mOffset: Float = 40F
) : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        if (position > 0) {
            //移动X轴坐标，使得卡片在同一坐标
            page.translationX = -position * page.width
            //缩放卡片并调整位置
            val scale: Float = (page.width - mOffset * position) / page.width
            page.scaleX = scale
            page.scaleY = scale
            //移动Y轴坐标
            page.translationY = position * mOffset
        }

    }
}