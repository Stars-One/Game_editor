package com.wan.gameeditor1.utils;

import org.litepal.crud.DataSupport;

/**
 * Created by xen on 2018/2/23 0023.
 */

public class PointPlused extends DataSupport{
    private int strength,quick,defence,intelligence,spirit;


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getQuick() {
        return quick;
    }

    public void setQuick(int quick) {
        this.quick = quick;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    /**
     * @param p 一个PointPlused类
     * @return boolean true为相等
     *
     */
    public boolean compare(PointPlused p){
        if(this.strength!=p.getStrength() ||this.quick!=p.getQuick()||this.defence!=p.getDefence()||this.intelligence!=p.getIntelligence()||this.spirit!=p.getSpirit()){
            return false;
        }else{
            return true;
        }
    }

    public boolean compareStrength(PointPlused p){
        if(this.strength!=p.getStrength()){
            return false;
        }else{
            return true;
        }
    }

    public boolean compareQuick(PointPlused p){
        if(this.quick!=p.getQuick()){
            return false;
        }else{
            return true;
        }
    }
    public boolean compareSpirit(PointPlused p){
        if(this.spirit!=p.getSpirit()){
            return false;
        }else{
            return true;
        }
    }
    public boolean compareDefence(PointPlused p){
        if(this.defence!=p.getDefence()){
            return false;
        }else{
            return true;
        }
    }
    public boolean compareIntelligence(PointPlused p){
        if(this.intelligence!=p.getIntelligence()){
            return false;
        }else{
            return true;
        }
    }
}
