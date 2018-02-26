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
import android.widget.Toast;

import com.wan.gameditor.R;
import com.wan.gameditor.activity.CurrentActivity;
import com.wan.utils.PersonProperty;

import org.litepal.crud.DataSupport;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyFragment extends Fragment {


    private String ID,Job,LiveJob;
    private int Level,Live,Magic,Attack,Defence,Duck,Speed,ShengWang,ShengMi;
    private PersonProperty personProperty;
    private boolean isExist;
    private EditText mPersonID;
    private EditText mPersonJob;
    private EditText mPersonLiveJob;
    private EditText mPersonLive;
    private EditText mPersonMagic;
    private EditText mPersonAttack;
    private EditText mPersonDefence;
    private EditText mPersonDuck;
    private EditText mPersonSpeed;
    private EditText mPersonShengWang;
    private EditText mPersonShengMi;
    private EditText mPersonLevel;
    private Button mPersonSave;

    public static PropertyFragment newInstance(PersonProperty personProperty,boolean isExist){
        PropertyFragment propertyFragment = new PropertyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("PersonProperty",personProperty);
        bundle.putBoolean("isExist",isExist);
        propertyFragment.setArguments(bundle);
        return  propertyFragment;
    }

    public PropertyFragment(){


    }


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
           mPersonID = (EditText) view.findViewById(R.id.personID);
            mPersonJob = (EditText) view.findViewById(R.id.personJob);
            mPersonLiveJob= (EditText) view.findViewById(R.id.personLiveJob);
            mPersonLive= (EditText) view.findViewById(R.id.personLive);
            mPersonMagic= (EditText) view.findViewById(R.id.personMagic);
            mPersonAttack= (EditText) view.findViewById(R.id.personAttack);
            mPersonDefence= (EditText) view.findViewById(R.id.personDefence);
            mPersonDuck= (EditText) view.findViewById(R.id.personDuck);
            mPersonSpeed= (EditText) view.findViewById(R.id.personSpeed);
            mPersonShengWang= (EditText) view.findViewById(R.id.personShengWang);
            mPersonShengMi= (EditText) view.findViewById(R.id.personShengMi);
            mPersonLevel= (EditText) view.findViewById(R.id.personLevel);
            mPersonSave= (Button) view.findViewById(R.id.personSave);
           if(isExist){
               setText(personProperty);
           }

            mPersonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getText();
                    save();
                    Toast.makeText(v.getContext(), "已保存", Toast.LENGTH_SHORT).show();
                    CurrentActivity activity = (CurrentActivity)getActivity();
                    PersonProperty personProperty = DataSupport.findFirst(PersonProperty.class);
                    activity.updateShowProperty(personProperty);

                }
            });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        isExist = bundle.getBoolean("isExist");
        if (isExist) {
            personProperty = bundle.getParcelable("PersonProperty");
        }

    }

    public void setText(PersonProperty personProperty){
        ID = personProperty.getmID();
        Job = personProperty.getJob();
        LiveJob = personProperty.getLiveJob();
        Live = personProperty.getLive();
        Magic = personProperty.getMagic();
        Attack = personProperty.getAttack();
        Defence = personProperty.getDefence();
        Duck = personProperty.getDuck();
        Speed = personProperty.getSpeed();
        ShengWang = personProperty.getShengWang();
        ShengMi = personProperty.getShengMi();
        Level = personProperty.getLevel();

        mPersonID.setText(ID);
        mPersonJob.setText(Job);
        mPersonLiveJob.setText(LiveJob);
        mPersonLive.setText(String.valueOf(Live));
       mPersonMagic.setText(String.valueOf(Magic));
        mPersonLevel.setText(String.valueOf(Level));
        mPersonAttack.setText(String.valueOf(Attack));
        mPersonDefence.setText(String.valueOf(Defence));
        mPersonDuck.setText(String.valueOf(Duck));
        mPersonSpeed.setText(String.valueOf(Speed));
        mPersonShengWang.setText(String.valueOf(ShengWang));
        mPersonShengMi.setText(String.valueOf(ShengMi));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_property, container, false);
    }
    private void getText(){
        this.ID = mPersonID.getText().toString();
        this.Job = mPersonJob.getText().toString();
        this.LiveJob = mPersonLiveJob.getText().toString();
        this.Level = Integer.valueOf(mPersonLevel.getText().toString());
        this.Live = Integer.valueOf(mPersonLive.getText().toString());
        this.Magic = Integer.valueOf(mPersonMagic.getText().toString());
        this.Attack = Integer.valueOf(mPersonAttack.getText().toString());
        this.Defence = Integer.valueOf(mPersonDefence.getText().toString());
        this.Duck =Integer.valueOf(mPersonDuck.getText().toString());
        this.Speed = Integer.valueOf(mPersonSpeed.getText().toString());
        this.ShengWang = Integer.valueOf(mPersonShengWang.getText().toString());
        Log.d("Property","-----声望"+mPersonShengWang.getText().toString());
        this.ShengMi = Integer.valueOf(mPersonShengMi.getText().toString());
    }
    private void save(){
        PersonProperty personProperty = new PersonProperty();

        personProperty.setmID(ID);
        personProperty.setJob(Job);
        personProperty.setLiveJob(LiveJob);

        if(Level!=0){
            personProperty.setLevel(Level);
        }else{
            personProperty.setToDefault("Level");//设置为默认值，也就是为0，Litepal数据库中不能使用set方法来设置0
        }

        if (Live!=0){
            personProperty.setLive(Live);
        }else{
            personProperty.setToDefault("Live");
        }

        if (Magic!=0){
            personProperty.setMagic(Magic);
        }else{
            personProperty.setToDefault("Magic");
        }

        if (Attack!=0){
            personProperty.setAttack(Attack);
        }else{
            personProperty.setToDefault("Attack");
        }

        if (Defence!=0){
            personProperty.setDefence(Defence);
        }else{
            personProperty.setToDefault("Defence");
        }

        if (Duck!=0){
            personProperty.setDuck(Duck);
        }else{
            personProperty.setToDefault("Duck");
        }

        if (Speed!=0){
            personProperty.setSpeed(Speed);
        }else{
            personProperty.setToDefault("Speed");
        }

        if (ShengMi!=0){
            personProperty.setShengMi(ShengMi);
        }else{
            personProperty.setToDefault("ShengMi");
        }

        if (ShengWang!=0){
            personProperty.setShengWang(ShengWang);
        }else{
            personProperty.setToDefault("ShengWang");
        }


        if (isExist){
            personProperty.updateAll();
        }else{
            personProperty.save();
        }


    }
}
