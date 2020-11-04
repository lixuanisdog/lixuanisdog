package com.example.zhinengjiaotong.test5;

public class data_zonghe {
    private int id;
    private int suppierId;
    private int partId;
    private int gold;
    private int num;

    public data_zonghe(int id, int suppierId, int partId, int gold, int num) {
        this.id = id;
        this.suppierId = suppierId;
        this.partId = partId;
        this.gold = gold;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuppierId() {
        return suppierId;
    }

    public void setSuppierId(int suppierId) {
        this.suppierId = suppierId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
