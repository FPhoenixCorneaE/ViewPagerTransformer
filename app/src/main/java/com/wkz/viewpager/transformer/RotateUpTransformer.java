package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 右转一定角度的转换效果
 * @date 2017-06-30
 */
public class RotateUpTransformer extends AbstractBaseTransformer {

    private static final float ROT_MOD = -15F;

    @Override
    protected void onTransform(View page, float position) {
        float pageWidth = page.getWidth();
        float rotation = ROT_MOD * position;

        ViewHelper.setPivotX(page, pageWidth * 0.5F);
        ViewHelper.setPivotY(page, 0F);
        ViewHelper.setTranslationX(page, 0F);
        ViewHelper.setRotation(page, rotation);
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
