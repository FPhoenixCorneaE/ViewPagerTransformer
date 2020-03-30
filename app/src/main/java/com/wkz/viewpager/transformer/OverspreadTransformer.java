package com.wkz.viewpager.transformer;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 滑动遮盖效果, wallpaper必须是page的子view, 并且必须设置tag为TAG_PARALLAX
 * @date 2019-06-02
 */
public class OverspreadTransformer extends AbstractBaseTransformer {

    public static final String TAG_PARALLAX = "tag_parallax";

    @Override
    protected void onTransform(View page, float position) {
        int pageWidth = page.getWidth();
        View wallpaper = page.findViewWithTag(TAG_PARALLAX);
        if (wallpaper == null) {
            return;
        }
        if (position < -1) {
            // [-Infinity,-1)
            ViewHelper.setTranslationX(wallpaper, 0);
            ViewHelper.setTranslationX(page, 0);
        } else if (position <= 1) {
            // [-1,1]
            ViewHelper.setTranslationX(wallpaper, pageWidth * getFactor(position));
            ViewHelper.setTranslationX(page, 8 * position);
        } else {
            // (1,+Infinity]
            ViewHelper.setTranslationX(wallpaper, 0);
            ViewHelper.setTranslationX(page, 0);
        }
    }

    private float getFactor(float position) {
        return -position / 2;
    }
}
