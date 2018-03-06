package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wan.gameditor.R;
import com.wan.gameditor.activity.CurrentActivity;
import com.wan.utils.AlreadyEquipment;
import com.wan.utils.EquipmentResult;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowEquipmentPropertyFragment extends Fragment {

    private EquipmentResult temp;

    private TextView mName;
    private TextView mEquipmentLevel;
    private TextView mType;
    private TextView mLive;
    private TextView mMagicAttack;
    private TextView mAttack;
    private TextView mDefence;
    private TextView mDuck;
    private TextView mSpeed;
    private TextView mStrength;
    private TextView mIntelligence;
    private TextView mSpirit;
    private TextView mQuick;
    private TextView mExtraSkill;
    private TextView mSpecialEfficiency;
    private TextView mRequiredLevel;
    private ImageView cancel;
    private Button zuangbei;
    private boolean isChoose;
    private static final String HEAD = "头饰";
    private static final String SHIELD = "防具";
    private static final String SWORD = "武器";
    private static final String WING = "背饰";
    private static final String NECKLACE = "项链";
    private static final String BELT = "腰部装饰";
    private static final String CLOTHES = "衣服";
    private static final String PANT = "下装";
    private static final String GEMSTONE = "宝石";
    private static final String RING = "戒指";
    private static final String SHOES = "战靴";
    private static final String BRACELET = "手饰";

    public static ShowEquipmentPropertyFragment newInstance(EquipmentResult temp,boolean b){
        ShowEquipmentPropertyFragment showEquipmentPropertyFragment = new ShowEquipmentPropertyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("EquipmentResult",temp);
        bundle.putBoolean("isChoose",b);
        showEquipmentPropertyFragment.setArguments(bundle);
        return showEquipmentPropertyFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        temp = bundle.getParcelable("EquipmentResult");
        isChoose = bundle.getBoolean("isChoose");


    }

    public ShowEquipmentPropertyFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_show_equipment_property, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        setText();
    }
    private void initView(View v) {
       cancel = (ImageView)v.findViewById(R.id.show_cancel);

       cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChoose){
                    removeFragment();
                }else {
                    removeFragmentforGetOff();
                }

            }
        });

        zuangbei=(Button)v.findViewById(R.id.zuangbei);
        if (!isChoose){
            zuangbei.setVisibility(View.INVISIBLE);
        }
        zuangbei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    putOn();
            }
        });

        mName = (TextView) v.findViewById(R.id.name);
        mEquipmentLevel = (TextView)v.findViewById(R.id.equipment_level);
        mType = (TextView)v.findViewById(R.id.type);
        mMagicAttack = (TextView)v.findViewById(R.id.magic_attack);
        mAttack = (TextView)v.findViewById(R.id.attack);
        mDefence = (TextView)v.findViewById(R.id.defence);
        mDuck = (TextView)v.findViewById(R.id.duck);
        mSpeed = (TextView)v.findViewById(R.id.speed);
        mStrength = (TextView)v.findViewById(R.id.strength);
        mIntelligence = (TextView) v.findViewById(R.id.intelligence);
        mSpirit = (TextView)v.findViewById(R.id.spirit);
        mQuick = (TextView)v.findViewById(R.id.quick);
        mExtraSkill = (TextView)v.findViewById(R.id.extra_skill);
        mSpecialEfficiency = (TextView)v.findViewById(R.id.special_efficiency);
        mRequiredLevel = (TextView)v.findViewById(R.id.required_level);
        mLive  = (TextView)v.findViewById(R.id.live);


    }
    private void setText(){

        mName.setText(temp.getName());
        mType.setText(temp.getType());
        mEquipmentLevel.setText(temp.getLevel());

        mLive.setText(String.valueOf(temp.getLive()));
        mMagicAttack.setText(String.valueOf(temp.getMagic_attack()));
        mAttack.setText(String.valueOf(temp.getAttack()));
        mDefence.setText(String.valueOf(temp.getDefence()));
        mDuck.setText(String.valueOf(temp.getDuck()));
        mSpeed.setText(String.valueOf(temp.getSpeed()));
        mStrength.setText(String.valueOf(temp.getStrength()));
        mIntelligence.setText(String.valueOf(temp.getIntelligence()));
        mSpirit.setText(String.valueOf(temp.getSpirit()));
        mQuick.setText(String.valueOf(temp.getQuick()));

        mExtraSkill.setText(temp.getExtra_skill());
        mSpecialEfficiency.setText(temp.getSpecial_efficiency());
        mRequiredLevel.setText(temp.getRequired_level());

    }
    private void putOn(){
        set();

    }

    private void set(){

        switch (temp.getType()){
            case HEAD:
                addAlreadyEquipment(HEAD);

                break;
            case SHIELD:
                addAlreadyEquipment(SHIELD);

                break;
            case BELT:

                addAlreadyEquipment(BELT);
                break;
            case BRACELET:
                addAlreadyEquipment(BRACELET);
                break;
            case CLOTHES:

                addAlreadyEquipment(CLOTHES);
                break;
            case GEMSTONE:

                addAlreadyEquipment(GEMSTONE);
                break;
            case NECKLACE:

                addAlreadyEquipment(NECKLACE);
                break;
            case PANT:
                addAlreadyEquipment(PANT);
                break;
            case RING:
                addAlreadyEquipment(RING);
                break;
            case SHOES:
                addAlreadyEquipment(SHOES);
                break;
            case SWORD:
                addAlreadyEquipment(SWORD);
                break;
            case WING:
                addAlreadyEquipment(WING);
                break;
            default:
                break;
        }
        Toast.makeText(getActivity(), "成功装备！", Toast.LENGTH_SHORT).show();
        removeFragment();

    }

    private void addAlreadyEquipment(String s) {
        List<AlreadyEquipment> list = DataSupport.where("type = ?",s).find(AlreadyEquipment.class);
       for (AlreadyEquipment e:list){
           if (e.getType().equals(s)){
               e.setName(temp.getName());
               e.save();
           }
       }
    }

    private void removeFragmentforGetOff(){
        CurrentActivity currentActivity = (CurrentActivity)getActivity();
        FragmentManager manager = getFragmentManager();
        currentActivity.getEquipmentFragment().removeFragment();

    }
    private void removeFragment(){
        CurrentActivity currentActivity = (CurrentActivity)getActivity();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ChooseEquipmentFragment fragment = (ChooseEquipmentFragment) currentActivity.getEquipmentFragment().getChooseEquipmentFragment();
        transaction.remove(fragment.getShowEquipmentPropertyFragment()).commit();
    }
}
