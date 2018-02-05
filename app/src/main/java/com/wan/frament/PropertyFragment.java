package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wan.gameditor.R;
import com.wan.utils.PersonProperty;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyFragment extends Fragment {


    private String ID,Job,LiveJob;
    private int Level,Live,Magic,Attack,Defence,Duck,Speed,ShengWang,ShengMi;
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


            mPersonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getText();
                    save();
                    Toast.makeText(v.getContext(), "已保存", Toast.LENGTH_SHORT).show();
                }
            });
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
        mPersonLiveJob.setText(Live);
        mPersonLevel.setText(Level);
        mPersonAttack.setText(Attack);
        mPersonDefence.setText(Defence);
        mPersonDuck.setText(Duck);
        mPersonSpeed.setText(Speed);
        mPersonShengWang.setText(ShengWang);
        mPersonShengMi.setText(ShengMi);
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
        this.ShengMi = Integer.valueOf(mPersonShengMi.getText().toString());
    }
    private void save(){
        PersonProperty personProperty = new PersonProperty();

        personProperty.setmID(ID);
        personProperty.setJob(Job);
        personProperty.setLiveJob(LiveJob);
        personProperty.setLevel(Level);
        personProperty.setLive(Live);
        personProperty.setMagic(Magic);
        personProperty.setAttack(Attack);
        personProperty.setDefence(Defence);
        personProperty.setDuck(Duck);
        personProperty.setSpeed(Speed);
        personProperty.setShengWang(ShengWang);
        personProperty.setShengMi(ShengMi);
        if(isExist){
            personProperty.updateAll();
        }
        personProperty.save();

    }
}
