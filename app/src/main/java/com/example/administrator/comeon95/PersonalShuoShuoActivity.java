package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.BaiCircleAdapter;
import RetrofitData.DownLoadPersonalShuoDataUtil;
import javabeans.PersonShuoData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

public class PersonalShuoShuoActivity extends AppCompatActivity {
    private ListView personal_xiangqing;
    private TextView name,guanzhu_count,fensi_count,qianming,location,guanzhu_button,liao_button;
    private ImageView icon;
    private String names,pics,words,locations,backgrounds,guanzhus,zan,sexs,births;
    private int id;
    private RelativeLayout background;
    private View view;
    private List<Map<String, Object>> data,data_jiaoyu,data_chengzhang,data_weiyang,data_anquan,data_qinaggan,data_yunma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_shuo_shuo);
        initView();
        initDataUpdapteView();
        initLinister();
    }

    private void initLinister() {
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalShuoShuoActivity.this,PersonalActivity.class);
                intent.putExtra("name",names);
                intent.putExtra("sex",sexs);
                intent.putExtra("birth",births);
                intent.putExtra("word",words);
                intent.putExtra("background",backgrounds);
                startActivity(intent);
            }
        });
    }

    private void initDataUpdapteView() {
        DownLoadPersonalShuoDataUtil downLoadPersonalShuoDataUtil = new DownLoadPersonalShuoDataUtil(PersonalShuoShuoActivity.this);
        downLoadPersonalShuoDataUtil.downLoadPersonalShuoDataUtil(GetAddress.PATH, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PersonShuoData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PersonShuoData personShuoData) {
                        for (int i = 0; i < personShuoData.getData().size(); i++) {
                            Map<String, Object> map = new HashMap();
                            map.put("id", personShuoData.getData().get(i).getId());
                            map.put("icon", personShuoData.getData().get(i).getHeadPic());
                            map.put("name", personShuoData.getData().get(i).getTalkName());
                            map.put("time", personShuoData.getData().get(i).getTalkInputTime());
                            map.put("pic1", personShuoData.getData().get(i).getPic1());
                            map.put("pic2", personShuoData.getData().get(i).getPic2());
                            map.put("pic3", personShuoData.getData().get(i).getPic3());
                            map.put("pic4", personShuoData.getData().get(i).getPic4());
                            map.put("pic5", personShuoData.getData().get(i).getPic5());
                            map.put("pic6", personShuoData.getData().get(i).getPic6());
                            map.put("pic7", personShuoData.getData().get(i).getPic7());
                            map.put("pic8", personShuoData.getData().get(i).getPic8());
                            map.put("pic9", personShuoData.getData().get(i).getPic9());
                            map.put("info", personShuoData.getData().get(i).getTalkInfo());
                            map.put("location", personShuoData.getData().get(i).getLocation());
                            map.put("zancount", personShuoData.getData().get(i).getZanNum() + "");
                            map.put("comcount", personShuoData.getData().get(i).getComNum() + "");
                            data.add(map);
                        }
                        BaiCircleAdapter adapter = new BaiCircleAdapter(PersonalShuoShuoActivity.this,data);
                        personal_xiangqing.setAdapter(adapter);
                        personal_xiangqing.addHeaderView(view);
                    }
                });
    }
    private void initView() {
        data = new ArrayList<>();
        id = getIntent().getIntExtra("id",3);
        names = getIntent().getStringExtra("name");
        pics = getIntent().getStringExtra("pic");
        words = getIntent().getStringExtra("word");
        locations = getIntent().getStringExtra("location");
        backgrounds = getIntent().getStringExtra("background");
        guanzhus = getIntent().getStringExtra("guanzhu");
        sexs = getIntent().getStringExtra("sex");
        births = getIntent().getStringExtra("birth");
        zan = getIntent().getStringExtra("zan");
        personal_xiangqing = (ListView) findViewById(R.id.personal_xiangqing);
        view = LayoutInflater.from(PersonalShuoShuoActivity.this).inflate(R.layout.personal_xiangqing,null);
        name = (TextView) view.findViewById(R.id.name);
        guanzhu_count = (TextView) view.findViewById(R.id.guanzhu_count);
        fensi_count = (TextView) view.findViewById(R.id.fensi_count);
        qianming = (TextView) view.findViewById(R.id.qianming);
        location = (TextView) view.findViewById(R.id.location);
        guanzhu_button = (TextView) view.findViewById(R.id.guanzhu_button);
        liao_button = (TextView) view.findViewById(R.id.liao_button);
        background = (RelativeLayout) view.findViewById(R.id.aboutlb);
        icon = (ImageView) view.findViewById(R.id.icon);
        name.setText(names);
        qianming.setText(words);
        if (guanzhus == null|| guanzhus == "null"){
            guanzhus = "0";
        }
        if (zan == null|| guanzhus == "null") {
            zan = "0";
        }
        guanzhu_count.setText("关注 "+guanzhus);
        fensi_count.setText("粉丝 " +zan);
        location.setText(locations);
        location.setText(locations);
        Picasso.with(PersonalShuoShuoActivity.this).load(pics).into(icon);

    }
}
