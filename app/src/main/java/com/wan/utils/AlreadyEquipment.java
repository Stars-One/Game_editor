package com.wan.utils;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by xen on 2018/3/3 0003.
 */

public class AlreadyEquipment extends DataSupport {

    private String type,name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static EquipmentResult getEquipment(String type){
        String name = "x";//随便赋值的
        List<AlreadyEquipment> alreadyEquipments = DataSupport.where("type = ?",type).find(AlreadyEquipment.class);
        for(AlreadyEquipment alreadyEquipment :alreadyEquipments){
            if (alreadyEquipment.getType().equals(type)){
                name = alreadyEquipment.getName();
            }
        }
        List<EquipmentResult> list = DataSupport.where("type = ?",type).find(EquipmentResult.class);
        for(EquipmentResult e :list){
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }
}
