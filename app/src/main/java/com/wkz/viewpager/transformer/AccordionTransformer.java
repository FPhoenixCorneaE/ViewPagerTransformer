package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class AccordionTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setPivotX(page, position < 0 ? 0F : page.getWidth());
        ViewHelper.setScaleX(page, position < 0 ? 1F + position : 1F - position);
    }
}
