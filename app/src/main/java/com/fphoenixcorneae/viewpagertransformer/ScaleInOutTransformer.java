package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class ScaleInOutTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setPivotX(page, position < 0 ? 0 : page.getWidth());
        ViewHelper.setPivotY(page, page.getHeight() / 2f);
        float scale = position < 0 ? 1f + position : 1f - position;
        ViewHelper.setScaleX(page, scale);
        ViewHelper.setScaleY(page, scale);
    }
}
