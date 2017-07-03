package com.fphoenixcorneae.viewpagertransformer;

import android.view.View;

/**
 * Created on 2017/6/30.
 */

public class DefaultTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View page, float position) {

    }

    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
}
