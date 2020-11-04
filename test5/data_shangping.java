package com.example.zhinengjiaotong.test5;

public class data_shangping {
    private String id;
    private String partName;
    private String content;
    private int area;
    private String icon;

    public data_shangping(String id, String partName, String content, int area, String icon) {
        this.id = id;
        this.partName = partName;
        this.content = content;
        this.area = area;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
