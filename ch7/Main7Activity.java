package com.example.liuye.jixuntes2.ch7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.liuye.jixuntes2.R;
import com.example.liuye.jixuntes2.okhttputils.MyHelpokhttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main7Activity extends AppCompatActivity {
    private ListView listView;
    private BaseAdapter baseAdapter;
    JsonRootBean js;
    private String path="http://192.168.43.200:8085/Interface/index/getUserRepairCarStoreAll";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder().url(path).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("liuye", response.toString());
                        Gson gson = new Gson();
                        js= gson.fromJson(response.body().string(),JsonRootBean.class);
                    }
                });
                try {
                    Thread.sleep(3000);
                    createAdapter();
                    listView=(ListView)findViewById(R.id.listview7);
                    listView.setAdapter(baseAdapter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }
    private void createAdapter() {
        baseAdapter= new BaseAdapter() {
            @Override
            public int getCount() {
                return js.getData().size();
            }

            @Override
            public Object getItem(int i) {
                return js.getData().get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ViewHolder viewholder;
                if(view==null){
                    view= LayoutInflater.from(Main7Activity.this).inflate(R.layout.listview7item,null);
                    viewholder=new ViewHolder();
                    viewholder.id=view.findViewById(R.id.item7id);
                    viewholder.leixing=view.findViewById(R.id.item7type);
                    viewholder.miaoshu=view.findViewById(R.id.item7miaoshu);
                    viewholder.shengchangxianxinxi=view.findViewById(R.id.item7shengchangxinxi);
                    viewholder.weixiu=view.findViewById(R.id.item7weixiufeiyong);
                    view.setTag(viewholder);
                }else{
                    viewholder= (ViewHolder) view.getTag();
                }
                viewholder.id.setText(js.getData().get(i).getCarTypeId()+"");
                viewholder.leixing.setText(js.getData().get(i).getCarType().getCarTypeName()+"");
                viewholder.miaoshu.setText(js.getData().get(i).getCarType().getContent());
                viewholder.shengchangxianxinxi.setText(js.getData().get(i).getCarType().getId()+"");
                viewholder.weixiu.setText(js.getData().get(i).getCarType().getRepairPrice()+"");
                return view;
            }
            class ViewHolder{
                TextView id;
                TextView leixing;
                TextView miaoshu;
                TextView shengchangxianxinxi;
                TextView weixiu;
            }
        };
    }
}
