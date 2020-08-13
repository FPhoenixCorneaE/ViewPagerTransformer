package com.wkz.viewpager

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.PageTransformer
import com.hss01248.lib.MyItemDialogListener
import com.hss01248.lib.StytledDialog
import com.fphoenixcorneae.transformer.*
import java.util.*
import kotlin.math.floor

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mVpPager: ViewPager? = null
    var bottomSheetDialog: Dialog? = null

    /**
     * 切换转换效果
     */
    private var mBtnChangeTransformer: Button? = null
    private val mTransformerMap: MutableMap<String, PageTransformer?> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        mVpPager = findViewById<View>(R.id.vp_pager) as ViewPager
        mBtnChangeTransformer = findViewById<View>(R.id.btn_change_transformer) as Button
        mBtnChangeTransformer!!.setOnClickListener(this)
        mVpPager!!.setPageTransformer(true, DefaultTransformer())
        mVpPager!!.adapter = object : PagerAdapter() {
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val page = FrameLayout(this@MainActivity)
                val mText = TextView(this@MainActivity)
                val bg = Color.rgb(floor(Math.random() * 128).toInt() + 64,
                        floor(Math.random() * 128).toInt() + 64,
                        floor(Math.random() * 128).toInt() + 64)
                mText.setBackgroundColor(bg)
                mText.gravity = Gravity.CENTER
                mText.text = String.format(Locale.getDefault(), "Page %d", position + 1)
                mText.textSize = 30f
                mText.setTextColor(Color.WHITE)
                mText.tag = OverspreadTransformer.TAG_PARALLAX
                page.addView(mText, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
                container.addView(page, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                return page
            }

            override fun getCount(): Int {
                return 10
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view === `object`
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun getItemPosition(`object`: Any): Int {
                return POSITION_NONE
            }
        }


        //底部弹出的带或不带取消按钮的弹窗
        mTransformerMap["AccordionTransformer"] = AccordionTransformer()
        mTransformerMap["BackgroundToForegroundTransformer"] = BackgroundToForegroundTransformer()
        mTransformerMap["CubeInTransformer"] = CubeInTransformer()
        mTransformerMap["CubeOutTransformer"] = CubeOutTransformer()
        mTransformerMap["DefaultTransformer"] = DefaultTransformer()
        mTransformerMap["DepthPageTransformer"] = DepthPageTransformer()
        mTransformerMap["DrawerTransformer"] = DrawerTransformer()
        mTransformerMap["FadeOutFadeInTransformer"] = FadeOutFadeInTransformer()
        mTransformerMap["FlipHorizontalTransformer"] = FlipHorizontalTransformer()
        mTransformerMap["FlipVerticalTransformer"] = FlipVerticalTransformer()
        mTransformerMap["ForegroundToBackgroundTransformer"] = ForegroundToBackgroundTransformer()
        mTransformerMap["OverspreadTransformer"] = OverspreadTransformer()
        mTransformerMap["RotateDownTransformer"] = RotateDownTransformer()
        mTransformerMap["RotateUpTransformer"] = RotateUpTransformer()
        mTransformerMap["ScaleInOutTransformer"] = ScaleInOutTransformer()
        mTransformerMap["StackTransformer"] = StackTransformer()
        mTransformerMap["TabletTransformer"] = TabletTransformer()
        mTransformerMap["VerticalTransformer"] = VerticalTransformer()
        mTransformerMap["ZoomInTransformer"] = ZoomInTransformer()
        mTransformerMap["ZoomOutPageTransformer"] = ZoomOutPageTransformer()
        mTransformerMap["ZoomOutSlideTransformer"] = ZoomOutSlideTransformer()
        mTransformerMap["ZoomOutTransformer"] = ZoomOutTransformer()
        val strings = listOf(
                "AccordionTransformer",
                "BackgroundToForegroundTransformer",
                "CubeInTransformer",
                "CubeOutTransformer",
                "DefaultTransformer",
                "DepthPageTransformer",
                "DrawerTransformer",
                "FadeOutFadeInTransformer",
                "FlipHorizontalTransformer",
                "FlipVerticalTransformer",
                "ForegroundToBackgroundTransformer",
                "OverspreadTransformer",
                "RotateDownTransformer",
                "RotateUpTransformer",
                "ScaleInOutTransformer",
                "StackTransformer",
                "TabletTransformer",
                "VerticalTransformer",
                "ZoomInTransformer",
                "ZoomOutPageTransformer",
                "ZoomOutSlideTransformer",
                "ZoomOutTransformer"
        )
        bottomSheetDialog = StytledDialog.showBottomItemDialog(this@MainActivity, strings, "cancel", true, true, object : MyItemDialogListener() {
            override fun onItemClick(text: String, position: Int) {
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                if (mTransformerMap[text] != null) {
                    mVpPager!!.setPageTransformer(true, mTransformerMap[text])
                }
            }

            override fun onBottomBtnClick() {}
        })
        bottomSheetDialog!!.dismiss()
    }

    override fun onBackPressed() {
        if (bottomSheetDialog != null && bottomSheetDialog!!.isShowing) {
            bottomSheetDialog!!.dismiss()
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_change_transformer -> bottomSheetDialog!!.show()
            else -> {
            }
        }
    }
}