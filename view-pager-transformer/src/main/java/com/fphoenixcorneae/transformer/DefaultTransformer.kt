package com.fphoenixcorneae.transformer

import android.view.View

/**
 * @desc 默认转换效果
 * @date 2017-06-30
 */
class DefaultTransformer : AbstractBaseTransformer() {

    override val isPagingEnabled: Boolean = true

    override fun onTransform(page: View, position: Float) {}
}