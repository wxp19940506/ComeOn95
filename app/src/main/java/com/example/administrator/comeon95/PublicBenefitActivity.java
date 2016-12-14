package com.example.administrator.comeon95;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.PublicBenefitAdapter;
import Adapters.PublicBenefitAdapter1;
import RetrofitData.DownLoadOneToOneUtils;
import RetrofitData.DownLoadPublicBenefitDataUtils;
import javabeans.OneToOneData;
import javabeans.PublicBenefitData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

public class PublicBenefitActivity extends AppCompatActivity {
    private ListView public_benefit_list;
    private List<Map> projectList,datas,datas1;
    private TabLayout tabs;
    PublicBenefitAdapter1 adapter1;
    PublicBenefitAdapter adapter;
    private ImageView head_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_benefit);
        initView();
        initHeadView();
        initAdapter(datas);
        initTabLinister();
        initLinister();
    }

    private void initLinister() {
        head_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PublicBenefitActivity.this,CharityActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initTabLinister() {
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.equals(tabs.getTabAt(0))){

                    if (projectList != null){
                        getPublicbenefitData();
                    }

                }else if (tab.equals(tabs.getTabAt(1))){
                       getOneToOneData();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getOneToOneData() {
        datas.clear();
        DownLoadOneToOneUtils benefitDataUtils = new DownLoadOneToOneUtils(this);
        benefitDataUtils.downOneToOneData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OneToOneData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OneToOneData oneToOneData) {
                        for (int i = 0; i <oneToOneData.getData().size() ; i++) {
                            Map map = new HashMap();
                            map.put("id",oneToOneData.getData().get(i).getId());
                            map.put("image",oneToOneData.getData().get(i).getMainPic());
                            map.put("title",oneToOneData.getData().get(i).getTitle());
                            map.put("titles",oneToOneData.getData().get(i).getInfo());
                            datas.add(map);
                        }
                        adapter1 = new PublicBenefitAdapter1(PublicBenefitActivity.this,datas);
                        public_benefit_list.setAdapter(adapter1);
                        adapter1.notifyDataSetChanged();
                    }
                });
    }

    private void getPublicbenefitData() {
        datas1.clear();
        DownLoadPublicBenefitDataUtils benefitDataUtils = new DownLoadPublicBenefitDataUtils(this);
        benefitDataUtils.downPublicBenefitData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PublicBenefitData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PublicBenefitData publicBenefitData) {
                        for (int i = 0; i <publicBenefitData.getData().size() ; i++) {
                            Map map = new HashMap();
                            map.put("id",publicBenefitData.getData().get(i).getId());
                            map.put("image",publicBenefitData.getData().get(i).getMainPic());
                            map.put("title",publicBenefitData.getData().get(i).getTitle());
                            datas1.add(map);
                        }
                        adapter = new PublicBenefitAdapter(PublicBenefitActivity.this,datas1);
                        public_benefit_list.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void initHeadView() {
        View view = LayoutInflater.from(this).inflate(R.layout.public_benefit_headview,null);
        public_benefit_list.addHeaderView(view);
        tabs = (TabLayout) view.findViewById(R.id.tabs);
        head_image = (ImageView) view.findViewById(R.id.head_image);
    }
    private void initAdapter(List<Map> data) {
        adapter = new PublicBenefitAdapter(this,data);
        public_benefit_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    private void initView() {
        public_benefit_list = (ListView) findViewById(R.id.public_benefit_list);
        public_benefit_list.setDividerHeight(0);
        projectList = new ArrayList<Map>();
        datas = new ArrayList<Map>();
        datas1 = new ArrayList<Map>();
        getPublicbenefitData();
    }
}
