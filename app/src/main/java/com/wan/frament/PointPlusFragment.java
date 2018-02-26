package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wan.gameditor.R;
import com.wan.gameditor.activity.CurrentActivity;
import com.wan.utils.PersonProperty;
import com.wan.utils.PointDuiYing;
import com.wan.utils.PointPlused;

import org.litepal.crud.DataSupport;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointPlusFragment extends Fragment implements View.OnClickListener {



    private TextView mPlusStrength,mPlusSpirit,mPlusQuick,mPlusDefence,mPlusIntelligence;
    private ImageView   mMinusQuickBtn,mPlusStrengthBtn,mMinusStrengthBtn,mPlusSpiritBtn,mMinusSpiritBtn,
            mPlusQuickBtn,mPlusIntelligenceBtn,mMinusIntelligenceBtn,mPlusDefenceBtn,mMinusDefenceBtn;
    private TextView showLevel,showPoint;
    private EditText edDuck,edAttack,edLive,edMagic,edDefence,edSpeed,edLevel;
    private Button buttonEditPoint,savebtn;
    private String Level,PointSurplus;
    private boolean isExist,iseditTextOn=false;
    private int temp_strength,temp_quick,temp_defence,temp_spirit,temp_intelligence,showpoints;
    private static final int STRENGTH=1;
    private static final int QUICK=2;
    private static final int DEFENCE=3;
    private static final int SPIRIT=4;
    private static final int INTELLIGENCE=5;


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
        if(!DataSupport.isExist(PointPlused.class)){
            PointPlused pointplused = new PointPlused();
            pointplused.setSpirit(0);
            pointplused.setQuick(0);
            pointplused.setStrength(0);
            pointplused.setIntelligence(0);
            pointplused.setDefence(0);
            pointplused.save();
        }
        if(!DataSupport.isExist(PointDuiYing.class)){
            PointDuiYing pointduiying = new PointDuiYing();
            pointduiying.setSpeed(5);
            pointduiying.setAttack(4);
            pointduiying.setDuck(3);
            pointduiying.setDefence(2);
            pointduiying.setMagic(20);
            pointduiying.setLive(20);
            pointduiying.setLevel(5);
            pointduiying.save();
        }

        Bundle bundle = getArguments();
        showpoints=bundle.getInt("PointSurplus");
        Log.d("OnCreate",""+showpoints);
        isExist = bundle.getBoolean("isExist");
        if(isExist){
            Level = String.valueOf(bundle.getInt("Level"));
            PointSurplus = String.valueOf(showpoints);
            Log.d("OnCreate",PointSurplus);
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
        
        buttonEditPoint = (Button)view.findViewById(R.id.edit_point);
        buttonEditPoint.setOnClickListener(this);

        savebtn = (Button)view.findViewById(R.id.btn_save);
        savebtn.setOnClickListener(this);

        edAttack=(EditText)view.findViewById(R.id.ed_attack);
        edDefence=(EditText)view.findViewById(R.id.ed_defence);
        edDuck=(EditText)view.findViewById(R.id.ed_duck);
        edLive=(EditText)view.findViewById(R.id.ed_live);
        edMagic=(EditText)view.findViewById(R.id.ed_magic);
        edSpeed=(EditText)view.findViewById(R.id.ed_speed);
        edLevel=(EditText)view.findViewById(R.id.ed_level);


        PointPlused pointplused = DataSupport.findFirst(PointPlused.class);

        temp_defence = pointplused.getDefence();
        temp_intelligence = pointplused.getIntelligence();
        temp_quick = pointplused.getQuick();
        temp_spirit = pointplused.getSpirit();
        temp_strength = pointplused.getStrength();

        setText(pointplused);

        PointDuiYing pointduiying = DataSupport.findFirst(PointDuiYing.class);
        setText(pointduiying);

        if (Integer.valueOf(showPoint.getText().toString())!=0){
            mMinusQuickBtn.setVisibility(View.VISIBLE);
            mMinusQuickBtn.setOnClickListener(this);
            mPlusQuickBtn.setOnClickListener(this);
            mPlusQuickBtn.setVisibility(View.VISIBLE);
            mPlusStrengthBtn.setVisibility(View.VISIBLE);
            mPlusStrengthBtn.setOnClickListener(this);
            mMinusStrengthBtn.setOnClickListener(this);
            mMinusStrengthBtn.setVisibility(View.VISIBLE);
            mPlusSpiritBtn.setVisibility(View.VISIBLE);
            mPlusSpiritBtn.setOnClickListener(this);
            mMinusSpiritBtn.setOnClickListener(this);
            mMinusSpiritBtn.setVisibility(View.VISIBLE);
            mPlusIntelligenceBtn.setVisibility(View.VISIBLE);
            mPlusIntelligenceBtn.setOnClickListener(this);
            mMinusIntelligenceBtn.setOnClickListener(this);
            mMinusIntelligenceBtn.setVisibility(View.VISIBLE);
            mPlusDefenceBtn .setVisibility(View.VISIBLE);
            mPlusDefenceBtn.setOnClickListener(this);
            mMinusDefenceBtn.setOnClickListener(this);
            mMinusDefenceBtn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_point_plus, container, false);
    }

    public void setText(String level,String pointSurplus){
        Log.d("setText","level="+level);
        Log.d("setText","point="+PointSurplus);
        showPoint.setText(pointSurplus);
        showLevel.setText(level);
    }

    public void setText(PointDuiYing p){
        edMagic.setText(String.valueOf(p.getMagic()));
        edSpeed.setText(String.valueOf(p.getSpeed()));
        edLive.setText(String.valueOf(p.getLive()));
        edDuck.setText(String.valueOf(p.getDuck()));
        edAttack.setText(String.valueOf(p.getAttack()));
        edDefence.setText(String.valueOf(p.getDefence()));
        edLevel.setText(String.valueOf(p.getLevel()));
    }

    public void setText(PointPlused p){
        mPlusQuick.setText(String.valueOf(p.getQuick()));
        mPlusStrength.setText(String.valueOf(p.getStrength()));
        mPlusSpirit.setText(String.valueOf(p.getSpirit()));
        mPlusDefence.setText(String.valueOf(p.getDefence()));
        mPlusIntelligence.setText(String.valueOf(p.getIntelligence()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus_strength_btn:
                plus(STRENGTH);
                break;
            case R.id.minus_strength_btn:
                minus(STRENGTH);
                break;
            case R.id.plus_quick_btn:
                plus(QUICK);
                break;
            case R.id.minus_quick_btn:
                minus(QUICK);
                break;
            case R.id.plus_defence_btn:
                plus(DEFENCE);
                break;
            case R.id.minus_defence_btn:
                minus(DEFENCE);
                break;
            case R.id.plus_intelligence_btn:
                plus(INTELLIGENCE);
                break;
            case R.id.minus_intelligence_btn:
                minus(INTELLIGENCE);
                break;
            case R.id.plus_spirit_btn:
                plus(SPIRIT);
                break;
            case R.id.minus_spirit_btn:
                minus(SPIRIT);
                break;
            case R.id.edit_point:
                changeEditTextEnable();
                break;
            case R.id.btn_save:
                PointPlused pointPlused = new PointPlused();

                //下面的五个判断的目的是当加点的某一项为0时，使用setToDefault方法将pointPlused的该项设置为0,不为0则获得该内容
                if (Integer.valueOf(mPlusDefence.getText().toString()) == 0) {
                    pointPlused.setToDefault("defence");
                }else{
                    pointPlused.setDefence(Integer.valueOf(mPlusDefence.getText().toString()));
                }

                if (Integer.valueOf(mPlusSpirit.getText().toString()) == 0) {
                    pointPlused.setToDefault("spirit");
                }else{
                    pointPlused.setSpirit(Integer.valueOf(mPlusSpirit.getText().toString()));
                }

                if (Integer.valueOf(mPlusIntelligence.getText().toString()) == 0) {
                    pointPlused.setToDefault("intelligence");
                }else{
                    pointPlused.setIntelligence(Integer.valueOf(mPlusIntelligence.getText().toString()));
                }

                if (Integer.valueOf(mPlusStrength.getText().toString()) == 0) {
                    pointPlused.setToDefault("strength");
                }else{
                    pointPlused.setStrength(Integer.valueOf(mPlusStrength.getText().toString()));
                }

                if (Integer.valueOf(mPlusQuick.getText().toString()) == 0) {
                    pointPlused.setToDefault("quick");
                }else{
                    pointPlused.setQuick(Integer.valueOf(mPlusQuick.getText().toString()));
                }
                
                PointPlused old = DataSupport.findFirst(PointPlused.class);
                PointPlused temp = pointPlused;
                PersonProperty personProperty = DataSupport.findFirst(PersonProperty.class);
                PointDuiYing pointduiying = DataSupport.findFirst(PointDuiYing.class);

                //下面五个判断的目的是比较pointPlused的某一项是否发生了变化，如果发生了变化则进行计算并设置
                if (!pointPlused.compareStrength(old)){
                    personProperty.setAttack(personProperty.getAttack() + temp.getStrength() * pointduiying.getAttack());
                }

                if(!pointPlused.compareDefence(old)){
                    personProperty.setDefence(personProperty.getDefence() +  temp.getDefence() * pointduiying.getDefence());
                }

                if(!pointPlused.compareIntelligence(old)){
                    personProperty.setMagic(personProperty.getMagic() + temp.getIntelligence() * pointduiying.getMagic());
                }

                if(!pointPlused.compareQuick(old)){
                    personProperty.setDuck(personProperty.getDuck() + temp.getQuick() * pointduiying.getDuck());
                    personProperty.setSpeed(personProperty.getSpeed() + temp.getQuick() * pointduiying.getSpeed());
                }

                if(!pointPlused.compareSpirit(old)){
                    personProperty.setLive(personProperty.getLive() + temp.getSpirit() * pointduiying.getLive());
                }

                //此判断的作用就是防止用户再没有进行加点的情况，点击保存按钮使得数据发生改变
                if (!pointPlused.compare(old)){

                    pointPlused.updateAll();
                    //实时更新CurrentActivity中的ShowProperty Fragment
                    CurrentActivity activity = (CurrentActivity)getActivity();

                    Log.d("Test","-----live="+personProperty.getLive());
                    Log.d("Test","-----magic="+personProperty.getMagic());
                    Log.d("Test","-----duck="+personProperty.getDuck());
                    Log.d("Test","-----attack="+personProperty.getAttack());
                    Log.d("Test","-----defence="+personProperty.getDefence());
                    personProperty.updateAll();
                    activity.updateShowProperty(personProperty);
                }

                break;
            default:break;
        }
    }

    public void changeEditTextEnable(){
        boolean b = iseditTextOn;
        if (!b){
            edSpeed.setEnabled(!b);
            edMagic.setEnabled(!b);
            edLive.setEnabled(!b);
            edDuck.setEnabled(!b);
            edAttack.setEnabled(!b);
            edDefence.setEnabled(!b);
            edLevel.setEnabled(!b);
            buttonEditPoint.setText("保存");
            iseditTextOn = true;
        }else{
            edSpeed.setEnabled(!b);
            edMagic.setEnabled(!b);
            edLive.setEnabled(!b);
            edDuck.setEnabled(!b);
            edAttack.setEnabled(!b);
            edDefence.setEnabled(!b);
            edLevel.setEnabled(!b);
            buttonEditPoint.setText("修改点数对应数值");
            PointDuiYing temp = new PointDuiYing();
            temp.setLevel(Integer.valueOf(edLevel.getText().toString()));
            temp.setDefence(Integer.valueOf(edDefence.getText().toString()));
            temp.setAttack(Integer.valueOf(edAttack.getText().toString()));
            temp.setDuck(Integer.valueOf(edDuck.getText().toString()));
            temp.setLive(Integer.valueOf(edLive.getText().toString()));
            temp.setMagic(Integer.valueOf(edMagic.getText().toString()));
            temp.setSpeed(Integer.valueOf(edSpeed.getText().toString()));
            temp.updateAll();

            iseditTextOn = false;
        }
    }

    public void plus(int i){

        showpoints = Integer.valueOf(showPoint.getText().toString());
        Log.d("Onclick",mPlusDefence.getText().toString());
        if (showpoints==0){
            Toast.makeText(getActivity(), "加点完成记得保存哦！", Toast.LENGTH_SHORT).show();
        }else {
            showpoints--;
            PointSurplus = String.valueOf(showpoints);
            Log.d("onClickPlus",PointSurplus);
            showPoint.setText(PointSurplus);
            Log.d("Onclick",showPoint.getText().toString());

            switch (i){
                case STRENGTH:
                    temp_strength++;
                    mPlusStrength.setText(String.valueOf(temp_strength));
                    break;
                case QUICK:
                    temp_quick++;
                    mPlusQuick.setText(String.valueOf(temp_quick));
                    break;
                case INTELLIGENCE:
                    temp_intelligence++;
                    mPlusIntelligence.setText(String.valueOf(temp_intelligence));
                    break;
                case SPIRIT:
                    temp_spirit++;
                    mPlusSpirit.setText(String.valueOf(temp_spirit));
                    break;
                case DEFENCE:
                    temp_defence++;
                    mPlusDefence.setText(String.valueOf(temp_defence));
                    break;
                default:break;

            }
        }

    }

    public void minus(int i){
        showpoints = Integer.valueOf(showPoint.getText().toString());
        showpoints++;
        PointSurplus = String.valueOf(showpoints);
        showPoint.setText(PointSurplus);
        switch (i){
            case STRENGTH:
                temp_strength--;
                mPlusStrength.setText(String.valueOf(temp_strength));
                break;
            case QUICK:
                temp_quick--;
                mPlusQuick.setText(String.valueOf(temp_quick));
                break;
            case INTELLIGENCE:
                temp_intelligence--;
                mPlusIntelligence.setText(String.valueOf(temp_intelligence));
                break;
            case SPIRIT:
                temp_spirit--;
                mPlusSpirit.setText(String.valueOf(temp_spirit));
                break;
            case DEFENCE:
                temp_defence--;
                mPlusDefence.setText(String.valueOf(temp_defence));
                break;
            default:break;
        }
    }
}
