package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wan.gameditor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointPlusFragment extends Fragment {



    private TextView mPlusStrength,mPlusSpirit,mPlusQuick,mPlusDefence,mPlusIntelligence;
    private ImageView   mMinusQuickBtn,mPlusStrengthBtn,mMinusStrengthBtn,mPlusSpiritBtn,mMinusSpiritBtn,
            mPlusQuickBtn,mPlusIntelligenceBtn,mMinusIntelligenceBtn,mPlusDefenceBtn,mMinusDefenceBtn;
    private TextView showLevel,showPoint;
    private String Level,PointSurplus;
    private boolean isExist;
    public static PointPlusFragment newInstance(int level,int pointsruplus,boolean isExist){
        PointPlusFragment pointPlusFragment = new PointPlusFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("PointSurplus",pointsruplus);
        bundle.putInt("Level",level);
        bundle.putBoolean("isExist",isExist);
        pointPlusFragment.setArguments(bundle);
        return pointPlusFragment;
    }
    public PointPlusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        isExist = bundle.getBoolean("isExist");
        if(isExist){
            Level = String.valueOf(bundle.getInt("Level"));
            PointSurplus = String.valueOf(bundle.getInt("PointSurplus"));
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mMinusQuickBtn = (ImageView) view.findViewById(R.id.minus_quick_btn);
        mPlusQuickBtn= (ImageView) view.findViewById(R.id.plus_quick_btn);
        mPlusStrengthBtn= (ImageView) view.findViewById(R.id.plus_strength_btn);
        mMinusStrengthBtn= (ImageView) view.findViewById(R.id.minus_strength_btn);
        mPlusSpiritBtn= (ImageView) view.findViewById(R.id.plus_spirit_btn);
        mMinusSpiritBtn= (ImageView) view.findViewById(R.id.minus_spirit_btn);
        mPlusIntelligenceBtn= (ImageView) view.findViewById(R.id.plus_intelligence_btn);
        mMinusIntelligenceBtn= (ImageView) view.findViewById(R.id.minus_intelligence_btn);
        mPlusDefenceBtn = (ImageView) view.findViewById(R.id.plus_defence_btn);
        mMinusDefenceBtn= (ImageView) view.findViewById(R.id.minus_defence_btn);
        mPlusStrength = (TextView)view.findViewById(R.id.plus_strength);
        mPlusSpirit= (TextView)view.findViewById(R.id.plus_spirit);
        mPlusQuick= (TextView)view.findViewById(R.id.plus_quick);
        mPlusDefence= (TextView)view.findViewById(R.id.plus_defence);
        mPlusIntelligence= (TextView)view.findViewById(R.id.plus_intelligence);
        showLevel = (TextView)view.findViewById(R.id.showLevel);
        showPoint = (TextView)view.findViewById(R.id.showPoint);
        if (isExist){
            setText(PointSurplus,Level);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_point_plus, container, false);
    }
    public void setText(String level,String pointSurplus){
        showPoint.setText(pointSurplus);
        showLevel.setText(level);
    }
}
