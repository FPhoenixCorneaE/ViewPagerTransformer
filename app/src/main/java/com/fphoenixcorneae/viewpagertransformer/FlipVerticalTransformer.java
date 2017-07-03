package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class FlipVerticalTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        float rotation = -180.0F * position;
        ViewHelper.setAlpha(page, rotation > 90.0F || rotation < -90.0F ? 0F : 1F);
        ViewHelper.setPivotX(page, page.getWidth() * 0.5F);
        ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
        ViewHelper.setRotationX(page, rotation);
    }
}
