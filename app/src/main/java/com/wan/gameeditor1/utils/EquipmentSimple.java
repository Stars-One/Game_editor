package com.wan.gameeditor1.utils;

import org.litepal.crud.DataSupport;

/**
 * Created by xen on 2018/1/10 0010.
 */

public class EquipmentSimple extends DataSupport {
    private String name,type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
