package com.example.zhinengjiaotong;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpDButis {
    String url;
    FormBody formBody;
    OkHttpClient okHttpClient ;
    public OkhttpDButis(String url,FormBody formBody){
        this.url = url;
        this.formBody = formBody;
    }
    public void qingqiu(){
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i("info",response.toString());
            }
        });
    }
}
