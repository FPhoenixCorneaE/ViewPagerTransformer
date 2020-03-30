package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 像手风琴一样折叠的转换效果
 * @date 2017-06-30
 */
public class AccordionTransformer extends AbstractBaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setPivotX(page, position < 0 ? 0F : page.getWidth());
        ViewHelper.setScaleX(page, position < 0 ? 1F + position : 1F - position);
    }
}
