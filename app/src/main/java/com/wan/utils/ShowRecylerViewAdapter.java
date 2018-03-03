package com.wan.utils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wan.frament.ShowEquipmentPropertyFragment;
import com.wan.gameditor.R;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by xen on 2018/2/28 0028.
 */

public class ShowRecylerViewAdapter extends RecyclerView.Adapter<ShowRecylerViewAdapter.ViewHolder> {


    private List<EquipmentResult> mlist;
    private String type;
    private FragmentManager fragmentManager;
    private ShowEquipmentPropertyFragment showEquipmentPropertyFragment;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.tv_equipment_name);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    public ShowRecylerViewAdapter(String type,FragmentManager fragmentManager) {
        Log.d("Adaptet","------adpeter");
        this.type = type;
        this.fragmentManager = fragmentManager;
        mlist = DataSupport.where("type = ?",type).find(EquipmentResult.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("onCreateViewHodler","-----onCreateViewHolder---");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_show_recyclerview,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String nameTemp = mlist.get(position).getName();
        holder.name.setText(nameTemp);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquipmentResult equipmentResult = DataSupport.where("Name = ?",nameTemp).findFirst(EquipmentResult.class);
                showEquipmentPropertyFragment = ShowEquipmentPropertyFragment.newInstance(equipmentResult);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.show_equipment_frameLayout,showEquipmentPropertyFragment).commit();
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquipmentResult equipmentResult = DataSupport.where("Name = ?",nameTemp).findFirst(EquipmentResult.class);
                showEquipmentPropertyFragment = ShowEquipmentPropertyFragment.newInstance(equipmentResult);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.show_equipment_frameLayout,showEquipmentPropertyFragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("itemSize=","------------"+mlist.size());
        return mlist.size();
    }
    public ShowEquipmentPropertyFragment getShowEquipmentPropertyFragment(){
        return showEquipmentPropertyFragment;
    }

}
