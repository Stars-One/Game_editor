package com.wan.frament;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wan.gameditor.R;
import com.wan.gameditor.activity.CurrentActivity;
import com.wan.utils.ShowRecylerViewAdapter;


public class ChooseEquipmentFragment extends Fragment implements View.OnClickListener{

    private String type;
    public ChooseEquipmentFragment() {

    }

    public static ChooseEquipmentFragment newInstance(String type){
        Log.d("ChooseEquipmentFragment","------newInstance---");
        ChooseEquipmentFragment chooseEquipmentFragment = new ChooseEquipmentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type",type);
        chooseEquipmentFragment.setArguments(bundle);
        return chooseEquipmentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        type = bundle.getString("type");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_choose_equipment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageView imageView = (ImageView)view.findViewById(R.id.cancel);
        TextView textView = (TextView)view.findViewById(R.id.choose_title);
        RecyclerView recylcerview = (RecyclerView)view.findViewById(R.id.choose_recyclerView);
        Log.d("OnViewCreated","-----findviewbyid recylcerview----");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recylcerview.setLayoutManager(layoutManager);
        recylcerview.setAdapter(new ShowRecylerViewAdapter(type));
        textView.setText(type);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                CurrentActivity activity = (CurrentActivity)getActivity();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.remove(activity.getEquipmentFragment().getChooseEquipmentFragment()).commit();
                break;
            default:break;
        }
    }
}
