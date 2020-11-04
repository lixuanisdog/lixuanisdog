package com.example.zhinengjiaotong.test5;

import java.util.List;

public class Bean_ShangPing {
    String status;
    String message;

    List<data_shangping> data;

    public Bean_ShangPing(String status, String message, List<data_shangping> data) {
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

    public List<data_shangping> getData() {
        return data;
    }

    public void setData(List<data_shangping> data) {
        this.data = data;
    }

}
