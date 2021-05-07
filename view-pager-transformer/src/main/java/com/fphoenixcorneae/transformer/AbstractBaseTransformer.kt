package com.fphoenixcorneae.transformer

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

/**
 * @desc 基础转换效果
 * @date 2017-06-30
 */
abstract class AbstractBaseTransformer : ViewPager2.PageTransformer {

    protected open val isPagingEnabled: Boolean = false

    override fun transformPage(page: View, position: Float) {
        onPreTransform(page, position)
        onTransform(page, position)
        onPostTransform(page, position)
    }

    protected open fun onPreTransform(page: View, position: Float) {
        val pageWidth = page.width.toFloat()
        page.apply {
            rotationX = 0f
            rotationY = 0f
            rotation = 0f
            scaleX = 1f
            scaleY = 1f
            pivotX = 0f
            pivotY = 0f
            translationX = if (isPagingEnabled) {
                0f
            } else {
                -pageWidth * position
            }
            translationY = 0f
            alpha = if (hideOffscreenPages()) {
                if (position <= -1 || position >= 1) 0f else 1f
            } else {
                1f
            }
        }
    }

    protected open fun onPostTransform(page: View, position: Float) {}

    protected open fun hideOffscreenPages(): Boolean {
        return true
    }

    protected fun max(`val`: Float, max: Float): Float {
        return kotlin.math.max(`val`, max)
    }

    protected fun requireViewPager(page: View): ViewPager2 {
        val parent = page.parent
        val parentParent = parent.parent
        if (parent is RecyclerView && parentParent is ViewPager2) {
            return parentParent
        }
        throw IllegalStateException(
            "Expected the page view to be managed by a ViewPager2 instance."
        )
    }

    protected abstract fun onTransform(page: View, position: Float)
}