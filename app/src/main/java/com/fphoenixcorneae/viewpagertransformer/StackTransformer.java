package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created on 2017/6/30.
 */

public class StackTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setTranslationX(page, position < 0 ? 0F : -page.getWidth() * position);
    }
}
