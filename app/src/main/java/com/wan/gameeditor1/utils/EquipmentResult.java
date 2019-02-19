package com.wan.gameeditor1.utils;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * reault类，用于存储查询的返回值
 */

public class EquipmentResult extends DataSupport implements Parcelable {

    private String name;
    private String type;
    private String required_level;
    private String level;
    private String extra_skill;
    private String special_efficiency;
    private int attack;
    private int defence;
    private int live;
    private int speed;
    private int duck;
    private int magic_attack;
    private int strength;
    private int spirit;
    private int intelligence;
    private int quick;



    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRequired_level(String required_level) {
        this.required_level = required_level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setExtra_skill(String extra_skill) {
        this.extra_skill = extra_skill;
    }

    public void setSpecial_efficiency(String special_efficiency) {
        this.special_efficiency = special_efficiency;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDuck(int duck) {
        this.duck = duck;
    }

    public void setMagic_attack(int magic_attack) {
        this.magic_attack = magic_attack;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setQuick(int quick) {
        this.quick = quick;
    }

    public String getRequired_level() {
        return required_level;
    }

    public String getLevel() {
        return level;
    }

    public String getExtra_skill() {
        return extra_skill;
    }

    public String getSpecial_efficiency() {
        return special_efficiency;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getLive() {
        return live;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDuck() {
        return duck;
    }

    public int getMagic_attack() {
        return magic_attack;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpirit() {
        return spirit;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getQuick() {
        return quick;
    }

    /*public EquipmentResult(String name, String required_level, String type, String level, int attack, int defence, int live, int speed, int duck, int magic_attack, int strength, int spirit, int intelligence, int quick, String extra_skill, String special_efficiency) {
        this.name = name;
        this.type = type;
        this.required_level = required_level;
        this.intelligence = intelligence;
        this.spirit = spirit;
        this.strength = strength;
        this.magic_attack = magic_attack;
        this.duck = duck;
        this.speed = speed;
        this.live = live;
        this.defence = defence;
        this.attack = attack;
        this.special_efficiency = special_efficiency;
        this.extra_skill = extra_skill;
        this.level = level;
        this.name = name;
        this.type = type;
        this.required_level = required_level;
        this.quick = quick;

        result = "装备名:  " + name;
        result = result +"\n" + "装备级别:  " + level;

        result =  result + " \n"+ "种类:  " + type ;
        result = result + " \n"+  "攻击:  " + attack ;
        result = result +"\n"+"防御： "   + defence ;
        result =  result +"\n"+"气血： "  + live ;
        result = result +"\n"+"魔攻： " + magic_attack ;
        result = result +"\n"+"速度： "  + speed  ;
        result = result +"\n"+"闪避： "  + duck ;
        result = result +"\n"+"所需等级： " + required_level;
        result = result +"\n"+"力量： " + strength ;
        result = result +"\n"+"体力： "  + spirit ;
        result =result +"\n"+ "智力： " + intelligence ;
        result = result +"\n"+"敏捷： "  + quick ;
        result = result +"\n"+"附加技能： "  + extra_skill ;
        result = result +"\n"+"特效： " +special_efficiency+"\n\n" ;
    }*/

    public String getName(){
        return this.name;
    }

    public String getType() {
        return type;
    }

    /*public String toString(){

        return result;
    }*/

    public EquipmentResult() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.required_level);
        dest.writeString(this.level);
        dest.writeString(this.extra_skill);
        dest.writeString(this.special_efficiency);
        dest.writeInt(this.attack);
        dest.writeInt(this.defence);
        dest.writeInt(this.live);
        dest.writeInt(this.speed);
        dest.writeInt(this.duck);
        dest.writeInt(this.magic_attack);
        dest.writeInt(this.strength);
        dest.writeInt(this.spirit);
        dest.writeInt(this.intelligence);
        dest.writeInt(this.quick);
    }

    protected EquipmentResult(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.required_level = in.readString();
        this.level = in.readString();
        this.extra_skill = in.readString();
        this.special_efficiency = in.readString();
        this.attack = in.readInt();
        this.defence = in.readInt();
        this.live = in.readInt();
        this.speed = in.readInt();
        this.duck = in.readInt();
        this.magic_attack = in.readInt();
        this.strength = in.readInt();
        this.spirit = in.readInt();
        this.intelligence = in.readInt();
        this.quick = in.readInt();
    }

    public static final Creator<EquipmentResult> CREATOR = new Creator<EquipmentResult>() {
        @Override
        public EquipmentResult createFromParcel(Parcel source) {
            return new EquipmentResult(source);
        }

        @Override
        public EquipmentResult[] newArray(int size) {
            return new EquipmentResult[size];
        }
    };
}
