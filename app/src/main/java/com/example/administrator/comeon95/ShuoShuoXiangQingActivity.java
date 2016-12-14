package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.GoodInfoPingLunAdapter;
import RetrofitData.DownLoadGoodInfoPingLun;
import javabeans.GoodInfoPingLun;
import javabeans.SerializableMap;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.GetShare;

public class ShuoShuoXiangQingActivity extends AppCompatActivity {
    private ListView shuoshuo_list;
    private ImageView person_icon,about_return,share;
    private TextView name,time,location,content,count;
    private LinearLayout images_contain,apple;
    private SerializableMap data;
    private int id;
    private List pinglunList;
    private String name_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuo_shuo_xiang_qing);
        initView();
        initData();
        updateHeadView();
        initAdapter();
        initLinister();
    }

    private void initLinister() {
        about_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetShare.showShare(ShuoShuoXiangQingActivity.this,name_text);
            }
        });
    }

    private void updateHeadView() {
        List<ImageView> images = new ArrayList<>();
        Picasso.with(ShuoShuoXiangQingActivity.this).load((String) data.getMap().get("icon")).into(person_icon);
        name_text = (String)data.getMap().get("name");
        name.setText(name_text);
        time.setText((String)data.getMap().get("time"));
        location.setText((String)data.getMap().get("location"));
        content.setText((String)data.getMap().get("info"));
        if (data.getMap().get("pic1") != null &&data.getMap().get("pic1") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic1")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic2") != null &&data.getMap().get("pic2") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic2")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic3") != null &&data.getMap().get("pic3") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic3")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic4") != null &&data.getMap().get("pic4") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic4")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic5") != null &&data.getMap().get("pic5") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic5")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic6") != null &&data.getMap().get("pic6") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic6")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic7") != null &&data.getMap().get("pic7") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic7")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic8") != null &&data.getMap().get("pic8") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic8")).into(imageView);
            images.add(imageView);
        }else if (data.getMap().get("pic9") != null &&data.getMap().get("pic9") != ""){
            ImageView imageView = new ImageView(this);
            Picasso.with(this).load((String) data.getMap().get("pic9")).into(imageView);
            images.add(imageView);
        }
        for (int i = 0; i < images.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            images_contain.addView(images.get(i),params);
        }
    }

    private void initAdapter() {
        DownLoadGoodInfoPingLun infoPingLun = new DownLoadGoodInfoPingLun(this,id);
        infoPingLun.downLoadGoodPingLun(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodInfoPingLun>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodInfoPingLun goodInfoPingLun) {
                        if (goodInfoPingLun.getData().size() == 0){
                            apple.setVisibility(View.VISIBLE);
                        }else {
                            apple.setVisibility(View.GONE);
                        }
                        count.setText("("+goodInfoPingLun.getData().size()+")");
                        for (int i = 0; i <goodInfoPingLun.getData().size() ; i++) {
                            Map<String,String> map = new HashMap();
                            map.put("pic",goodInfoPingLun.getData().get(i).getHeadPic());
                            map.put("name",goodInfoPingLun.getData().get(i).getName());
                            map.put("time",goodInfoPingLun.getData().get(i).getInputTime());
                            map.put("content",goodInfoPingLun.getData().get(i).getInfo());
                            pinglunList.add(map);
                        }
                        GoodInfoPingLunAdapter adapter = new GoodInfoPingLunAdapter(ShuoShuoXiangQingActivity.this,pinglunList);
                        shuoshuo_list.setAdapter(adapter);
                    }
                });
    }

    private void initData() {
        data = (SerializableMap) getIntent().getSerializableExtra("data");
        id = (int) data.getMap().get("id");
    }

    private void initView() {
        shuoshuo_list = (ListView) findViewById(R.id.shuoshuo_list);
        about_return = (ImageView) findViewById(R.id.about_return);
        share = (ImageView) findViewById(R.id.share);
        apple = (LinearLayout) findViewById(R.id.apple);
        pinglunList = new ArrayList();
        View view = LayoutInflater.from(this).inflate(R.layout.shuoshuo_headview,null);
        person_icon = (ImageView) view.findViewById(R.id.person_icon);
        name = (TextView) view.findViewById(R.id.name);
        time = (TextView) view.findViewById(R.id.time);
        location = (TextView) view.findViewById(R.id.location);
        content = (TextView) view.findViewById(R.id.content);
        count = (TextView) view.findViewById(R.id.count);
        images_contain = (LinearLayout) view.findViewById(R.id.images_contain);
        shuoshuo_list.addHeaderView(view);
    }
}
