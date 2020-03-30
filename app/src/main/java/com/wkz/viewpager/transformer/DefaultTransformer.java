package com.wkz.viewpager.transformer;

import android.view.View;

/**
 * @desc 默认转换效果
 * @date 2017-06-30
 */
public class DefaultTransformer extends AbstractBaseTransformer {
    @Override
    protected void onTransform(View page, float position) {

    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
