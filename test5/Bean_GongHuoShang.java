package com.example.zhinengjiaotong.test5;

import java.util.List;

public class Bean_GongHuoShang {
    String status;
    String message;

    List<data_gonghuoshang> data;

    public Bean_GongHuoShang(String status, String message, List<data_gonghuoshang> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<data_gonghuoshang> getData() {
        return data;
    }

    public void setData(List<data_gonghuoshang> data) {
        this.data = data;
    }
}
