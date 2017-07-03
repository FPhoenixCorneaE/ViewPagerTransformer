package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class ZoomInTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        final float scale = position < 0 ? position + 1F : Math.abs(1F - position);
        ViewHelper.setScaleX(page, scale);
        ViewHelper.setScaleY(page, scale);
        ViewHelper.setPivotX(page, page.getWidth() * 0.5F);
        ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
        ViewHelper.setAlpha(page, position < -1F || position > 1F ? 0F : 1F - (scale - 1F));
    }
}
