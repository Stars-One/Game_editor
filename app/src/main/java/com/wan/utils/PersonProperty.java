package com.wan.utils;

import org.litepal.crud.DataSupport;

/**
 * Created by xen on 2018/2/5 0005.
 */

public class PersonProperty extends DataSupport {
    private String mID,Job,LiveJob;
    private int Level,Live,Magic,Attack,Defence,Duck,Speed,ShengWang,ShengMi;

    public String getmID() {
        return mID;
    }

    public void setmID(String ID) {
        this.mID = ID;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getLiveJob() {
        return LiveJob;
    }

    public void setLiveJob(String liveJob) {
        LiveJob = liveJob;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getLive() {
        return Live;
    }

    public void setLive(int live) {
        Live = live;
    }

    public int getMagic() {
        return Magic;
    }

    public void setMagic(int magic) {
        Magic = magic;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getDuck() {
        return Duck;
    }

    public void setDuck(int duck) {
        Duck = duck;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getShengWang() {
        return ShengWang;
    }

    public void setShengWang(int shengWang) {
        ShengWang = shengWang;
    }

    public int getShengMi() {
        return ShengMi;
    }

    public void setShengMi(int shengMi) {
        ShengMi = shengMi;
    }
}
