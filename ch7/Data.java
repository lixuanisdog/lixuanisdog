package com.example.liuye.jixuntes2.ch7;

/**
 * Created by liuye on 2020/11/4.
 */

public class Data {
        private int id;
        private int userFactoryId;
        private int userLineId;
        private int carTypeId;
        private int type;
        private int num;
        private CarType CarType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserFactoryId() {
        return userFactoryId;
    }

    public void setUserFactoryId(int userFactoryId) {
        this.userFactoryId = userFactoryId;
    }

    public int getUserLineId() {
        return userLineId;
    }

    public void setUserLineId(int userLineId) {
        this.userLineId = userLineId;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CarType getCarType() {
        return CarType;
    }

    public void setCarType(CarType carType) {
        CarType = carType;
    }
}
