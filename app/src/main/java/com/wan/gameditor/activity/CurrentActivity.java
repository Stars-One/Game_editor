package com.wan.gameditor.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wan.frament.EquipmentFragment;
import com.wan.frament.PointPlusFragment;
import com.wan.frament.PropertyFragment;
import com.wan.gameditor.R;
import com.wan.utils.MyfragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class CurrentActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewpager;
    private ImageView mImageViewProperty;
    private LinearLayout mLinearLayoutProperty;
    private ImageView mImageViewEquipment;
    private LinearLayout mLinearLayoutEquipment;
    private List<Fragment> mlist;
    private int colorblue, colorgrey;
    private Fragment propertyFragment, equipmentFragment, pointplusFragment;
    private ImageView mImageViewPointPlus;
    private LinearLayout mLinearLayoutPointPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        initView();

        mViewpager.setAdapter(new MyfragmentAdapter(getSupportFragmentManager(), mlist));
        ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override

            public void onPageSelected(int position) {

                switch (position) {

                    case 0:
                        mImageViewProperty.setBackgroundColor(colorblue);
                        mImageViewEquipment.setBackgroundColor(colorgrey);
                        mImageViewPointPlus.setBackgroundColor(colorgrey);
                        break;
                    case 1:
                        mImageViewProperty.setBackgroundColor(colorgrey);
                        mImageViewEquipment.setBackgroundColor(colorblue);
                        mImageViewPointPlus.setBackgroundColor(colorgrey);
                        break;
                    case 2:
                        mImageViewProperty.setBackgroundColor(colorgrey);
                        mImageViewEquipment.setBackgroundColor(colorgrey);
                        mImageViewPointPlus.setBackgroundColor(colorblue);
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        mViewpager.addOnPageChangeListener(listener);

    }

    @TargetApi(23)
    public int handldeColorOn(int colorid) {
        return getResources().getColor(colorid, null);
    }

    public int handleColorBefore(int colorid) {
        return getResources().getColor(colorid);

    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mImageViewProperty = (ImageView) findViewById(R.id.imageViewProperty);
        mLinearLayoutProperty = (LinearLayout) findViewById(R.id.linearLayoutProperty);
        mLinearLayoutProperty.setOnClickListener(this);
        mImageViewEquipment = (ImageView) findViewById(R.id.imageViewEquipment);
        mLinearLayoutEquipment = (LinearLayout) findViewById(R.id.linearLayoutEquipment);
        mLinearLayoutEquipment.setOnClickListener(this);

        mlist = new ArrayList<>();
        propertyFragment = new PropertyFragment();
        equipmentFragment = new EquipmentFragment();
        pointplusFragment = new PointPlusFragment();

        mlist.add(propertyFragment);
        mlist.add(equipmentFragment);
        mlist.add(pointplusFragment);

        if (Build.VERSION.SDK_INT <= 23) {
            colorblue = handleColorBefore(R.color.colorblue);
            colorgrey = handleColorBefore(R.color.colorgrey);
        } else {
            colorblue = handldeColorOn(R.color.colorblue);
            colorgrey = handldeColorOn(R.color.colorgrey);
        }
        mImageViewPointPlus = (ImageView) findViewById(R.id.imageViewPointPlus);
        mLinearLayoutPointPlus = (LinearLayout) findViewById(R.id.linearLayoutPointPlus);
        mLinearLayoutPointPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearLayoutProperty:
                mImageViewProperty.setBackgroundColor(colorblue);
                mImageViewEquipment.setBackgroundColor(colorgrey);
                mImageViewPointPlus.setBackgroundColor(colorgrey);
                mViewpager.setCurrentItem(0);
                break;
            case R.id.linearLayoutEquipment:
                mImageViewProperty.setBackgroundColor(colorgrey);
                mImageViewEquipment.setBackgroundColor(colorblue);
                mImageViewPointPlus.setBackgroundColor(colorgrey);
                mViewpager.setCurrentItem(1);
                break;
            default:
                break;
            case R.id.linearLayoutPointPlus:
                mImageViewProperty.setBackgroundColor(colorgrey);
                mImageViewEquipment.setBackgroundColor(colorgrey);
                mImageViewPointPlus.setBackgroundColor(colorblue);
                mViewpager.setCurrentItem(2);
                break;
        }
    }
}
