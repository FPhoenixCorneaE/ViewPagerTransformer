package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 滑动遮盖的转换效果, wallpaper必须是page的子view, 并且必须设置tag为TAG_PARALLAX
 * @date 2019-06-02
 */
class OverspreadTransformer : AbstractBaseTransformer() {

    override fun onTransform(page: View, position: Float) {
        val pageWidth = page.width
        val wallpaper = page.findViewWithTag<View>(TAG_PARALLAX) ?: return
        when {
            position < -1 -> {
                // [-Infinity,-1)
                wallpaper.translationX = 0f
                page.translationX = 0f
            }
            position <= 1 -> {
                // [-1,1]
                wallpaper.translationX = pageWidth * getFactor(position)
                page.translationX = 8 * position
            }
            else -> {
                // (1,+Infinity]
                wallpaper.translationX = 0f
                page.translationX = 0f
            }
        }
    }

    private fun getFactor(position: Float): Float {
        return -position / 2
    }

    companion object {
        const val TAG_PARALLAX = "tag_parallax"
    }
}