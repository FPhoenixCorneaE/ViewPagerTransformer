package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class RotateUpTransformer extends BaseTransformer {

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
