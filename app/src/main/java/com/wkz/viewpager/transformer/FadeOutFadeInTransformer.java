package com.wkz.testanimation.pagetransformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * 淡出淡入转场效果
 *
 * @author wkz
 * @date 2019/6/29
 */
public class FadeOutFadeInTransformer implements ViewPager.PageTransformer {
    /**
     * 最小透明度
     */
    private static final float MIN_ALPHA = 0.0f;

    @Override
    public void transformPage(View view, float position) {
        // 得到view宽
        int pageWidth = view.getWidth();

        if (position < -1) {
            // [-Infinity,-1)
            // This page is way off-screen to the left. 出了左边屏幕
            view.setAlpha(0);

        } else if (position <= 1) {
            // [-1,1]
            if (position < 0) {
                // 消失的页面
                // 阻止消失页面的滑动
                view.setTranslationX(-pageWidth * position);
            } else {
                // 出现的页面
                // 直接设置出现的页面到底
                view.setTranslationX(pageWidth);
                // 阻止出现页面的滑动
                view.setTranslationX(-pageWidth * position);
            }
            // Fade the page relative to its size.
            float alphaFactor = Math.max(MIN_ALPHA, 1 - Math.abs(position));
            // 透明度改变Log
            view.setAlpha(alphaFactor);
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.    出了右边屏幕
            view.setAlpha(0);
        }
    }
}
