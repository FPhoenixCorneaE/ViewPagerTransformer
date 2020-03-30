package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 向内收缩向外扩展的转换效果
 * @date 2017-06-30
 */
public class ScaleInOutTransformer extends AbstractBaseTransformer {

    @Override
    protected void onTransform(View page, float position) {
        ViewHelper.setPivotX(page, position < 0 ? 0 : page.getWidth());
        ViewHelper.setPivotY(page, page.getHeight() / 2f);
        float scale = position < 0 ? 1f + position : 1f - position;
        ViewHelper.setScaleX(page, scale);
        ViewHelper.setScaleY(page, scale);
    }
}
