package com.example.liuye.jixuntes2.ch7;

import java.util.List;

/**
 * Created by liuye on 2020/11/4.
 */

public class JsonRootBean {
    private int status;
    private String message;
    private List<Data> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
