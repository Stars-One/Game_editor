package com.wan.gameditor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.wan.gameditor.R;
import com.wan.gameditor.utils.EquipmentResult;

/**
 * @author stars-one
 */
public class ShowActivity extends Activity {


    private TextView mEditName;
    private TextView mEditEquipmentLevel;
    private TextView mEditType;
    private TextView mEditLive;
    private TextView mMagicAttack;
    private TextView mEditAttack;
    private TextView mEditDefence;
    private TextView mEditDuck;
    private TextView mEditSpeed;
    private TextView mEditStrength;
    private TextView mEditIntelligence;
    private TextView mEditSpirit;
    private TextView mEditQuick;
    private TextView mEditExtraSkill;
    private TextView mEditSpecialEfficiency;
    private TextView mRequiredLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();


        EquipmentResult equipmentResult = getIntent().getParcelableExtra("r");

        setData(equipmentResult);
    }

    private void setData(EquipmentResult equipmentResult) {
        mEditName.setText(equipmentResult.getName());


        mEditType.setText(equipmentResult.getType());
        mEditEquipmentLevel.setText(equipmentResult.getLevel());
        mEditLive.setText(Integer.valueOf(equipmentResult.getLive()).toString());

        mMagicAttack.setText(Integer.valueOf(equipmentResult.getMagic_attack()).toString());
       mEditAttack.setText(Integer.valueOf(equipmentResult.getAttack()).toString());
        mEditDefence.setText(Integer.valueOf(equipmentResult.getDefence()).toString());
        mEditDuck.setText(Integer.valueOf(equipmentResult.getDuck()).toString());
        mEditSpeed.setText(Integer.valueOf(equipmentResult.getSpeed()).toString());
        mEditStrength.setText(Integer.valueOf(equipmentResult.getStrength()).toString());
        mEditIntelligence.setText(Integer.valueOf(equipmentResult.getIntelligence()).toString());
        mEditSpirit.setText(Integer.valueOf(equipmentResult.getSpirit()).toString());
        mEditQuick.setText(Integer.valueOf(equipmentResult.getQuick()).toString());
        mEditExtraSkill.setText(equipmentResult.getExtra_skill());
        mEditSpecialEfficiency.setText(equipmentResult.getSpecial_efficiency());
        mRequiredLevel.setText(equipmentResult.getRequired_level());

    }


    private void initView() {
        mEditName = (TextView) findViewById(R.id.edit_name);
        mEditEquipmentLevel = (TextView) findViewById(R.id.edit_equipment_level);
        mEditType = (TextView) findViewById(R.id.edit_type);
        mEditLive = (TextView) findViewById(R.id.edit_live);
        mMagicAttack = (TextView) findViewById(R.id.magic_attack);
        mEditAttack = (TextView) findViewById(R.id.edit_attack);
        mEditDefence = (TextView) findViewById(R.id.edit_defence);
        mEditDuck = (TextView) findViewById(R.id.edit_duck);
        mEditSpeed = (TextView) findViewById(R.id.edit_speed);
        mEditStrength = (TextView) findViewById(R.id.edit_strength);
        mEditIntelligence = (TextView) findViewById(R.id.edit_intelligence);
        mEditSpirit = (TextView) findViewById(R.id.edit_spirit);
        mEditQuick = (TextView) findViewById(R.id.edit_quick);
        mEditExtraSkill = (TextView) findViewById(R.id.edit_extra_skill);
        mEditSpecialEfficiency = (TextView) findViewById(R.id.edit_special_efficiency);
        mRequiredLevel = (TextView) findViewById(R.id.required_level);
    }
}
