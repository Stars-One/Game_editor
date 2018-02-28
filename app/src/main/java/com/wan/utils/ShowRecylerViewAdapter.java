package com.wan.utils;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wan.gameditor.R;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by xen on 2018/2/28 0028.
 */

public class ShowRecylerViewAdapter extends RecyclerView.Adapter<ShowRecylerViewAdapter.ViewHolder> {


    private List<EquipmentResult> mlist;
    private String type;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.tv_equipment_name);
        }
    }

    public ShowRecylerViewAdapter(String type) {
        Log.d("Adaptet","------adpeter");
        this.type = type;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(mlist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        Log.d("itemSize=","------------"+mlist.size());
        return mlist.size();

    }


}
