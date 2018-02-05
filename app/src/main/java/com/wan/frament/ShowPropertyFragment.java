package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wan.gameditor.R;
import com.wan.utils.PersonProperty;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowPropertyFragment extends Fragment {



    private TextView mCurrentId;
    private TextView mCurrentJob;
    private TextView mCurrentLiveJob;
    private TextView mCurrentLevel;
    private TextView mCurrentLive;
    private TextView mCurrentMagic;
    private TextView mCurrentAttack;
    private TextView mCurrentDefence;
    private TextView mCurrentDuck;
    private TextView mCurrentSpeed;
    private TextView mCurrentShengWang;
    private TextView mCurrentShengMi;



    public ShowPropertyFragment() {
        // Required empty public constructor
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mCurrentId =(TextView) view.findViewById(R.id.currentId);
        mCurrentJob=(TextView) view.findViewById(R.id.currentJob);
        mCurrentLiveJob=(TextView) view.findViewById(R.id.currentLiveJob);
        mCurrentLevel=(TextView) view.findViewById(R.id.currentLevel);
        mCurrentLive=(TextView) view.findViewById(R.id.currentLive);
        mCurrentMagic=(TextView) view.findViewById(R.id.currentMagic);
        mCurrentAttack=(TextView) view.findViewById(R.id.currentAttack);
        mCurrentDefence=(TextView) view.findViewById(R.id.currentDefence);
        mCurrentDuck=(TextView) view.findViewById(R.id.currentDuck);
        mCurrentSpeed=(TextView) view.findViewById(R.id.currentSpeed);
        mCurrentShengWang=(TextView) view.findViewById(R.id.currentShengWang);
        mCurrentShengMi=(TextView) view.findViewById(R.id.currentShengMi);

    }
    public void setText(PersonProperty personProperty){
        mCurrentId.setText(personProperty.getmID());
        mCurrentJob.setText(personProperty.getJob());
        mCurrentLiveJob.setText(personProperty.getLiveJob());
        mCurrentLevel.setText(String.valueOf(personProperty.getLevel()));
        mCurrentLive.setText(String.valueOf(personProperty.getLive()));
        mCurrentMagic.setText(String.valueOf(personProperty.getMagic()));
        mCurrentAttack.setText(String.valueOf(personProperty.getAttack()));
        mCurrentDefence.setText(String.valueOf(personProperty.getDefence()));
        mCurrentDuck.setText(String.valueOf(personProperty.getDuck()));
        mCurrentSpeed.setText(String.valueOf(personProperty.getSpeed()));
        mCurrentShengWang.setText(String.valueOf(personProperty.getShengWang()));
        mCurrentShengMi.setText(String.valueOf(personProperty.getShengMi()));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_show_property, container, false);
    }

}
