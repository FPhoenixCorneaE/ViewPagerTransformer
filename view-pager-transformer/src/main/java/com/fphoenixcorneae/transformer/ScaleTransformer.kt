package com.fphoenixcorneae.transformer

import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

/**
 * @desc 两边缩小的转换效果
 * @date 2021-05-07 15:59
 */
class ScaleTransformer(
    @Px private val otherPageWidth: Int = 80,
    @Px private val pageMargin: Int = 40,
    private val minScale: Float = 0.75f
) : AbstractBaseTransformer() {

    override fun onPreTransform(page: View, position: Float) {}

    override fun onTransform(page: View, position: Float) {
        requireViewPager(page).apply {
            val offset: Float = pageMargin * position
            page.translationX = offset

            (getChildAt(0) as RecyclerView).let {
                it.clipToPadding = false
                it.setPadding(
                    otherPageWidth + abs(pageMargin),
                    this.paddingTop,
                    otherPageWidth + abs(pageMargin),
                    this.paddingBottom
                )
            }
        }

        val pageWidth: Int = page.width
        val pageHeight: Int = page.height
        page.pivotY = (pageHeight shr 1).toFloat()
        page.pivotX = (pageWidth shr 1).toFloat()
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.scaleX = minScale
            page.scaleY = minScale
            page.pivotX = pageWidth.toFloat()
        } else if (position <= 1) {
            // [-1,1]
            // Modify the default slide transition to shrink the page as well
            if (position < 0) {
                //1-2:1[0,-1] ;2-1:1[-1,0]
                val scaleFactor: Float = (1 + position) * (1 - minScale) + minScale
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.pivotX = pageWidth * (DEFAULT_CENTER + DEFAULT_CENTER * -position)
            } else {
                //1-2:2[1,0] ;2-1:2[0,1]
                val scaleFactor: Float = (1 - position) * (1 - minScale) + minScale
                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.pivotX = pageWidth * ((1 - position) * DEFAULT_CENTER)
            }
        } else {
            // (1,+Infinity]
            page.pivotX = 0f
            page.scaleX = minScale
            page.scaleY = minScale
        }
    }

    private fun requireViewPager(page: View): ViewPager2 {
        val parent = page.parent
        val parentParent = parent.parent
        if (parent is RecyclerView && parentParent is ViewPager2) {
            return parentParent
        }
        throw IllegalStateException(
            "Expected the page view to be managed by a ViewPager2 instance."
        )
    }

    companion object {
        private const val DEFAULT_CENTER = 0.5f
    }
}