package com.wan.gameeditor1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wan.gameeditor1.R;

/**
 * @author stars-one
 */
public class NewActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initView();


    }

    private void initView() {
        /*
      武器
     */
        Button mNewSword = (Button) findViewById(R.id.new_sword);
        mNewSword.setOnClickListener(this);
        /*
      防具
     */
        Button mNewShield = (Button) findViewById(R.id.new_shield);
        mNewShield.setOnClickListener(this);
        /*
      头饰
     */
        Button mNewHead = (Button) findViewById(R.id.new_head);
        mNewHead.setOnClickListener(this);
        /*
      衣服
     */
        Button mNewClothes = (Button) findViewById(R.id.new_clothes);
        mNewClothes.setOnClickListener(this);
        /*
      下装
     */
        Button mNewPant = (Button) findViewById(R.id.new_pant);
        mNewPant.setOnClickListener(this);
        /*
      腰部装饰
     */
        Button mNewBelt = (Button) findViewById(R.id.new_belt);
        mNewBelt.setOnClickListener(this);
        /*
      战靴
     */
        Button mNewShoes = (Button) findViewById(R.id.new_shoes);
        mNewShoes.setOnClickListener(this);
        /*
      宝石
     */
        Button mNewGemstone = (Button) findViewById(R.id.new_gemstone);
        mNewGemstone.setOnClickListener(this);
        /*
      背饰
     */
        Button mNewWing = (Button) findViewById(R.id.new_wing);
        mNewWing.setOnClickListener(this);
        /*
      手饰
     */
        Button mNewBracelet = (Button) findViewById(R.id.new_bracelet);
        mNewBracelet.setOnClickListener(this);
        /*
      戒指
     */
        Button mNewRing = (Button) findViewById(R.id.new_ring);
        mNewRing.setOnClickListener(this);


        /*
      项链
     */
        Button mNewNecklace = (Button) findViewById(R.id.new_necklace);
        mNewNecklace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.new_sword:

                enterEditActivity("武器");
                break;
            case R.id.new_shield:
                enterEditActivity("防具");
                break;
            case R.id.new_head:
                enterEditActivity("头饰");
                break;
            case R.id.new_clothes:
                enterEditActivity("衣服");
                break;
            case R.id.new_pant:
                enterEditActivity("下装");
                break;
            case R.id.new_belt:
                enterEditActivity("腰部装饰");
                break;
            case R.id.new_shoes:
                enterEditActivity("战靴");
                break;
            case R.id.new_gemstone:
                enterEditActivity("宝石");
                break;
            case R.id.new_wing:
                enterEditActivity("背饰");
                break;
            case R.id.new_bracelet:
                enterEditActivity("手饰");
                break;
            case R.id.new_ring:
                enterEditActivity("戒指");
                break;
            case R.id.new_necklace:
                enterEditActivity("项链");
                break;
            default:
                break;
        }
    }

    private void enterEditActivity(String type) {
        Intent intent = new Intent(NewActivity.this, EditActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("flag",0);

        finish();

        startActivity(intent);

    }


}
