package com.wkz.viewpager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public abstract class BaseTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        onPreTransform(page, position);
        onTransform(page, position);
        onPostTransform(page, position);
    }

    protected void onPreTransform(View page, float position) {
        float pageWidth = page.getWidth();
        ViewHelper.setRotationX(page, 0F);
        ViewHelper.setRotationY(page, 0F);
        ViewHelper.setRotation(page, 0F);
        ViewHelper.setScaleX(page, 1F);
        ViewHelper.setScaleY(page, 1F);
        ViewHelper.setPivotX(page, 0F);
        ViewHelper.setPivotY(page, 0F);
        ViewHelper.setTranslationX(page, isPagingEnabled() ? 0F : -pageWidth * position);
        ViewHelper.setTranslationY(page, 0F);

        if (hideOffscreenPages()) {
            ViewHelper.setAlpha(page, position <= -1 || position >= 1 ? 0F : 1F);
        } else {
            ViewHelper.setAlpha(page, 1F);
        }
    }

    protected void onPostTransform(View page, float position) {
    }

    protected boolean hideOffscreenPages() {
        return true;
    }

    protected boolean isPagingEnabled() {
        return false;
    }

    protected float max(float val, float max) {
        return val < max ? max : val;
    }

    protected abstract void onTransform(View page, float position);
}
