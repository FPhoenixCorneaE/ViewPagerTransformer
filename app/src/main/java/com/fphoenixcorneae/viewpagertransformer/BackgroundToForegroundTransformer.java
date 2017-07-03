package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class BackgroundToForegroundTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        float pageWidth = page.getWidth();
        float pageHeight = page.getHeight();
        float scale = max(position < 0 ? 1F : Math.abs(1F - position), 0.25F);

        ViewHelper.setScaleX(page, scale);
        ViewHelper.setScaleY(page, scale);
        ViewHelper.setPivotX(page, pageWidth * 0.5F);
        ViewHelper.setPivotY(page, pageHeight * 0.5F);
        ViewHelper.setTranslationX(page, position < 0 ? pageWidth * position : -pageWidth * position * 0.25F);
    }
}
