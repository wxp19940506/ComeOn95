package com.example.administrator.comeon95;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import pl.droidsonroids.gif.GifImageView;
import uiutils.GetAddress;
import uiutils.ThreadUtils;


public class DiscoverTwothSplash extends AppCompatActivity implements View.OnClickListener {
    private ImageView  right,ma,dang,qian,left,mei,shoe,makeup,bag,aftermom,yelloface,aochengle,mom,shandow,image1,image2,image3,image4,btn3,q1,q2,q3,q4,q5;
    private RelativeLayout mamaqian,mamahou,diaocha;
    private GifImageView gifView,gifView1;
    private RelativeLayout return_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_twoth_splash);
        initView();
        animationOfRightAndLeft(right,left);
        animationOfDangMaQian(dang,ma,qian,mei);
        animationOfBottomButton(shoe,makeup,bag);
        initLinister();
    }

    private void animationOfAfterMom() {
        //GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,-100.0f),GetAddress.sp2px(this,-200.0f)
        ObjectAnimator oa = ObjectAnimator.ofFloat(aftermom, "translationX", GetAddress.sp2px(this,20.0f),GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,70.0f),GetAddress.sp2px(this,80.0f),GetAddress.sp2px(this,100.0f));
        oa.setDuration(1000);
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(aochengle, "translationX", GetAddress.sp2px(this,-10.0f),GetAddress.sp2px(this,-20.0f),GetAddress.sp2px(this,-25.0f),GetAddress.sp2px(this,-30.0f));
        oa1.setDuration(1000);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(yelloface, "translationY", GetAddress.sp2px(this,20.0f),GetAddress.sp2px(this,50.0f),GetAddress.sp2px(this,70.0f),GetAddress.sp2px(this,120.0f),GetAddress.sp2px(this,140.0f),GetAddress.sp2px(this,150.0f),GetAddress.sp2px(this,140.0f),GetAddress.sp2px(this,130.0f),GetAddress.sp2px(this,105.0f));
        oa2.setDuration(1200);
        AnimatorSet set = new AnimatorSet();
        set.play(oa2).after(oa).after(oa1);
        set.start();
        PropertyValuesHolder pvh1= PropertyValuesHolder.ofFloat( "translationX",  GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,-40.0f), GetAddress.sp2px(this,-60.0f),GetAddress.sp2px(this,-100.0f),GetAddress.sp2px(this,-120.0f));
        PropertyValuesHolder pvh2= PropertyValuesHolder.ofFloat( "translationY",GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,-40.0f), GetAddress.sp2px(this,-60.0f));
        ObjectAnimator
                .ofPropertyValuesHolder(image1, pvh1, pvh2)
                .setDuration(1200).start();
        PropertyValuesHolder pvh3= PropertyValuesHolder.ofFloat( "translationX",  GetAddress.sp2px(this,20.0f), GetAddress.sp2px(this,40.0f), GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,100.0f),GetAddress.sp2px(this,120.0f));
        PropertyValuesHolder pvh4= PropertyValuesHolder.ofFloat( "translationY", GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,-40.0f), GetAddress.sp2px(this,-60.0f));
        ObjectAnimator
                .ofPropertyValuesHolder(image2, pvh3, pvh4)
                .setDuration(1200).start();
        PropertyValuesHolder pvh5= PropertyValuesHolder.ofFloat( "translationX",  GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,-40.0f), GetAddress.sp2px(this,-60.0f),GetAddress.sp2px(this,-100.0f),GetAddress.sp2px(this,-120.0f));
        PropertyValuesHolder pvh6= PropertyValuesHolder.ofFloat( "translationY", GetAddress.sp2px(this,20.0f), GetAddress.sp2px(this,40.0f), GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,90.0f),GetAddress.sp2px(this,130.0f));
        ObjectAnimator
                .ofPropertyValuesHolder(image3, pvh5, pvh6)
                .setDuration(1200).start();
        PropertyValuesHolder pvh7= PropertyValuesHolder.ofFloat( "translationX", GetAddress.sp2px(this,20.0f), GetAddress.sp2px(this,40.0f), GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,100.0f),GetAddress.sp2px(this,120.0f));
        PropertyValuesHolder pvh8= PropertyValuesHolder.ofFloat( "translationY", GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,40.0f), GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,90.0f),GetAddress.sp2px(this,130.0f));
        ObjectAnimator
                .ofPropertyValuesHolder(image4, pvh7, pvh8)
                .setDuration(1200).start();
    }

    private void animationOfShandow() {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(shandow, "zhy",0.7f, 0.8f,0.9f,1.2f,0.9f,0.8f,0.7f);
        anim1.setRepeatCount(ValueAnimator.INFINITE);
        anim1.start();
        anim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                shandow.setScaleX(cVal);
                shandow.setScaleY(cVal);
            }
        });
    }

    private void initLinister() {
        right.setOnClickListener(this);
        ma.setOnClickListener(this);
        dang.setOnClickListener(this);
        qian.setOnClickListener(this);
        left.setOnClickListener(this);
        mei.setOnClickListener(this);
        shoe.setOnClickListener(this);
        makeup.setOnClickListener(this);
        bag.setOnClickListener(this);
        //aftermom,yelloface,aochengle,mom,shandow,image1,image2,image3,image4
        aftermom.setOnClickListener(this);
        yelloface.setOnClickListener(this);
        aochengle.setOnClickListener(this);
        mom.setOnClickListener(this);
        shandow.setOnClickListener(this);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        gifView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSomeUiState();
            }
        });
        gifView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDiaochaState();
            }
        });
        return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void animationOfBottomButton(ImageView shoe, ImageView makeup, ImageView bag) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(shoe, "rotation", 0.0f, 10.0f,15.0f,20.0f,15.0f,0.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(makeup, "rotation",0.0f, 10.0f,15.0f,20.0f,15.0f,0.0f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(bag, "rotation", 0.0f, 10.0f,15.0f,20.0f,15.0f,0.0f);
        anim1.setRepeatMode(ObjectAnimator.RESTART);
        anim2.setRepeatMode(ObjectAnimator.RESTART);
        anim3.setRepeatMode(ObjectAnimator.RESTART);
        anim1.setRepeatCount(ValueAnimator.INFINITE);
        anim2.setRepeatCount(ValueAnimator.INFINITE);
        anim3.setRepeatCount(ValueAnimator.INFINITE);
        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(anim1, anim2,anim3);
        animSet.start();
    }

    private void animationOfDangMaQian( ImageView dang, ImageView ma, ImageView qian,ImageView mei) {
        ObjectAnimator oa1 = ObjectAnimator.ofFloat(ma,"alpha",0.0f,0.6f,0.7f,0.8f,0.9f,1.0f);
        ObjectAnimator oa2 = ObjectAnimator.ofFloat(ma, "translationY",GetAddress.sp2px(this,20.0f),GetAddress.sp2px(this,50.0f),GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,90.0f), GetAddress.sp2px(this,100.0f));
        ObjectAnimator oa3 = ObjectAnimator.ofFloat(dang,"alpha",0.0f,0.6f,0.7f,0.8f,0.9f,1.0f);
        ObjectAnimator oa4 = ObjectAnimator.ofFloat(dang, "translationX", GetAddress.sp2px(this,20.0f), GetAddress.sp2px(this,40.0f),GetAddress.sp2px(this,50.0f),GetAddress.sp2px(this,80.0f));
        ObjectAnimator oa5 = ObjectAnimator.ofFloat(qian,"alpha",0.0f,0.6f,0.7f,0.8f,0.9f,1.0f);
        ObjectAnimator oa6 = ObjectAnimator.ofFloat(qian, "translationX",  GetAddress.sp2px(this,-20.0f), GetAddress.sp2px(this,-40.0f),GetAddress.sp2px(this,-50.0f),GetAddress.sp2px(this,-80.0f));
        ObjectAnimator oa7 = ObjectAnimator.ofFloat(mei,"alpha",0.0f,0.6f,0.7f,0.8f,0.9f,1.0f);
        ObjectAnimator oa8 = ObjectAnimator.ofFloat(mei, "translationX",GetAddress.sp2px(this,20.0f), GetAddress.sp2px(this,30.0f),GetAddress.sp2px(this,50.0f),GetAddress.sp2px(this,70.0f));
        AnimatorSet set = new AnimatorSet();
        set.play(oa1).with(oa2).with(oa3).with(oa4).with(oa5).with(oa6).after(oa7).with(oa8);
        set.start();

    }

    private void animationOfRightAndLeft(ImageView right, ImageView left) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(right,"alpha",0.0f,0.6f,1.0f,0.6f,0.0f).setDuration(1000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(left,"alpha",0.0f,0.6f,1.0f,0.6f,0.0f).setDuration(1000);
        animator1.setRepeatCount(ValueAnimator.INFINITE);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        animator1.start();
        animator2.start();
    }

    private void initView() {
        return_home = (RelativeLayout) findViewById(R.id.return_home);
        right = (ImageView) findViewById(R.id.right);
        ma = (ImageView) findViewById(R.id.ma);
        dang = (ImageView) findViewById(R.id.dang);
        qian = (ImageView) findViewById(R.id.qian);
        left = (ImageView) findViewById(R.id.left);
        mei = (ImageView) findViewById(R.id.mei);
        shoe = (ImageView) findViewById(R.id.shoe);
        makeup = (ImageView) findViewById(R.id.makeup);
        bag = (ImageView) findViewById(R.id.bag);
        //aftermom,yelloface,aochengle,mom,shandow,image1,image2,image3,image4
        aftermom = (ImageView) findViewById(R.id.aftermom);
        yelloface = (ImageView) findViewById(R.id.yelloface);
        aochengle = (ImageView) findViewById(R.id.aochengle);
        mom = (ImageView) findViewById(R.id.mom);
        shandow = (ImageView) findViewById(R.id.shandow);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        mamaqian = (RelativeLayout) findViewById(R.id.mamaqian);
        mamahou = (RelativeLayout) findViewById(R.id.mamahou);
        diaocha = (RelativeLayout) findViewById(R.id.diaocha);
        gifView = (GifImageView) findViewById(R.id.gifview);
        gifView1 = (GifImageView) findViewById(R.id.gifview1);
        btn3 = (ImageView) findViewById(R.id.btn3);
        q1 = (ImageView) findViewById(R.id.q1);
        q2 = (ImageView) findViewById(R.id.q2);
        q3 = (ImageView) findViewById(R.id.q3);
        q4 = (ImageView) findViewById(R.id.q4);
        q5 = (ImageView) findViewById(R.id.q5);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.right).into(right);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.ma).into(ma);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.dang).into(dang);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.qian).into(qian);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.left).into(left);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.mei).into(mei);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.shoe).into(shoe);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.makeup).into(makeup);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.bag).into(bag);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.shadow).into(shandow);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.after).into(aftermom);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.ao).into(aochengle);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.huang).into(yelloface);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.laundry).into(image1);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.toy2).into(image2);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.baby).into(image3);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.job).into(image4);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.dama).into(mom);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.btn3).into(btn3);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.q1).into(q1);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.q2).into(q2);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.q3).into(q3);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.q4).into(q4);
        Picasso.with(DiscoverTwothSplash.this).load(R.mipmap.q5).into(q5);

    }


    @Override
    public void onClick(View v) {
        //     //aftermom,yelloface,aochengle,mom,shandow,image1,image2,image3,image4
        if (v.equals(right)||v.equals(left)||v.equals(ma)||v.equals(dang)||v.equals(qian)||v.equals(mei)||v.equals(shoe)||v.equals(makeup)||v.equals(bag)){
            mamaqian.setVisibility(View.GONE);
            gifView.setVisibility(View.VISIBLE);
            ThreadUtils.runInThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        ThreadUtils.runInUThread(new Runnable() {
                            @Override
                            public void run() {
                                setSomeUiState();

                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }else if (v.equals(aftermom)||v.equals(yelloface)||v.equals(aochengle)||v.equals(mom)||v.equals(shandow)||v.equals(image1)||v.equals(image2)||v.equals(image3)||v.equals(image4)){
            mamahou.setVisibility(View.GONE);
            gifView1.setVisibility(View.VISIBLE);
            ThreadUtils.runInThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        ThreadUtils.runInUThread(new Runnable() {
                            @Override
                            public void run() {
                                setDiaochaState();
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
    private void setSomeUiState(){
        gifView.setVisibility(View.GONE);
        mamahou.setVisibility(View.VISIBLE);
        animationOfShandow();
        animationOfAfterMom();
    }
    private void setDiaochaState(){
        gifView1.setVisibility(View.GONE);
        diaocha.setVisibility(View.VISIBLE);
    }
}
