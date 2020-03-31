package com.fphoenixcorneae.view_pager_transformer

import android.view.View
import androidx.viewpager.widget.ViewPager.PageTransformer
import com.nineoldandroids.view.ViewHelper

/**
 * @desc 基础转换效果
 * @date 2017-06-30
 */
abstract class AbstractBaseTransformer : PageTransformer {
    override fun transformPage(page: View, position: Float) {
        onPreTransform(page, position)
        onTransform(page, position)
        onPostTransform(page, position)
    }

    protected fun onPreTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        ViewHelper.setRotationX(page, 0f)
        ViewHelper.setRotationY(page, 0f)
        ViewHelper.setRotation(page, 0f)
        ViewHelper.setScaleX(page, 1f)
        ViewHelper.setScaleY(page, 1f)
        ViewHelper.setPivotX(page, 0f)
        ViewHelper.setPivotY(page, 0f)
        ViewHelper.setTranslationX(page, if (isPagingEnabled) 0f else -pageWidth * position)
        ViewHelper.setTranslationY(page, 0f)
        if (hideOffscreenPages()) {
            ViewHelper.setAlpha(page, if (position <= -1 || position >= 1) 0f else 1f)
        } else {
            ViewHelper.setAlpha(page, 1f)
        }
    }

    protected fun onPostTransform(page: View, position: Float) {}

    protected fun hideOffscreenPages(): Boolean {
        return true
    }

    protected open val isPagingEnabled: Boolean = false

    protected fun max(`val`: Float, max: Float): Float {
        return kotlin.math.max(`val`, max)
    }

    protected abstract fun onTransform(page: View, position: Float)
}