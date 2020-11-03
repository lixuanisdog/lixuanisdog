package com.example.zhinengjiaotong;

import java.util.List;

public class Bean_YuanGong {
    String status;
    String message;

    List<Bean_data> data;

    public Bean_YuanGong(String status, String message, List<Bean_data> data) {
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

    public List<Bean_data> getData() {
        return data;
    }

    public void setData(List<Bean_data> data) {
        this.data = data;
    }
}
