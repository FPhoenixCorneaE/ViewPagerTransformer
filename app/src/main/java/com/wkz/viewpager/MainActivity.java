package com.wkz.viewpager;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hss01248.lib.MyItemDialogListener;
import com.hss01248.lib.StytledDialog;
import com.wkz.viewpager.transformer.AccordionTransformer;
import com.wkz.viewpager.transformer.BackgroundToForegroundTransformer;
import com.wkz.viewpager.transformer.CubeInTransformer;
import com.wkz.viewpager.transformer.CubeOutTransformer;
import com.wkz.viewpager.transformer.DefaultTransformer;
import com.wkz.viewpager.transformer.DepthPageTransformer;
import com.wkz.viewpager.transformer.FlipHorizontalTransformer;
import com.wkz.viewpager.transformer.FlipVerticalTransformer;
import com.wkz.viewpager.transformer.ForegroundToBackgroundTransformer;
import com.wkz.viewpager.transformer.OverspreadTransformer;
import com.wkz.viewpager.transformer.RotateDownTransformer;
import com.wkz.viewpager.transformer.RotateUpTransformer;
import com.wkz.viewpager.transformer.ScaleInOutTransformer;
import com.wkz.viewpager.transformer.StackTransformer;
import com.wkz.viewpager.transformer.TabletTransformer;
import com.wkz.viewpager.transformer.ZoomInTransformer;
import com.wkz.viewpager.transformer.ZoomOutSlideTransformer;
import com.wkz.viewpager.transformer.ZoomOutTransformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVpPager;
    Dialog bottomSheetDialog;
    /**
     * 切换转换效果
     */
    private Button mBtnChangeTransformer;
    private Map<String, ViewPager.PageTransformer> mTransformerMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVpPager = (ViewPager) findViewById(R.id.vp_pager);
        mBtnChangeTransformer = (Button) findViewById(R.id.btn_change_transformer);
        mBtnChangeTransformer.setOnClickListener(this);

        mVpPager.setPageTransformer(true, new DefaultTransformer());
        mVpPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                FrameLayout page = new FrameLayout(MainActivity.this);
                TextView mText = new TextView(MainActivity.this);
                int bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                mText.setBackgroundColor(bg);
                mText.setGravity(Gravity.CENTER);
                mText.setText(String.format(Locale.getDefault(), "Page %d", position + 1));
                mText.setTextSize(30);
                mText.setTextColor(Color.WHITE);
                mText.setTag(OverspreadTransformer.TAG_PARALLAX);

                page.addView(mText, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

                container.addView(page, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                return page;
            }

            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }
        });


        //底部弹出的带或不带取消按钮的弹窗
        mTransformerMap.put("AccordionTransformer", new AccordionTransformer());
        mTransformerMap.put("BackgroundToForegroundTransformer", new BackgroundToForegroundTransformer());
        mTransformerMap.put("CubeInTransformer", new CubeInTransformer());
        mTransformerMap.put("CubeOutTransformer", new CubeOutTransformer());
        mTransformerMap.put("DefaultTransformer", new DefaultTransformer());
        mTransformerMap.put("DepthPageTransformer", new DepthPageTransformer());
        mTransformerMap.put("FlipHorizontalTransformer", new FlipHorizontalTransformer());
        mTransformerMap.put("FlipVerticalTransformer", new FlipVerticalTransformer());
        mTransformerMap.put("ForegroundToBackgroundTransformer", new ForegroundToBackgroundTransformer());
        mTransformerMap.put("OverspreadTransformer", new OverspreadTransformer());
        mTransformerMap.put("RotateDownTransformer", new RotateDownTransformer());
        mTransformerMap.put("RotateUpTransformer", new RotateUpTransformer());
        mTransformerMap.put("ScaleInOutTransformer", new ScaleInOutTransformer());
        mTransformerMap.put("StackTransformer", new StackTransformer());
        mTransformerMap.put("TabletTransformer", new TabletTransformer());
        mTransformerMap.put("ZoomInTransformer", new ZoomInTransformer());
        mTransformerMap.put("ZoomOutSlideTransformer", new ZoomOutSlideTransformer());
        mTransformerMap.put("ZoomOutTransformer", new ZoomOutTransformer());

        final List<String> strings = Arrays.asList(
                "AccordionTransformer",
                "BackgroundToForegroundTransformer",
                "CubeInTransformer",
                "CubeOutTransformer",
                "DefaultTransformer",
                "DepthPageTransformer",
                "FlipHorizontalTransformer",
                "FlipVerticalTransformer",
                "ForegroundToBackgroundTransformer",
                "OverspreadTransformer",
                "RotateDownTransformer",
                "RotateUpTransformer",
                "ScaleInOutTransformer",
                "StackTransformer",
                "TabletTransformer",
                "ZoomInTransformer",
                "ZoomOutSlideTransformer",
                "ZoomOutTransformer"
        );

        bottomSheetDialog = StytledDialog.showBottomItemDialog(MainActivity.this, strings, "cancel", true, true, new MyItemDialogListener() {
            @Override
            public void onItemClick(String text, int position) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                if (mTransformerMap.get(text) != null) {
                    mVpPager.setPageTransformer(true, mTransformerMap.get(text));
                }
            }

            @Override
            public void onBottomBtnClick() {
            }
        });

        bottomSheetDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
            bottomSheetDialog.dismiss();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change_transformer:
                bottomSheetDialog.show();
                break;
            default:
        }
    }
}
