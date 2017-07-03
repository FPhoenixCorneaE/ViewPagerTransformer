package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class DepthPageTransformer extends BaseTransformer {
    private static final float MIN_SCALE = 0.75F;

    @Override
    protected void onTransform(View page, float position) {
        if (position <= 0F) {
            ViewHelper.setTranslationX(page, 0F);
            ViewHelper.setScaleX(page, 1F);
            ViewHelper.setScaleY(page, 1F);
        } else if (position <= 1F) {
            float scaleFactor = MIN_SCALE + (1F - MIN_SCALE) * (1F - Math.abs(position));
            ViewHelper.setTranslationX(page, page.getWidth() * -position);
            ViewHelper.setScaleX(page, scaleFactor);
            ViewHelper.setScaleY(page, scaleFactor);
            ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
            ViewHelper.setAlpha(page, 1F - position);
        }
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
