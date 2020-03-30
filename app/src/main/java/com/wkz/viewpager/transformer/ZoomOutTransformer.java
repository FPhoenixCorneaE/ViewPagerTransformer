package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 缩小的转换效果
 * @date 2017-06-30
 */
public class ZoomOutTransformer extends AbstractBaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        float scale = 1F + Math.abs(position);
        ViewHelper.setScaleX(page, scale);
        ViewHelper.setScaleY(page, scale);
        ViewHelper.setPivotX(page, page.getWidth() * 0.5F);
        ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
        ViewHelper.setAlpha(page, position < -1F || position > 1F ? 0f : 1F - (scale - 1F));
        if (position == -1) {
            ViewHelper.setTranslationX(page, page.getWidth() * -1);
        }
    }
}
