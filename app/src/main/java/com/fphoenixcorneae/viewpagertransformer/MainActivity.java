package com.fphoenixcorneae.viewpagertransformer;

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
import android.widget.TextView;
import android.widget.Toast;

import com.hss01248.lib.MyItemDialogListener;
import com.hss01248.lib.StytledDialog;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVpPager;
    Dialog bottomSheetDialog;
    /**
     * 切换转换效果
     */
    private Button mBtnChangeTransformer;

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
        mVpPager.setPageMargin(30);
        mVpPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView mText = new TextView(MainActivity.this);
                int bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                mText.setBackgroundColor(bg);
                mText.setGravity(Gravity.CENTER);
                mText.setText(String.format(Locale.getDefault(), "Page %d", position + 1));
                mText.setTextSize(30);
                mText.setTextColor(Color.WHITE);

                container.addView(mText, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                return mText;
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
        final List<String> strings = Arrays.asList("AccordionTransformer",
                "BackgroundToForegroundTransformer",
                "CubeInTransformer",
                "CubeOutTransformer",
                "DefaultTransformer",
                "DepthPageTransformer",
                "FlipHorizontalTransformer",
                "FlipVerticalTransformer",
                "ForegroundToBackgroundTransformer",
                "RotateDownTransformer",
                "RotateUpTransformer",
                "ScaleInOutTransformer",
                "StackTransformer",
                "TabletTransformer",
                "ZoomInTransformer",
                "ZoomOutSlideTransformer",
                "ZoomOutTransformer");

        bottomSheetDialog = StytledDialog.showBottomItemDialog(MainActivity.this, strings, "cancel", true, true, new MyItemDialogListener() {
            @Override
            public void onItemClick(String text, int position) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        mVpPager.setPageTransformer(true, new AccordionTransformer());
                        break;
                    case 1:
                        mVpPager.setPageTransformer(true, new BackgroundToForegroundTransformer());
                        break;
                    case 2:
                        mVpPager.setPageTransformer(true, new CubeInTransformer());
                        break;
                    case 3:
                        mVpPager.setPageTransformer(true, new CubeOutTransformer());
                        break;
                    case 4:
                        mVpPager.setPageTransformer(true, new DefaultTransformer());
                        break;
                    case 5:
                        mVpPager.setPageTransformer(true, new DepthPageTransformer());
                        break;
                    case 6:
                        mVpPager.setPageTransformer(true, new FlipHorizontalTransformer());
                        break;
                    case 7:
                        mVpPager.setPageTransformer(true, new FlipVerticalTransformer());
                        break;
                    case 8:
                        mVpPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());
                        break;
                    case 9:
                        mVpPager.setPageTransformer(true, new RotateDownTransformer());
                        break;
                    case 10:
                        mVpPager.setPageTransformer(true, new RotateUpTransformer());
                        break;
                    case 11:
                        mVpPager.setPageTransformer(true, new ScaleInOutTransformer());
                        break;
                    case 12:
                        mVpPager.setPageTransformer(true, new StackTransformer());
                        break;
                    case 13:
                        mVpPager.setPageTransformer(true, new TabletTransformer());
                        break;
                    case 14:
                        mVpPager.setPageTransformer(true, new ZoomInTransformer());
                        break;
                    case 15:
                        mVpPager.setPageTransformer(true, new ZoomOutSlideTransformer());
                        break;
                    case 16:
                        mVpPager.setPageTransformer(true, new ZoomOutTransformer());
                        break;
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
        }
    }
}
