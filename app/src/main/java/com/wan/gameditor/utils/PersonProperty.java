package com.wan.gameditor.utils;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * Created by xen on 2018/2/5 0005.
 */

public class PersonProperty extends DataSupport implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mID);
        dest.writeString(this.Job);
        dest.writeString(this.LiveJob);
        dest.writeInt(this.Level);
        dest.writeInt(this.Live);
        dest.writeInt(this.Magic);
        dest.writeInt(this.Attack);
        dest.writeInt(this.Defence);
        dest.writeInt(this.Duck);
        dest.writeInt(this.Speed);
        dest.writeInt(this.ShengWang);
        dest.writeInt(this.ShengMi);
    }

    public PersonProperty() {
    }

    protected PersonProperty(Parcel in) {
        this.mID = in.readString();
        this.Job = in.readString();
        this.LiveJob = in.readString();
        this.Level = in.readInt();
        this.Live = in.readInt();
        this.Magic = in.readInt();
        this.Attack = in.readInt();
        this.Defence = in.readInt();
        this.Duck = in.readInt();
        this.Speed = in.readInt();
        this.ShengWang = in.readInt();
        this.ShengMi = in.readInt();
    }

    public static final Parcelable.Creator<PersonProperty> CREATOR = new Parcelable.Creator<PersonProperty>() {
        @Override
        public PersonProperty createFromParcel(Parcel source) {
            return new PersonProperty(source);
        }

        @Override
        public PersonProperty[] newArray(int size) {
            return new PersonProperty[size];
        }
    };
}
