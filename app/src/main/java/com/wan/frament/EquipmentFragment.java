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
import com.wan.utils.AlreadyEquipment;
import com.wan.utils.EquipmentResult;

import org.litepal.crud.DataSupport;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipmentFragment extends Fragment implements View.OnClickListener,View.OnLongClickListener{


    private static final String HEAD = "头饰";
    private static final String SHIELD = "防具";
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
    private ShowEquipmentPropertyFragment fragment1;


    public EquipmentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    private void init(){
        if (!DataSupport.isExist(AlreadyEquipment.class)){
            //初始化alreadyEquipment，12条数据
            for (int i=0;i<12;i++){
                AlreadyEquipment equipment = new AlreadyEquipment();
                equipment.setName(""+i);
                switch (i){
                    case 0:
                        equipment.setType(HEAD);
                        break;
                    case 1:
                        equipment.setType(SWORD);
                        break;
                    case 2:
                        equipment.setType(SHIELD);
                        break;
                    case 3:
                        equipment.setType(CLOTHES);
                        break;
                    case 4:
                        equipment.setType(PANT);
                        break;
                    case 5:
                        equipment.setType(DEFENCE);
                        break;
                    case 6:
                        equipment.setType(BELT);
                        break;
                    case 7:
                        equipment.setType(BRACELET);
                        break;
                    case 8:
                        equipment.setType(GEMSTONE);
                        break;
                    case 9:
                        equipment.setType(RING);
                        break;
                    case 10:
                        equipment.setType(WING);
                        break;
                    case 11:
                        equipment.setType(SHOES);
                        break;
                    default:break;
                }
                equipment.save();
            }
        }

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
        
        
        mImageHead.setOnLongClickListener(this);
        mImageDefence.setOnLongClickListener(this);
        mImageSword.setOnLongClickListener(this);
        mImageWing.setOnLongClickListener(this);
        mImageNecklace.setOnLongClickListener(this);
        mImageBelt.setOnLongClickListener(this);
        mImageClothes.setOnLongClickListener(this);
        mImageBracelet.setOnLongClickListener(this);
        mImagePant.setOnLongClickListener(this);
        mImageGemstone.setOnLongClickListener(this);
        mImageRing.setOnLongClickListener(this);
        mImageShoes.setOnLongClickListener(this);
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

    public void removeFragment(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment1).commit();
    }
    @Override
    public boolean onLongClick(View v) {

        EquipmentResult equipmentResult;
        switch (v.getId()){

            case R.id.image_head:
                equipmentResult = AlreadyEquipment.getEquipment(HEAD);
                show(equipmentResult,HEAD);

                break;
            case R.id.image_defence:
                equipmentResult = AlreadyEquipment.getEquipment(SHIELD);
                show(equipmentResult,SHIELD);

                break;
            case R.id.image_sword:
                equipmentResult = AlreadyEquipment.getEquipment(SWORD);
                show(equipmentResult,SWORD);
                break;
            case R.id.image_wing:
                equipmentResult = AlreadyEquipment.getEquipment(WING);
                show(equipmentResult,WING);
                break;
            case R.id.image_necklace:
                equipmentResult = AlreadyEquipment.getEquipment(NECKLACE);
                show(equipmentResult,NECKLACE);
                break;
            case R.id.image_belt:
                equipmentResult = AlreadyEquipment.getEquipment(BELT);
                show(equipmentResult,BELT);
                break;
            case R.id.image_clothes:
                equipmentResult = AlreadyEquipment.getEquipment(CLOTHES);
                show(equipmentResult,CLOTHES);
                break;
            case R.id.image_pant:
                equipmentResult = AlreadyEquipment.getEquipment(PANT);
                show(equipmentResult,PANT);
                break;
            case R.id.image_gemstone:
                equipmentResult = AlreadyEquipment.getEquipment(GEMSTONE);
                show(equipmentResult,GEMSTONE);
                break;
            case R.id.image_ring:
                equipmentResult = AlreadyEquipment.getEquipment(RING);
                show(equipmentResult,RING);
                break;
            case R.id.image_shoes:
                equipmentResult = AlreadyEquipment.getEquipment(SHOES);
                show(equipmentResult,SHOES);
                break;
            case R.id.image_bracelet:
                equipmentResult = AlreadyEquipment.getEquipment(BRACELET);
                show(equipmentResult,BRACELET);
                break;
            default:break;
        }
        return true;
    }
    public void show(EquipmentResult equipmentResult,String s){
        if (equipmentResult==null){
            newFragment(s);
        }else {
            fragment1 = ShowEquipmentPropertyFragment.newInstance(equipmentResult,false);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.show_equipment_frameLayout,fragment1).commit();
        }
    }
}
