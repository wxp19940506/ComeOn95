package com.example.administrator.comeon95;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import RetrofitData.DownLoadGoodYouXaunImagesDataUtil;
import javabeans.YouXuanImagesData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.GetShare;

public class YouXuanGoodActivity extends AppCompatActivity {
    private Intent intent;
    int a ;
    String tiltes;
    String infos;
    double prices;
    double oldprices;
    private ImageView good_icon,share;
    private TextView title,info,price,oldprice;
    private LinearLayout images_contain;
    private Button goumai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_xuan_good);
        init();//holder.price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        initData();
        initLinister(a);
    }

    private void initLinister(final int a) {
        goumai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YouXuanGoodActivity.this,GoodInfoActivity.class);
                intent.putExtra("id",a);
                intent.putExtra("name",tiltes);
                intent.putExtra("prices",prices);
                startActivity(intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetShare.showShare(YouXuanGoodActivity.this,tiltes);
            }
        });
    }

    private void initData() {
        DownLoadGoodYouXaunImagesDataUtil imagesDataUtil = new DownLoadGoodYouXaunImagesDataUtil(YouXuanGoodActivity.this);
        imagesDataUtil.downLoadYouXuanImagesData(GetAddress.PATH,a)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<YouXuanImagesData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(YouXuanImagesData youXuanImagesData) {
                        for (int i = 0; i < youXuanImagesData.getData().size()-1; i++) {
                            ImageView imageview = new ImageView(YouXuanGoodActivity.this);
                            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                            imageview.setMaxWidth(GetAddress.sp2px(YouXuanGoodActivity.this,300));
                            imageview.setMaxHeight(GetAddress.sp2px(YouXuanGoodActivity.this,500));
                            Picasso.with(YouXuanGoodActivity.this).load(youXuanImagesData.getData().get(i).getPic()).into(imageview);
                            images_contain.addView(imageview);
                        }
                        Picasso.with(YouXuanGoodActivity.this).load(youXuanImagesData.getData().get(youXuanImagesData.getData().size()-1).getPic()).into(good_icon);
                    }
                });
    }

    private void init() {
        intent = getIntent();
        a = intent.getIntExtra("id",1);
        tiltes = intent.getStringExtra("title");
        infos = intent.getStringExtra("info");
        prices = intent.getDoubleExtra("price",20.0);
        oldprices = intent.getDoubleExtra("discountprice",10.0);
        images_contain = (LinearLayout) findViewById(R.id.images_contain);
        good_icon = (ImageView) findViewById(R.id.good_icon);
        share = (ImageView) findViewById(R.id.share);
        title = (TextView) findViewById(R.id.title);
        info = (TextView) findViewById(R.id.info);
        price = (TextView) findViewById(R.id.price);
        oldprice = (TextView) findViewById(R.id.oldprice);
        title.setText(tiltes);
        info.setText(infos);
        price.setText(oldprices+"");
        oldprice.setText(prices+"");
        goumai = (Button) findViewById(R.id.goumai);
        oldprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
