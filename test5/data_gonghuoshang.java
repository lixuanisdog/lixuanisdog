package com.example.zhinengjiaotong.test5;

public class data_gonghuoshang {

    private String id;
    private String suppierName;
    private String content;

    public data_gonghuoshang(String id, String suppierName, String content) {
        this.id = id;
        this.suppierName = suppierName;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuppierName() {
        return suppierName;
    }

    public void setSuppierName(String suppierName) {
        this.suppierName = suppierName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
