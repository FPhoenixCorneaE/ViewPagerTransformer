package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 左转一定角度的转换效果
 * @date 2017-06-30
 */
public class RotateDownTransformer extends AbstractBaseTransformer {

    private static final float ROT_MOD = -15F;

    @Override
    protected void onTransform(View page, float position) {
        float pageWidth = page.getWidth();
        float pageHeight = page.getHeight();
        float rotation = ROT_MOD * position * -1.25F;

        ViewHelper.setPivotX(page, pageWidth * 0.5F);
        ViewHelper.setPivotY(page, pageHeight);
        ViewHelper.setRotation(page, rotation);

    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
