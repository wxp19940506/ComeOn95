package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Adapters.BaiCircleAdapter;
import Adapters.BaiquanListAdapter;
import RetrofitData.DownLoadBaiQuanDataUtil;
import javabeans.BaiQuanData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ToastUtils;

public class BaiCircleActivity extends AppCompatActivity {
    private TabLayout tabs;
    private String[] tabstring;
    private RelativeLayout tuijianHead;
    private List<Map<String, Object>> data,data_jiaoyu,data_chengzhang,data_weiyang,data_anquan,data_qinaggan,data_yunma;
    private ListView dataView;
    private ImageView baiquan_return,xiaoxi2;
    private View view;
    private ListView baiquan_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_circle);
        initView();
        initCommand();
        initLinister();
        initHomePager();
    }

    private void initHomePager() {
        if (data != null && !data .equals("") ){
            BaiCircleAdapter adapter = new BaiCircleAdapter(BaiCircleActivity.this,data);
            baiquan_listview.setAdapter(adapter);
            baiquan_listview.addHeaderView(view);
        }
    }

    private void initLinister() {
        baiquan_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xiaoxi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaiCircleActivity.this,InformationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initTabLinister(final List data, final List data_jiaoyu, final List data_chengzhang, final List data_weiyang, final List data_anquan, final List data_qinaggan, final List data_yunma) {
      tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              BaiCircleAdapter adapter = null;
              if (tab.equals(tabs.getTabAt(0))){
                  tuijianHead.setVisibility(View.VISIBLE);
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data);
//                  initCommand();
              }else if (tab.equals(tabs.getTabAt(1))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_jiaoyu);
                  tuijianHead.setVisibility(View.GONE);
              }else if (tab.equals(tabs.getTabAt(2))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_chengzhang);
                  tuijianHead.setVisibility(View.GONE);
              }else if (tab.equals(tabs.getTabAt(3))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_weiyang);
                  tuijianHead.setVisibility(View.GONE);
              }else if (tab.equals(tabs.getTabAt(4))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_anquan);
                  tuijianHead.setVisibility(View.GONE);
              }else if (tab.equals(tabs.getTabAt(5))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_qinaggan);
                  tuijianHead.setVisibility(View.GONE);
              }else if (tab.equals(tabs.getTabAt(6))){
                  adapter = new BaiCircleAdapter(BaiCircleActivity.this,data_yunma);
                  tuijianHead.setVisibility(View.GONE);
              }

              baiquan_listview.setAdapter(adapter);
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });
    }

    private void initCommand() {
        DownLoadBaiQuanDataUtil baiQuanDataUtil = new DownLoadBaiQuanDataUtil(BaiCircleActivity.this);
        baiQuanDataUtil.downBaiQuanData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaiQuanData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaiQuanData baiQuanData) {
                        for (int i = 0; i < baiQuanData.getData().size(); i++) {
                                Map<String,Object> map = new HashMap();
                                map.put("id",baiQuanData.getData().get(i).getId());
                                map.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map.put("name",baiQuanData.getData().get(i).getTalkName());
                                map.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map.put("location",baiQuanData.getData().get(i).getLocation());
                                map.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data.add(map);
                            if (i % 6 == 0){
                                Map<String,Object> map1 = new HashMap();
                                map1.put("id",baiQuanData.getData().get(i).getId());
                                map1.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map1.put("name",baiQuanData.getData().get(i).getTalkName());
                                map1.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map1.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map1.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map1.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map1.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map1.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map1.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map1.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map1.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map1.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map1.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map1.put("location",baiQuanData.getData().get(i).getLocation());
                                map1.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map1.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_jiaoyu.add(map1);
                            }else if (i %6 == 1){
                                Map<String,Object> map2 = new HashMap();
                                map2.put("id",baiQuanData.getData().get(i).getId());
                                map2.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map2.put("name",baiQuanData.getData().get(i).getTalkName());
                                map2.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map2.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map2.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map2.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map2.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map2.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map2.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map2.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map2.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map2.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map2.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map2.put("location",baiQuanData.getData().get(i).getLocation());
                                map2.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map2.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_chengzhang.add(map2);
                            }else if (i %6 == 2){
                                Map<String,Object> map3 = new HashMap();
                                map3.put("id",baiQuanData.getData().get(i).getId());
                                map3.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map3.put("name",baiQuanData.getData().get(i).getTalkName());
                                map3.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map3.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map3.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map3.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map3.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map3.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map3.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map3.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map3.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map3.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map3.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map3.put("location",baiQuanData.getData().get(i).getLocation());
                                map3.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map3.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_weiyang.add(map3);
                            }else if (i %6 == 3){
                                Map<String,Object> map4 = new HashMap();
                                map4.put("id",baiQuanData.getData().get(i).getId());
                                map4.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map4.put("name",baiQuanData.getData().get(i).getTalkName());
                                map4.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map4.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map4.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map4.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map4.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map4.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map4.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map4.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map4.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map4.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map4.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map4.put("location",baiQuanData.getData().get(i).getLocation());
                                map4.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map4.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_anquan.add(map4);
                            }else if (i %6 == 4){
                                Map<String,Object> map5 = new HashMap();
                                map5.put("id",baiQuanData.getData().get(i).getId());
                                map5.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map5.put("name",baiQuanData.getData().get(i).getTalkName());
                                map5.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map5.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map5.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map5.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map5.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map5.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map5.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map5.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map5.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map5.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map5.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map5.put("location",baiQuanData.getData().get(i).getLocation());
                                map5.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map5.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_qinaggan.add(map5);
                            }else if (i %6 == 5){
                                Map<String,Object> map6 = new HashMap();
                                map6.put("id",baiQuanData.getData().get(i).getId());
                                map6.put("icon",baiQuanData.getData().get(i).getHeadPic());
                                map6.put("name",baiQuanData.getData().get(i).getTalkName());
                                map6.put("time",baiQuanData.getData().get(i).getTalkInputTime());
                                map6.put("pic1",baiQuanData.getData().get(i).getPic1());
                                map6.put("pic2",baiQuanData.getData().get(i).getPic2());
                                map6.put("pic3",baiQuanData.getData().get(i).getPic3());
                                map6.put("pic4",baiQuanData.getData().get(i).getPic4());
                                map6.put("pic5",baiQuanData.getData().get(i).getPic5());
                                map6.put("pic6",baiQuanData.getData().get(i).getPic6());
                                map6.put("pic7",baiQuanData.getData().get(i).getPic7());
                                map6.put("pic8",baiQuanData.getData().get(i).getPic8());
                                map6.put("pic9",baiQuanData.getData().get(i).getPic9());
                                map6.put("info",baiQuanData.getData().get(i).getTalkInfo());
                                map6.put("location",baiQuanData.getData().get(i).getLocation());
                                map6.put("zancount",baiQuanData.getData().get(i).getZanNum()+"");
                                map6.put("comcount",baiQuanData.getData().get(i).getComNum()+"");
                                data_yunma.add(map6);
                            }
                        }
                        BaiCircleAdapter adapter = new BaiCircleAdapter(BaiCircleActivity.this,data);
                        baiquan_listview.setAdapter(adapter);
                        initTabLinister(data,data_jiaoyu,data_chengzhang,data_weiyang,data_anquan,data_qinaggan,data_yunma);
                    }
                });
    }



    private void initView() {
        view =  LayoutInflater.from(BaiCircleActivity.this).inflate(R.layout.baiquan_headview,null);
        tabs = (TabLayout) view.findViewById(R.id.tabs);
        xiaoxi2 = (ImageView) findViewById(R.id.xiaoxi2);
        tuijianHead = (RelativeLayout) view.findViewById(R.id.tuijianHead);
        //data_jiaoyu,data_chengzhang,data_weiyang,data_anquan,data_qinaggan,data_yunma
        data = new ArrayList();
        data_jiaoyu = new ArrayList();
        data_chengzhang = new ArrayList();
        data_weiyang = new ArrayList();
        data_anquan = new ArrayList();
        data_qinaggan = new ArrayList();
        data_yunma = new ArrayList();
        baiquan_return = (ImageView) findViewById(R.id.baiquan_return);
        baiquan_listview = (ListView) findViewById(R.id.baiquan_listview);
        tabstring = new String[]{"推荐","教育","成长","喂养","安全","情感","孕妈"};
        for (int i = 0; i < tabstring.length; i++) {
            tabs.addTab(tabs.newTab().setText(tabstring[i]));
        }

    }
}
