package com.example.zhinengjiaotong;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import okhttp3.FormBody;

public class Main2Activity extends AppCompatActivity {

    Button lengfeng;
    Button ruanfeng;
    Button kaiguan;
    TextView leng;
    TextView re;
    OkhttpDButis okhttpDButis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();


        kaiguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qingqiukaiguan(0);
                re.setTextColor(Color.parseColor("#666666"));
                leng.setTextColor(Color.parseColor("#666666"));

            }
        });
        lengfeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qingqiukaiguan(1);

                leng.setTextColor(Color.parseColor("#333333"));
                re.setTextColor(Color.parseColor("#666666"));

            }
        });
        ruanfeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qingqiukaiguan(2);
                leng.setTextColor(Color.parseColor("#666666"));
                re.setTextColor(Color.parseColor("#333333"));
            }
        });

    }

    public void init(){
        lengfeng = findViewById(R.id.test2_btn_lengfeng);
        ruanfeng = findViewById(R.id.test2_btn_ruanfeng);
        kaiguan = findViewById(R.id.test2_btn_kaiguan);
        leng = findViewById(R.id.test2_tv_leng);
        re = findViewById(R.id.test2_tv_re);

    }


    public void qingqiukaiguan(int temp){
        String url ="http://192.168.43.200:8085/dataInterface/UserWorkEnvironmental/update";
        FormBody formBody = new FormBody.Builder().add("id","1").add("acOnOff",String.valueOf(temp)).build();
        okhttpDButis = new OkhttpDButis(url,formBody);
        okhttpDButis.qingqiu();
    }
}
