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
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.fphoenixcorneae.transformer.*
import com.hss01248.lib.MyItemDialogListener
import com.hss01248.lib.StytledDialog
import java.util.*
import kotlin.math.floor

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mVpPager: ViewPager2? = null
    var bottomSheetDialog: Dialog? = null

    /**
     * 切换转换效果
     */
    private var mBtnChangeTransformer: Button? = null
    private val mTransformerMap: MutableMap<String, ViewPager2.PageTransformer?> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        mVpPager = findViewById<View>(R.id.vp_pager) as ViewPager2
        mBtnChangeTransformer = findViewById<View>(R.id.btn_change_transformer) as Button
        mBtnChangeTransformer!!.setOnClickListener(this)
        mVpPager!!.setPageTransformer(DefaultTransformer())
        mVpPager!!.adapter = object : RecyclerView.Adapter<MyViewHolder>() {
            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): MyViewHolder {
                val page = FrameLayout(this@MainActivity).apply {
                    layoutParams = RecyclerView.LayoutParams(-1, -1)
                }
                return MyViewHolder(page)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.textView.text = String.format(Locale.getDefault(), "Page %d", position + 1)
            }

            override fun getItemCount(): Int {
                return 10
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
        mTransformerMap["ScaleTransformer"] = ScaleTransformer()
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
            "ScaleTransformer",
            "StackTransformer",
            "TabletTransformer",
            "VerticalTransformer",
            "ZoomInTransformer",
            "ZoomOutPageTransformer",
            "ZoomOutSlideTransformer",
            "ZoomOutTransformer"
        )
        bottomSheetDialog = StytledDialog.showBottomItemDialog(
            this@MainActivity,
            strings,
            "cancel",
            true,
            true,
            object : MyItemDialogListener() {
                override fun onItemClick(text: String, position: Int) {
                    Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
                    if (mTransformerMap[text] != null) {
                        mVpPager!!.setPageTransformer(mTransformerMap[text])
                    }
                }

                override fun onBottomBtnClick() {}
            })
        bottomSheetDialog!!.dismiss()
    }

    internal class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView = TextView(view.context)

        init {
            val bg = Color.rgb(
                floor(Math.random() * 128).toInt() + 64,
                floor(Math.random() * 128).toInt() + 64,
                floor(Math.random() * 128).toInt() + 64
            )
            textView.setBackgroundColor(bg)
            textView.gravity = Gravity.CENTER
            textView.textSize = 30f
            textView.setTextColor(Color.WHITE)
            textView.tag = OverspreadTransformer.TAG_PARALLAX
            (view as FrameLayout).addView(textView)
            (textView.layoutParams as FrameLayout.LayoutParams).apply {
                width = FrameLayout.LayoutParams.MATCH_PARENT
                height = FrameLayout.LayoutParams.MATCH_PARENT
                gravity = Gravity.CENTER
            }
        }
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