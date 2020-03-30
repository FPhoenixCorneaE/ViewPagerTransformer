package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 堆叠的转换效果
 * @date 2017-06-30
 */
public class StackTransformer extends AbstractBaseTransformer {
    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setTranslationX(page, position < 0 ? 0F : -page.getWidth() * position);
    }
}
