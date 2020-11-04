package com.example.zhinengjiaotong.test5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhinengjiaotong.Bean_test3;
import com.example.zhinengjiaotong.R;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main4Activity extends AppCompatActivity {
    ListView listView;
    MyAdapter myAdapter;
    List<Bean_test5> list = new ArrayList<>();
    OkHttpClient okHttpClient;
    static String json;
    static String json1;
    static String json2;
    Gson gson;
    BeanHuoYuan beanHuoYuan;
    List<Bean_ShangPing> shangPings = new ArrayList<>();
    List<Bean_GongHuoShang> gongHuoShangs = new ArrayList<>();
    TextView textView1;
    TextView textView2;
    Boolean aBooleanjiage = true;
    Boolean aBooleancount = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        init();

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x01){
                    Log.i("info",String.valueOf(shangPings.size()));
                    Log.i("info",String.valueOf(gongHuoShangs.size()));
                    Log.i("info",String.valueOf(beanHuoYuan.getData().size()));
                    for(int i=0; i<beanHuoYuan.getData().size() ;i++){
                        list.add(new Bean_test5(shangPings.get(i).getData().get(0).getPartName(),gongHuoShangs.get(i).getData().get(0).getSuppierName(),beanHuoYuan.getData().get(i).getGold(),beanHuoYuan.getData().get(i).getNum()));
                    }
                    myAdapter = new MyAdapter(list);
                    listView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                    listView.invalidate();

                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                super.run();
                okHttpClient = new OkHttpClient();
                String url1= "http://192.168.43.200:8085/dataInterface/SuppierList/getAll";
                Request request = new Request.Builder().get().url(url1).build();
                Call call = okHttpClient.newCall(request);

                try {
                    Response response = call.execute();
                    json = response.body().string();
                    gson = new Gson();
                    beanHuoYuan = gson.fromJson(json,BeanHuoYuan.class);
                    for(int i=0;i<beanHuoYuan.getData().size();i++) {
                        OkHttpClient okHttpClient2 = new OkHttpClient();
                        String url2= "http://192.168.43.200:8085/dataInterface/Part/getInfo";
                        FormBody formBody = new FormBody.Builder().add("id",String.valueOf(beanHuoYuan.getData().get(i).getPartId())).build();
                        Request request1 = new Request.Builder().post(formBody).url(url2).build();
                        Call call1 = okHttpClient2.newCall(request1);
                        Response response1 = call1.execute();
                        json1 = response1.body().string();
                        Bean_ShangPing bean_shangPing = gson.fromJson(json1,Bean_ShangPing.class);
                        shangPings.add(bean_shangPing);




                        OkHttpClient okHttpClient3 = new OkHttpClient();
                        String url3= "http://192.168.43.200:8085/dataInterface/Suppier/getInfo";
                        FormBody formBody2 = new FormBody.Builder().add("id",String.valueOf(beanHuoYuan.getData().get(i).getSuppierId())).build();
                        Request request2 = new Request.Builder().post(formBody2).url(url3).build();
                        Call call2 = okHttpClient3.newCall(request2);
                        Response response2 = call2.execute();
                        json2 = response2.body().string();
                        Bean_GongHuoShang bean_gongHuoShang = gson.fromJson(json2,Bean_GongHuoShang.class);
                        gongHuoShangs.add(bean_gongHuoShang);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


                Log.i("info",String.valueOf(shangPings.size()));
                Log.i("info",String.valueOf(gongHuoShangs.size()));
                Log.i("info",String.valueOf(beanHuoYuan.getData().size()));
                Message message = new Message();
                message.what=0x01;
                handler.sendMessage(message);
            }
        }.start();


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aBooleanjiage){

                    Collections.sort(list,new jiageSort());
                    myAdapter.notifyDataSetChanged();
                    textView1.setText("价格/升序");
                    textView2.setText("数量");
                    aBooleanjiage = false;
                }else{
                    Collections.sort(list,new jiageSort());
                    myAdapter.notifyDataSetChanged();
                    textView1.setText("价格/降序");
                    textView2.setText("数量");
                    aBooleanjiage = true;
                }

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aBooleancount){
                    Collections.sort(list,new countSort());
                    myAdapter.notifyDataSetChanged();
                    textView2.setText("数量/升序");
                    textView1.setText("价格");
                    aBooleancount = false;
                }else{
                    Collections.sort(list,new countSort());
                    myAdapter.notifyDataSetChanged();
                    textView2.setText("数量/降序");
                    textView1.setText("价格");
                    aBooleancount = true;
                }
            }
        });

    }

    public void init(){
        listView = findViewById(R.id.test5_lv);
        textView1 = findViewById(R.id.test5_jiage);
        textView2 = findViewById(R.id.test5_count);

    }


    class MyAdapter extends BaseAdapter{

        List<Bean_test5> list = new ArrayList<>();

        public MyAdapter(List<Bean_test5> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                viewHolder = new ViewHolder();
                convertView = View.inflate(Main4Activity.this,R.layout.test5_item,null);
                viewHolder.textView1 = convertView.findViewById(R.id.test5_item_tv1);
                viewHolder.textView2 = convertView.findViewById(R.id.test5_item_tv2);
                viewHolder.textView3 = convertView.findViewById(R.id.test5_item_tv3);
                viewHolder.textView4 = convertView.findViewById(R.id.test5_item_tv4);
                convertView.setTag(viewHolder);

            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView1.setText(list.get(position).getPartName());
            viewHolder.textView2.setText(String.valueOf(list.get(position).getJiage()));
            viewHolder.textView3.setText(String.valueOf(list.get(position).getCount()));
            viewHolder.textView4.setText(list.get(position).getSuppierContent());
            return convertView;
        }

        class ViewHolder{
            TextView textView1;
            TextView textView2;
            TextView textView3;
            TextView textView4;
        }
    }



    class jiageSort implements Comparator<Bean_test5> {
        @Override
        public int compare(Bean_test5 itembean, Bean_test5 t1) {
            if (aBooleanjiage) {
                //路口升序
                return itembean.getJiage() >= t1.getJiage() ? 1 : -1;
            } else {
                //路口降序
                return itembean.getJiage() >= t1.getJiage() ? -1 : 1;
            }
        }
    }

    class countSort implements Comparator<Bean_test5> {
        @Override
        public int compare(Bean_test5 itembean, Bean_test5 t1) {
            if (aBooleancount) {
                //路口升序
                return itembean.getCount() >= t1.getCount() ? 1 : -1;
            } else {
                //路口降序
                return itembean.getCount() >= t1.getCount() ? -1 : 1;
            }
        }
    }
}
