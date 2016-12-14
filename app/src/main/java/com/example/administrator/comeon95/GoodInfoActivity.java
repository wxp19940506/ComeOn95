package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapters.GoodInfoPingLunAdapter;
import RetrofitData.DownLoadGoodInfoImages;
import RetrofitData.DownLoadGoodInfoPingLun;
import RetrofitData.DownLoadGoodInfoUser;
import RetrofitData.DownLoadGuiGeUtil;
import RetrofitData.DownLoadKuanshiUtil;
import cn.sharesdk.onekeyshare.OnekeyShare;
import interfaces.Get;
import javabeans.GoodInfoImages;
import javabeans.GoodInfoPingLun;
import javabeans.GoodInfoUser;
import javabeans.GuiGeData;
import javabeans.KuanshiData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.GetShare;
import uiutils.ToastUtils;

public class GoodInfoActivity extends AppCompatActivity {
    private ListView good_images;
    private View view,view1;
    private List<Map<String,String>> list,pinglunList;
    private ImageView per_icon,share;
    private TextView name,time,location,title1,price1;
    private LinearLayout images_contain,button_layout,guige_contain,kuanshi_contain;
    int id,a,b;
    String title,price;
    private Button goumai;
    private HashMap<String,String> map;
    private ImageView about_return;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info);
        initView();
        initData();
        setFooterViewData();
        initListHeadFooterView();
        initLinister();
    }

    private void initLinister() {
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetShare.showShare(GoodInfoActivity.this,title);
            }
        });
        goumai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1 = LayoutInflater.from(GoodInfoActivity.this).inflate(R.layout.gounai_popupwin,null);
                title1 = (TextView) view1.findViewById(R.id.title);
                price1 = (TextView) view1.findViewById(R.id.price);
                guige_contain = (LinearLayout) view1.findViewById(R.id.guige_contain);
                kuanshi_contain = (LinearLayout) view1.findViewById(R.id.kuanshi_contain);
                setguige_contain_data();
                setkuanshi_contain_data();
                final PopupWindow popupWindow = new PopupWindow(view1,button_layout.getWidth(),GetAddress.sp2px(GoodInfoActivity.this,280));
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.showAtLocation(button_layout, Gravity.BOTTOM,0,0);
                final ImageView dismiss = (ImageView) view1.findViewById(R.id.dismiss);
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
        about_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setkuanshi_contain_data() {
        DownLoadKuanshiUtil kuanshiUtil = new DownLoadKuanshiUtil(GoodInfoActivity.this);
        kuanshiUtil.downLoadKuanshiUtil(GetAddress.PATH,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<KuanshiData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(KuanshiData kuanshiData) {
                        for (int i = 0; i <kuanshiData.getData().size() ; i++) {
                            View view = LayoutInflater.from(GoodInfoActivity.this).inflate(R.layout.color_type_item,null);
                            final TextView textView = (TextView) view.findViewById(R.id.color_type);
                            textView.setText(kuanshiData.getData().get(i).getType());
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (a %2 == 0 ){
                                        textView.setEnabled(false);
                                    }else if (a % 2 ==1){
                                        textView.setEnabled(true);
                                    }
                                    a++;
                                }
                            });
                            kuanshi_contain.addView(view);
                        }

                    }
                });
    }

    private void setguige_contain_data() {
        DownLoadGuiGeUtil guiGeUtil = new DownLoadGuiGeUtil(GoodInfoActivity.this);
        guiGeUtil.downLoadGuiGeUtil(GetAddress.PATH,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GuiGeData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GuiGeData guiGeData) {
                        for (int i = 0; i < guiGeData.getData().size() ; i++) {
                            View view = LayoutInflater.from(GoodInfoActivity.this).inflate(R.layout.color_type_item,null);
                            final TextView textView = (TextView) view.findViewById(R.id.color_type);
                            textView.setText(guiGeData.getData().get(i).getRule());
                            textView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if (b %2 == 0 ){
                                        textView.setEnabled(false);
                                    }else if (b % 2 ==1){
                                        textView.setEnabled(true);
                                    }
                                    b++;
                                }
                            });
                            guige_contain.addView(view);
                        }
                    }
                });
    }

    private void initListHeadFooterView() {
        view = LayoutInflater.from(this).inflate(R.layout.goodinfo_headview,null);
        per_icon = (ImageView) view.findViewById(R.id.per_icon);
        name = (TextView) view.findViewById(R.id.name);
        time = (TextView) view.findViewById(R.id.time);
        location = (TextView) view.findViewById(R.id.location);
        images_contain = (LinearLayout) view.findViewById(R.id.images_contain);
        images_contain.setOrientation(LinearLayout.VERTICAL);
        setHeadViewData();
        //view1 = LayoutInflater.from(this).inflate(R.layout.goodinfo_foootview,null);
        good_images.addHeaderView(view);
//        pinglunlist = (ListView) view1.findViewById(R.id.pinglunlist);

       // good_images.addFooterView(view1);
    }
//评论的数据
    private void setFooterViewData() {
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
                        for (int i = 0; i <goodInfoPingLun.getData().size() ; i++) {
                            Map<String,String> map = new HashMap();
                            map.put("pic",goodInfoPingLun.getData().get(i).getHeadPic());
                            map.put("name",goodInfoPingLun.getData().get(i).getName());
                            map.put("time",goodInfoPingLun.getData().get(i).getInputTime());
                            map.put("content",goodInfoPingLun.getData().get(i).getInfo());
                            pinglunList.add(map);
                        }
                        GoodInfoPingLunAdapter adapter = new GoodInfoPingLunAdapter(GoodInfoActivity.this,pinglunList);
                        good_images.setAdapter(adapter);
                    }
                });

    }
        //  商品详情
    private void setHeadViewData() {
        DownLoadGoodInfoUser infoUser = new DownLoadGoodInfoUser(GoodInfoActivity.this,id);
        infoUser.downLoadGoodInfoUser(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodInfoUser>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodInfoUser goodInfoUser) {
                        Picasso.with(GoodInfoActivity.this).load(goodInfoUser.getObj().getHeadPic()).into(per_icon);
                        name.setText(goodInfoUser.getObj().getName());
                        time.setText(goodInfoUser.getObj().getInputTime());
                        location.setText(goodInfoUser.getObj().getLocation());
                    }
                });
    }
//商品详情的图片
    private void initData() {
        DownLoadGoodInfoImages infoImages = new DownLoadGoodInfoImages(GoodInfoActivity.this);
        infoImages.downLoadGoodInfoImages(GetAddress.PATH,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodInfoImages>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodInfoImages goodInfoImages) {
                        for (int i = 0; i < goodInfoImages.getData().size(); i++) {
                            if (i % 2 == 0){
                                map= new HashMap();
                                map.put("image1",goodInfoImages.getData().get(i).getPic());
                            }else if ( i % 2 == 1){
                                map.put("image2",goodInfoImages.getData().get(i).getPic());
                                list.add(map);
                            }

                        }
                        Log.e("list",list.toString()+"");
                        for (int j = 0; j < list.size(); j++) {
                            LinearLayout linearLayout = new LinearLayout(GoodInfoActivity.this);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GetAddress.sp2px(GoodInfoActivity.this,0),GetAddress.sp2px(GoodInfoActivity.this,120));
                            LinearLayout.LayoutParams root_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,GetAddress.sp2px(GoodInfoActivity.this,0));
                            root_params.weight = 1;
                            params.weight = 1;
                            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                            ImageView imageView1 = new ImageView(GoodInfoActivity.this);
                            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                            Picasso.with(GoodInfoActivity.this).load(list.get(j).get("image1")).into(imageView1);
                            ImageView imageView2 = new ImageView(GoodInfoActivity.this);
                            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            Picasso.with(GoodInfoActivity.this).load(list.get(j).get("image2")).into(imageView2);
                            linearLayout.addView(imageView1,params);
                            linearLayout.addView(imageView2,params);
                            images_contain.addView(linearLayout,root_params);
                        }

                    }
                });
    }

    private void initView() {
        good_images = (ListView) findViewById(R.id.good_images);
        about_return = (ImageView) findViewById(R.id.about_return);
        share = (ImageView) findViewById(R.id.share);
        list = new ArrayList<>();
        pinglunList = new ArrayList<>();
        id = getIntent().getIntExtra("id",2);
        title = getIntent().getStringExtra("name");
        price = getIntent().getStringExtra("prices");
        goumai = (Button) findViewById(R.id.goumai);
        button_layout = (LinearLayout) findViewById(R.id.button_layout);
    }
}
