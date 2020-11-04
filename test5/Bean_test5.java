package com.example.zhinengjiaotong.test5;

public class Bean_test5 {
    String partName;
    String SuppierContent;
    int jiage;
    int count;

    public Bean_test5(String partName, String suppierContent, int jiage, int count) {
        this.partName = partName;
        SuppierContent = suppierContent;
        this.jiage = jiage;
        this.count = count;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getSuppierContent() {
        return SuppierContent;
    }

    public void setSuppierContent(String suppierContent) {
        SuppierContent = suppierContent;
    }

    public int getJiage() {
        return jiage;
    }

    public void setJiage(int jiage) {
        this.jiage = jiage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
