package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import RetrofitData.DownLoadOneToOneImageUtils;
import RetrofitData.DownLoadPublicBenefitOneToOneItemDataUtils;
import javabeans.PublicBenefitOneToOneImage;
import javabeans.PublicBenefitOneToOneItemData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

public class PublicBenefitOneToOneActivity extends AppCompatActivity {
    private int a;
    private ImageView user_icon,image;
    private TextView name,time,location,text1,text2,sound,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_benefit_one_to_one);
        init();
        initData();
    }
    private void init() {
        Intent intent = getIntent();
        a = intent.getIntExtra("id",1);
        user_icon = (ImageView) findViewById(R.id.user_icon);
        image = (ImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.name);
        time = (TextView) findViewById(R.id.time);
        location = (TextView) findViewById(R.id.location);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        sound = (TextView) findViewById(R.id.sound);
        link = (TextView) findViewById(R.id.link);
    }
    private void initData() {
        DownLoadPublicBenefitOneToOneItemDataUtils itemDataUtils = new DownLoadPublicBenefitOneToOneItemDataUtils(this);
        itemDataUtils.downPublicBenefitOneToOneItemData(GetAddress.PATH,a)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PublicBenefitOneToOneItemData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PublicBenefitOneToOneItemData publicBenefitOneToOneItemData) {
                        Picasso.with(PublicBenefitOneToOneActivity.this).load(publicBenefitOneToOneItemData.getObj().getHeadPic()).into(user_icon);
                        name.setText(publicBenefitOneToOneItemData.getObj().getName());
                        time.setText(publicBenefitOneToOneItemData.getObj().getInputTime());
                        location.setText(publicBenefitOneToOneItemData.getObj().getLocation());
                        text1.setText(publicBenefitOneToOneItemData.getObj().getInfo());
                        text2.setText(publicBenefitOneToOneItemData.getObj().getLive());
                        sound.setText(publicBenefitOneToOneItemData.getObj().getSound());
                        link.setText(publicBenefitOneToOneItemData.getObj().getLink());
                    }
                });
        DownLoadOneToOneImageUtils imageUtils = new DownLoadOneToOneImageUtils(this);
        imageUtils.downLoadImageData(GetAddress.PATH,a)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PublicBenefitOneToOneImage>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PublicBenefitOneToOneImage publicBenefitOneToOneImage) {
                        Picasso.with(PublicBenefitOneToOneActivity.this).load(publicBenefitOneToOneImage.getData().get(0).getPic()).into(image);
                    }
                });
    }


}
