package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 水平快速翻转的转换效果
 * @date 2017-06-30
 */
public class FlipHorizontalTransformer extends AbstractBaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        float rotation = 180.0F * position;
        ViewHelper.setAlpha(page, rotation > 90.0F || rotation < -90.0F ? 0F : 1F);
        ViewHelper.setPivotX(page, page.getWidth() * 0.5F);
        ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
        ViewHelper.setRotationY(page, rotation);
    }
}
