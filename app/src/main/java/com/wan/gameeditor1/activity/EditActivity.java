package com.wan.gameeditor1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.wan.gameeditor1.R;
import com.wan.gameeditor1.utils.EquipmentResult;

import org.litepal.crud.DataSupport;

public class EditActivity extends Activity implements View.OnClickListener {

    private EditText mEditName;
    private EditText mEditEquipmentLevel;
    private EditText mEditType;
    private EditText mEditLive;

    private EditText mEditAttack;
    private EditText mEditDefence;
    private EditText mEditDuck;
    private EditText mEditSpeed;
    private EditText mEditStrength;
    private EditText mEditIntelligence;
    private EditText mEditSpirit;
    private EditText mEditQuick;
    private EditText mEditExtraSkill;
    private EditText mEditSpecialEfficiency;

    /**
     * 添加新装备
     */
    private Button mAlreadyNewEquipment;
    private EditText mMagicAttack;
    private EditText mRequiredLevel;
    private Spinner mSpinner;

    private String name;
    private String type;
    private String required_level;
    private String level;
    private String extra_skill;
    private String special_efficiency;
    private int attack;
    private int defence;
    private int live;
    private int speed;
    private int duck;
    private int magic_attack;
    private int strength;
    private int spirit;
    private int intelligence;
    private int quick;
    private Intent intent;
    String s;
    private  EquipmentResult equipmentResult;
    /**
     * 保存修改
     */
    private Button mEditEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();

        intent = getIntent();
        boolean flag;
        if (intent.getIntExtra("flag", 0) == 0) {
            s = intent.getStringExtra("type");
            mEditType.setText(s);
            flag=true;
            showview(flag, null);
        } else {
            equipmentResult = intent.getParcelableExtra("r");

            flag = false;
            showview(flag, equipmentResult);
        }


    }

    private void setData() {
        EquipmentResult result = new EquipmentResult();
        result.setName(name);
        result.setAttack(attack);
        result.setDefence(defence);
        result.setDuck(duck);
        result.setExtra_skill(extra_skill);
        result.setIntelligence(intelligence);
        result.setLevel(level);
        result.setLive(live);
        result.setMagic_attack(magic_attack);
        result.setQuick(quick);
        result.setRequired_level(required_level);
        result.setSpecial_efficiency(special_efficiency);
        result.setSpeed(speed);
        result.setType(type);
        result.setSpirit(spirit);
        result.setStrength(strength);
        result.save();

    }

    private void getData() {
        name = mEditName.getText().toString();
        required_level = mRequiredLevel.getText().toString();

        type = mEditType.getText().toString();

        level = mEditEquipmentLevel.getText().toString();

        extra_skill = mEditExtraSkill.getText().toString();
        special_efficiency = mEditSpecialEfficiency.getText().toString();

        attack = Integer.valueOf(mEditAttack.getText().toString());
        defence = Integer.valueOf(mEditDefence.getText().toString());
        live = Integer.valueOf(mEditLive.getText().toString());
        speed = Integer.valueOf(mEditSpeed.getText().toString());
        duck = Integer.valueOf(mEditDuck.getText().toString());

        magic_attack = Integer.valueOf(mMagicAttack.getText().toString());
        strength = Integer.valueOf(mEditStrength.getText().toString());
        spirit = Integer.valueOf(mEditSpirit.getText().toString());
        intelligence = Integer.valueOf(mEditIntelligence.getText().toString());
        quick = Integer.valueOf(mEditQuick.getText().toString());
    }

    private void showview(boolean flag, EquipmentResult equipmentResult) {

        if (flag) {
            mEditLive.setText("0");
            mEditDefence.setText("0");
            mEditAttack.setText("0");
            mEditDuck.setText("0");
            mEditSpeed.setText("0");
            mEditStrength.setText("0");
            mEditIntelligence.setText("0");
            mEditSpirit.setText("0");
            mEditQuick.setText("0");
            mEditExtraSkill.setText("无");
            mEditSpecialEfficiency.setText("无");
            mMagicAttack.setText("0");
            mRequiredLevel.setText("无");

        } else {
            mAlreadyNewEquipment.setVisibility(View.GONE);
            mEditEquipment.setVisibility(View.VISIBLE);
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
    }


    private void initView() {
        mEditName = (EditText) findViewById(R.id.edit_name);

        mEditEquipmentLevel = (EditText) findViewById(R.id.edit_equipment_level);

        mEditType = (EditText) findViewById(R.id.edit_type);

        mEditLive = (EditText) findViewById(R.id.edit_live);

        mEditAttack = (EditText) findViewById(R.id.edit_attack);
        mEditDefence = (EditText) findViewById(R.id.edit_defence);
        mEditDuck = (EditText) findViewById(R.id.edit_duck);
        mEditSpeed = (EditText) findViewById(R.id.edit_speed);
        mEditStrength = (EditText) findViewById(R.id.edit_strength);
        mEditIntelligence = (EditText) findViewById(R.id.edit_intelligence);
        mEditSpirit = (EditText) findViewById(R.id.edit_spirit);
        mEditQuick = (EditText) findViewById(R.id.edit_quick);
        mEditExtraSkill = (EditText) findViewById(R.id.edit_extra_skill);
        mEditSpecialEfficiency = (EditText) findViewById(R.id.edit_special_efficiency);

        mAlreadyNewEquipment = (Button) findViewById(R.id.already_new_equipment);
        mAlreadyNewEquipment.setOnClickListener(this);

        mMagicAttack = (EditText) findViewById(R.id.magic_attack);
        mRequiredLevel = (EditText) findViewById(R.id.required_level);


        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) mSpinner.getSelectedItem();
                mEditEquipmentLevel.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                String str = "白色装备";
                mEditEquipmentLevel.setText(str);


            }
        });
        mEditEquipment = (Button) findViewById(R.id.edit_equipment);
        mEditEquipment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.already_new_equipment:
                getData();
                setData();
                Toast.makeText(this, "已添加新装备", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this, NewActivity.class);
                finish();
                startActivity(intent);
                break;

            case R.id.edit_equipment:
                DataSupport.deleteAll(EquipmentResult.class,"name = ? and type = ?",equipmentResult.getName(),equipmentResult.getType());
                getData();
                setData();
                Toast.makeText(this, "成功保存", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(EditActivity.this, ShownameActivity.class);
                finish();
                startActivity(intent1);
                break;

            default:
                break;
        }
    }


}
