package com.fphoenixcorneae.transformer

import android.graphics.Camera
import android.graphics.Matrix
import android.view.View
import com.nineoldandroids.view.ViewHelper
import kotlin.math.abs

/**
 * @desc 平板的转换效果
 * @date 2017-06-30
 */
class TabletTransformer : AbstractBaseTransformer() {
    private val mMatrix = Matrix()
    private val mCamera = Camera()
    private val mTempFloat2 = FloatArray(2)
    override fun onTransform(page: View, position: Float) {
        val rotation = (if (position < 0) 30f else -30f) * abs(position)
        ViewHelper.setTranslationX(page, getOffsetXForRotation(rotation, page.width, page.height))
        ViewHelper.setPivotX(page, page.width * 0.5f)
        ViewHelper.setPivotY(page, page.width * 0.5f)
        ViewHelper.setRotationY(page, rotation)
    }

    private fun getOffsetXForRotation(degrees: Float, width: Int, height: Int): Float {
        mMatrix.reset()
        mCamera.save()
        mCamera.rotateY(abs(degrees))
        mCamera.getMatrix(mMatrix)
        mCamera.restore()
        mMatrix.preTranslate(-width * 0.5f, -height * 0.5f)
        mMatrix.postTranslate(width * 0.5f, height * 0.5f)
        mTempFloat2[0] = width.toFloat()
        mTempFloat2[1] = height.toFloat()
        mMatrix.mapPoints(mTempFloat2)
        return (width - mTempFloat2[0]) * if (degrees > 0.0f) 1.0f else -1.0f
    }
}