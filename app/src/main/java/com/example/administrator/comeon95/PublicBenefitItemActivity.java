package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import RetrofitData.DownLoadPublicBenefitItemDataUtil;
import javabeans.PublicBenefitItemdata;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

public class PublicBenefitItemActivity extends AppCompatActivity {
    private Intent intent;
    private TextView title,jieshao1,need,problem,address,sound,more,less;
    private ImageView icon1,icon2;
    private LinearLayout somes;
    int a,count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_benefit_item);
        initView();
        initData(a);
        initLinister();
    }

    private void initLinister() {
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               somes.setVisibility(View.VISIBLE);
                less.setVisibility(View.VISIBLE);
                more.setVisibility(View.GONE);
            }
        });
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                somes.setVisibility(View.GONE);
                less.setVisibility(View.GONE);
                more.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initView() {
        intent = getIntent();
        a = intent.getIntExtra("id",1);
        title = (TextView) findViewById(R.id.title);
        jieshao1 = (TextView) findViewById(R.id.jieshao1);
        need = (TextView) findViewById(R.id.need);
        problem = (TextView) findViewById(R.id.problem);
        address = (TextView) findViewById(R.id.address);
        more = (TextView) findViewById(R.id.more);
        less = (TextView) findViewById(R.id.less);
        sound = (TextView) findViewById(R.id.sound);
        icon1 = (ImageView) findViewById(R.id.icon1);
        icon2 = (ImageView) findViewById(R.id.icon2);
        somes = (LinearLayout) findViewById(R.id.somes);
    }
    private void initData(Integer o) {
        DownLoadPublicBenefitItemDataUtil downLoadPublicBenefitItemDataUtil = new DownLoadPublicBenefitItemDataUtil(this,o);
        downLoadPublicBenefitItemDataUtil.downLoadPublicBenefitItemdata(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PublicBenefitItemdata>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PublicBenefitItemdata publicBenefitItemData) {
                        title.setText(publicBenefitItemData.getData().get(0).getTitle());
                        jieshao1.setText(publicBenefitItemData.getData().get(0).getBackground());
                        need.setText(publicBenefitItemData.getData().get(0).getNeed());
                        problem.setText(publicBenefitItemData.getData().get(0).getQuestion());
                        address.setText(publicBenefitItemData.getData().get(0).getAim());
                        sound.setText(publicBenefitItemData.getData().get(0).getSound());
                        Picasso.with(PublicBenefitItemActivity.this).load(publicBenefitItemData.getData().get(0).getPic()).into(icon1);
                        Picasso.with(PublicBenefitItemActivity.this).load(publicBenefitItemData.getData().get(0).getMainPic()).into(icon2);
                    }
                });

    }
}
