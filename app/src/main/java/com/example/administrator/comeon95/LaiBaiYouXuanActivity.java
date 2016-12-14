package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.LaibaiYouXuanAdapter;
import RetrofitData.DownLoadYouXuanUtil;
import javabeans.YouXunData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

public class LaiBaiYouXuanActivity extends AppCompatActivity {
    private ListView youXuanListView;
    private List<Map> data;
    private ImageView about_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lai_bai_you_xuan);
        initView();
        initData();
        intLinister();
    }

    private void intLinister() {
        about_return = (ImageView) findViewById(R.id.about_return);
        about_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initData() {
        DownLoadYouXuanUtil youXuanUtil = new DownLoadYouXuanUtil(this);
        youXuanUtil.downLoadData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<YouXunData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(YouXunData youXunData) {
                        for (int i = 0; i <youXunData.getData().size() ; i++) {
                            Map<String,Object> map0 = new HashMap();
                            map0.put("image",youXunData.getData().get(i).getMainPic());
                            map0.put("title",youXunData.getData().get(i).getTitle());
                            map0.put("discountprice",youXunData.getData().get(i).getNewPrice());
                            map0.put("price",youXunData.getData().get(i).getOldPrice());
                            data.add(map0);
                        }

                        LaibaiYouXuanAdapter adapter = new LaibaiYouXuanAdapter(LaiBaiYouXuanActivity.this,data);
                        youXuanListView.setAdapter(adapter);
                        View head_View = LayoutInflater.from(LaiBaiYouXuanActivity.this).inflate(R.layout.youxuan_listhead_view,null);
                        youXuanListView.addHeaderView(head_View);
                        setLiseViewLinister(youXunData);
                    }
                });
    }

    private void setLiseViewLinister(final YouXunData youXunData) {
        youXuanListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    return;
                }
                Intent intent = new Intent(LaiBaiYouXuanActivity.this,YouXuanGoodActivity.class);
                int idd = youXunData.getData().get(position - 1).getId();
                intent.putExtra("id", idd);
                intent.putExtra("title",youXunData.getData().get(position - 1).getTitle());
                intent.putExtra("info",youXunData.getData().get(position - 1).getInfo());
                double newPrice = youXunData.getData().get(position - 1).getNewPrice();
                intent.putExtra("discountprice", newPrice);
                double oldPrice = youXunData.getData().get(position - 1).getOldPrice();
                intent.putExtra("price", oldPrice);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        youXuanListView = (ListView) findViewById(R.id.youxuan_listview);
        data = new ArrayList<>();
    }
}
