package com.example.zhinengjiaotong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {

    List<Bean_test3> list = new ArrayList<>();
    ListView listView;
    MyAdapter myAdapter;

    static String json;
    Gson gson;
    Bean_YuanGong bean_yuanGong;

    OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();


        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x01){
                    gson = new Gson();
                    bean_yuanGong = gson.fromJson(json,Bean_YuanGong.class);
                    for(int i=0;i<bean_yuanGong.getData().size();i++){
                        list.add(new Bean_test3(bean_yuanGong.getData().get(i).getPeopleName(),bean_yuanGong.getData().get(i).getContent(),String.valueOf(bean_yuanGong.getData().get(i).getGold())));
                    }
                    myAdapter = new MyAdapter(list);
                    listView.setAdapter(myAdapter);
                }
            }
        };


        okHttpClient = new OkHttpClient();
        String url = "http://192.168.43.200:8085/dataInterface/People/getAll";
        Request request = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                json = response.body().string();   //获取到数据
                Message message = new Message();
                message.what=0x01;
                handler.sendMessage(message);
            }
        });
    }

    public void init(){
        listView = findViewById(R.id.test3_lv);
        list.add(new Bean_test3("姓名","类型","薪资"));
    }

    class MyAdapter extends BaseAdapter {

        List<Bean_test3> list = new ArrayList<>();

        public MyAdapter(List<Bean_test3> list) {
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
                convertView = View.inflate(Main3Activity.this,R.layout.test3_item,null);
                viewHolder.textView1 = convertView.findViewById(R.id.test3_item_tv1);
                viewHolder.textView2 = convertView.findViewById(R.id.test3_item_tv2);
                viewHolder.textView3 = convertView.findViewById(R.id.test3_item_tv3);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textView1.setText(list.get(position).getName());
            viewHolder.textView2.setText(list.get(position).getAdmin());
            viewHolder.textView3.setText(list.get(position).getXinzhi());
            if(position==0){
                viewHolder.textView1.setTypeface(Typeface.DEFAULT_BOLD);
                viewHolder.textView2.setTypeface(Typeface.DEFAULT_BOLD);
                viewHolder.textView3.setTypeface(Typeface.DEFAULT_BOLD);
            }

            return convertView;
        }

        class ViewHolder{
            TextView textView1;
            TextView textView2;
            TextView textView3;
        }
    }
}
