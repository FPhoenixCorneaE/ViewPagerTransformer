package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 立方体向外的转换效果
 * @date 2017-06-30
 */
public class CubeOutTransformer extends AbstractBaseTransformer {
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
