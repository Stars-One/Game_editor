package com.wan.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wan.gameditor.R;

import java.util.List;

/**
 * Created by xen on 2018/1/10 0010.
 */

public class mRecyclerViewAdatper extends RecyclerView.Adapter<mRecyclerViewAdatper.ViewHolder> {
    private List<EquipmentResult> equipmentResults;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,type;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.itemTitle);
            type = (TextView)itemView.findViewById(R.id.itemText);
        }
    }

    public mRecyclerViewAdatper(List<EquipmentResult> equipmentResults) {
        this.equipmentResults = equipmentResults;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_listitem,parent,false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        EquipmentResult result = equipmentResults.get(position);
        holder.name.setText(result.getName().toString());
        holder.type.setText(result.getType().toString());

    }

    @Override
    public int getItemCount() {
        return equipmentResults.size();
    }
}
