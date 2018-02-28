package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wan.gameditor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipmentFragment extends Fragment implements View.OnClickListener {


    private static final String HEAD = "头饰";
    private static final String DEFENCE = "防具";
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

    private ImageView mImageHead;
    private ImageView mImageDefence;
    private ImageView mImageSword;
    private ImageView mImageWing;
    private ImageView mImageNecklace;
    private ImageView mImageBelt;
    private ImageView mImageClothes;
    private ImageView mImageBracelet;
    private ImageView mImagePant;
    private ImageView mImageGemstone;
    private ImageView mImageRing;
    private ImageView mImageShoes;
    private ChooseEquipmentFragment fragment;
    public EquipmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        return inflater.inflate(R.layout.fragment_equipment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mImageHead=(ImageView)view.findViewById(R.id.image_head);
        mImageDefence=(ImageView)view.findViewById(R.id.image_defence);
        mImageSword=(ImageView)view.findViewById(R.id.image_sword);
        mImageWing=(ImageView)view.findViewById(R.id.image_wing);
        mImageNecklace=(ImageView)view.findViewById(R.id.image_necklace);
        mImageBelt=(ImageView)view.findViewById(R.id.image_belt);
        mImageClothes=(ImageView)view.findViewById(R.id.image_clothes);
        mImageBracelet=(ImageView)view.findViewById(R.id.image_bracelet);
        mImagePant=(ImageView)view.findViewById(R.id.image_pant);
        mImageGemstone=(ImageView)view.findViewById(R.id.image_gemstone);
        mImageRing=(ImageView)view.findViewById(R.id.image_ring);
        mImageShoes=(ImageView)view.findViewById(R.id.image_shoes);

        mImageHead.setOnClickListener(this);
        mImageDefence.setOnClickListener(this);
        mImageSword.setOnClickListener(this);
        mImageWing.setOnClickListener(this);
        mImageNecklace.setOnClickListener(this);
        mImageBelt.setOnClickListener(this);
        mImageClothes.setOnClickListener(this);
        mImageBracelet.setOnClickListener(this);
        mImagePant.setOnClickListener(this);
        mImageGemstone.setOnClickListener(this);
        mImageRing.setOnClickListener(this);
        mImageShoes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.image_head:
                newFragment(HEAD);
                break;
            case R.id.image_defence:
                newFragment(DEFENCE);
                break;
            case R.id.image_sword:
                newFragment(SWORD);
                break;
            case R.id.image_wing:
                newFragment(WING);
                break;
            case R.id.image_necklace:
                newFragment(NECKLACE);
                break;
            case R.id.image_belt:
                newFragment(BELT);
                break;
            case R.id.image_clothes:
                newFragment(CLOTHES);
                break;
            case R.id.image_pant:
                newFragment(PANT);
                break;
            case R.id.image_gemstone:
                newFragment(GEMSTONE);
                break;
            case R.id.image_ring:
                newFragment(RING);
                break;
            case R.id.image_shoes:
                newFragment(SHOES);
                break;
            case R.id.image_bracelet:
                newFragment(BRACELET);
                break;
            default:break;
        }
    }
    
    private void newFragment(String type){
        fragment = ChooseEquipmentFragment.newInstance(type);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.show_choose_frameLayout,fragment).commit();
    }
    public Fragment getChooseEquipmentFragment(){
        return fragment;
    }
}
