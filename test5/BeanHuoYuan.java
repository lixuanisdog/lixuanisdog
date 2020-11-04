package com.example.zhinengjiaotong.test5;


import java.util.List;

public class BeanHuoYuan {

    String status;
    String message;
    List<data_zonghe> data;

    public BeanHuoYuan(String status, String message, List<data_zonghe> data) {
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

    public List<data_zonghe> getData() {
        return data;
    }

    public void setData(List<data_zonghe> data) {
        this.data = data;
    }
}
