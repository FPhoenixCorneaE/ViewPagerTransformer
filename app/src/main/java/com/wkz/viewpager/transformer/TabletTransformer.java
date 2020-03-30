package com.wkz.viewpager.transformer;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * @desc 平板的转换效果
 * @date 2017-06-30
 */
public class TabletTransformer extends AbstractBaseTransformer {

    private Matrix mMatrix = new Matrix();
    private Camera mCamera = new Camera();
    private float[] mTempFloat2 = new float[2];

    @Override
    protected void onTransform(View page, float position) {

        float rotation = (position < 0 ? 30F : -30F) * Math.abs(position);

        ViewHelper.setTranslationX(page, getOffsetXForRotation(rotation, page.getWidth(), page.getHeight()));
        ViewHelper.setPivotX(page, page.getWidth() * 0.5F);
        ViewHelper.setPivotY(page, page.getWidth() * 0.5F);
        ViewHelper.setRotationY(page, rotation);

    }

    private float getOffsetXForRotation(float degrees, int width, int height) {
        mMatrix.reset();
        mCamera.save();
        mCamera.rotateY(Math.abs(degrees));
        mCamera.getMatrix(mMatrix);
        mCamera.restore();

        mMatrix.preTranslate(-width * 0.5F, -height * 0.5F);
        mMatrix.postTranslate(width * 0.5F, height * 0.5F);
        mTempFloat2[0] = width;
        mTempFloat2[1] = height;
        mMatrix.mapPoints(mTempFloat2);
        return (width - mTempFloat2[0]) * (degrees > 0.0F ? 1.0F : -1.0F);
    }
}
