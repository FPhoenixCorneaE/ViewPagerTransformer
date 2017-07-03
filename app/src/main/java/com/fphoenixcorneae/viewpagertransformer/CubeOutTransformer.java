package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class CubeOutTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setPivotX(page, position > 0 ? 0F : page.getWidth());
        ViewHelper.setPivotY(page, page.getHeight() * 0.5F);
        ViewHelper.setRotationY(page, 90.0F * position);
    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
