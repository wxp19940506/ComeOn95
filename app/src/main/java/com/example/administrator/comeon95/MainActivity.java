package com.example.administrator.comeon95;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragments.AboutFragment;
import fragments.DiscoverFragment;
import fragments.HomePageFragment;
import fragments.HomePager1Fragment;
import fragments.MyselfFragment;
import uiutils.GetAddress;
import uiutils.MoveViewUtils;
import uiutils.ToastUtils;

import android.view.ViewGroup.LayoutParams;

public class MainActivity extends BaseActivity{
    @Bind(R.id.main_framelayout)
    FrameLayout mainFrameLayout;
    @Bind(R.id.main_bottom)
    LinearLayout mainBottom;
    @Bind(R.id.homepage)
    ImageView homepage;
    @Bind(R.id.discover)
    ImageView discover;
    @Bind(R.id.about)
    ImageView about;
    @Bind(R.id.myself)
    ImageView myself;
    @Bind(R.id.release)
    ImageView release;
    private TextView releaswtext,myselftext,abouttext,discovertext,homepagetext;
    private ImageView[] images;
    private TextView[] texts;
    private FragmentManager fragmentManager;
    private HomePageFragment homePageFragment;
    private HomePager1Fragment homePage1Fragment;
    private  DiscoverFragment discoverFragment;
    private AboutFragment aboutFragment;
    private  MyselfFragment myselfFragment;
    View view;
    RelativeLayout two_icon1,two_icon2,homehead,discove,aboutlb,search;
    ImageView cannel,moveimg;
    PopupWindow popupWindow;
    private int id;
    private String key;
    private boolean islogin;
    private SharedPreferences.Editor islogin_edit;
    private SharedPreferences isloginsp;
    private ImageView menu_icon,about_return,discove_return,xiaoxi1,xiaoxi2,xiaoxi3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        moveimg = (ImageView) findViewById(R.id.moveImageView);
        MoveViewUtils.setMoveView(this,moveimg);
        Intent intents = getIntent();
        Bundle extras = intents.getExtras();
        key= extras.getString("key","0");
        init(key,savedInstanceState);
        initLinister();

    }

    private void initLinister() {
        cannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cannel.setVisibility(View.GONE);
                popupWindow.dismiss();
            }
        });
        two_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToastSafe(MainActivity.this,"点击了说说");
                Intent intent = new Intent(MainActivity.this,ReleaseTellActivity.class);
                startActivity(intent);
            }
        });
        two_icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToastSafe(MainActivity.this,"点击了闲置");
                Intent intent = new Intent(MainActivity.this,ReleaseUnuseActivity.class);
                startActivity(intent);
            }
        });
        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        moveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HelppingActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }


    private void init(String key, Bundle savedInstanceState) {
        id = getIntent().getIntExtra("id",2);
        //islogin = getIntent().getBooleanExtra("yesorno",false);
        BaseApplication application = (BaseApplication) getApplication();
        islogin_edit= application.getIslogin_edit();
        isloginsp= application.getIsloginsp();
        view = LayoutInflater.from(this).inflate(R.layout.popupwindow_layout, null);
        two_icon1 = (RelativeLayout) view.findViewById(R.id.two_icon1);
        two_icon2 = (RelativeLayout) view.findViewById(R.id.two_icon2);
        search = (RelativeLayout) findViewById(R.id.search);
        cannel = (ImageView) view.findViewById(R.id.cannel);
        menu_icon = (ImageView) findViewById(R.id.amenu_icon);
        homehead = (RelativeLayout) findViewById(R.id.homeHead);
        discove = (RelativeLayout) findViewById(R.id.discove);
        aboutlb = (RelativeLayout) findViewById(R.id.aboutlb);
        about_return = (ImageView) findViewById(R.id.about_return);
        discove_return = (ImageView) findViewById(R.id.discove_return);
        xiaoxi1 = (ImageView) findViewById(R.id.xiaoxi1);
        xiaoxi2 = (ImageView) findViewById(R.id.xiaoxi2);
        xiaoxi3 = (ImageView) findViewById(R.id.xiaoxi3);
        releaswtext = (TextView) findViewById(R.id.releaswtext);
        myselftext = (TextView) findViewById(R.id.myselftext);
        abouttext = (TextView) findViewById(R.id.abouttext);
        discovertext = (TextView) findViewById(R.id.discovertext);
        homepagetext = (TextView) findViewById(R.id.homepagetext);
        xiaoxi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnInformationActivity();
            }
        });
        xiaoxi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnInformationActivity();
            }
        });
        xiaoxi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnInformationActivity();
            }
        });
        images = new ImageView[]{homepage, discover, release, about, myself};
        texts = new TextView[]{homepagetext,discovertext,abouttext,myselftext,releaswtext};
        homehead.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        homepage.setSelected(true);
        homepagetext.setEnabled(true);
        homePageFragment = new HomePageFragment(MainActivity.this);
        homePage1Fragment = new HomePager1Fragment();
        discoverFragment = new DiscoverFragment();
        aboutFragment = new AboutFragment();
        myselfFragment = new MyselfFragment(id);
        FragmentTransaction fragmentTransaction0 = fragmentManager.beginTransaction();
        fragmentTransaction0.add(R.id.main_framelayout,homePage1Fragment,"homePage1Fragment").hide(homePage1Fragment);
        fragmentTransaction0.commit();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.main_framelayout,homePageFragment,"homePageFragment").hide(homePageFragment);
        fragmentTransaction1.commit();
        if (key.equals("1")){
            if (savedInstanceState != null){
                homePage1Fragment = (HomePager1Fragment) fragmentManager.findFragmentByTag("homePage1Fragment");
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(homePage1Fragment);
            if (homePage1Fragment.isAdded()){
                fragmentTransaction.show(homePage1Fragment);
            }
            fragmentTransaction.commit();
            homehead.setVisibility(View.GONE);
        }else  if (key.equals("0")) {
            if (savedInstanceState != null){
                homePageFragment = (HomePageFragment) fragmentManager.findFragmentByTag("homePageFragment");
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(homePageFragment);
            if (homePageFragment.isAdded()){
                fragmentTransaction.show(homePageFragment);
            }
            fragmentTransaction.commit();
        }
        createFragment(discoverFragment,"discoverFragment",savedInstanceState);
        createFragment(aboutFragment,"aboutFragment",savedInstanceState);
        createFragment(myselfFragment,"myselfFragment",savedInstanceState);
    }

    public void turnInformationActivity(){
        Intent intent = new Intent(MainActivity.this,InformationActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.bar1, R.id.bar2, R.id.bar4, R.id.bar5, R.id.bar3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar1:
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.hide(homePage1Fragment);
                    fragmentTransaction.commit();
//                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
//                    fragmentTransaction1.replace(R.id.main_framelayout,homePageFragment,"homePageFragment").show(homePageFragment);
//                    fragmentTransaction1.commit();
                showFragment(homePageFragment);
                homehead.setVisibility(View.VISIBLE);
                discove.setVisibility(View.GONE);
                aboutlb.setVisibility(View.GONE);
                setSelectIcon(homepage);
                setSelectText(homepagetext);
                break;
            case R.id.bar2:
                showFragment(discoverFragment);
                someShowOrHide();
                discove.setVisibility(View.VISIBLE);
                aboutlb.setVisibility(View.GONE);
                setSelectIcon(discover);
                setSelectText(discovertext);
                break;
            case R.id.bar4:
                showFragment(aboutFragment);
                someShowOrHide();
                aboutlb.setVisibility(View.VISIBLE);
                discove.setVisibility(View.GONE);
                setSelectIcon(about);
                setSelectText(abouttext);
                break;
            case R.id.bar5:
                if (isloginsp.getBoolean("islogin",false)){
                    showFragment(myselfFragment);
                    someShowOrHide();
                    discove.setVisibility(View.GONE);
                    aboutlb.setVisibility(View.GONE);
                    homehead.setVisibility(View.GONE);
                    setSelectIcon(myself);
                    setSelectText(myselftext);
                }else {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                break;
            case R.id.bar3:
                //点击弹出Popwindow
                cannel.setVisibility(View.VISIBLE);
                setSelectText(releaswtext);
                showPopupWindow();
                break;
        }
    }

    private void someShowOrHide() {
        homehead.setVisibility(View.INVISIBLE);
    }

    //发布按钮的效果方法
    private void showPopupWindow() {

        two_icon1.setVisibility(View.VISIBLE);
        two_icon2.setVisibility(View.VISIBLE);
        popupWindow = new PopupWindow(view, LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.popup_background)));//设置背景不为空但是完全透明
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        //动画效果
        showAnimation(two_icon1,two_icon2);


//        // 设置背景颜色变暗
//        WindowManager.LayoutParams lp = getWindow().getAttributes();
//        lp.alpha = 0.7f;
//        getWindow().setAttributes(lp);

    }

    private void dissAnimation(View view1,View view2) {
        PropertyValuesHolder pvh0 = PropertyValuesHolder.ofFloat("alpha",
                1.0f, 0.5f, 0.0f);
        PropertyValuesHolder pvh1= PropertyValuesHolder.ofFloat("translationX",
                1.0f, 100.0f,200.0f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("translationY",
                1.0f, 100f, 200f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("rotationX",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh4 = PropertyValuesHolder.ofFloat(
                "rotationX", 0.0f, 360.0f, 0.0f);
        ObjectAnimator
                .ofPropertyValuesHolder(view1, pvh0, pvh1, pvh2, pvh3,pvh4)
                .setDuration(1000).start();

        PropertyValuesHolder pvh5 = PropertyValuesHolder.ofFloat("alpha",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh6 = PropertyValuesHolder.ofFloat("translationX",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,-100.0f),GetAddress.sp2px(this,-200.0f));
        PropertyValuesHolder pvh7 = PropertyValuesHolder.ofFloat("translationY",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,100.0f),GetAddress.sp2px(this,200.0f));
        PropertyValuesHolder pvh8 = PropertyValuesHolder.ofFloat("rotationX",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh9 = PropertyValuesHolder.ofFloat(
                "rotationX", 0.0f, 360.0f, 0.0f);
        ObjectAnimator
                .ofPropertyValuesHolder(view2, pvh5, pvh6, pvh7, pvh8,pvh9)
                .setDuration(1000).start();
        cannel.setVisibility(View.GONE);
         popupWindow.dismiss();


    }

    private void showAnimation(View view1,View view2) {
        PropertyValuesHolder pvh0 = PropertyValuesHolder.ofFloat("alpha",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh1= PropertyValuesHolder.ofFloat("translationX",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,-30.0f),GetAddress.sp2px(this,-50.0f),GetAddress.sp2px(this,-60.0f),GetAddress.sp2px(this,-70.0f));
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("translationY",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,-40.0f),GetAddress.sp2px(this,55.0f),GetAddress.sp2px(this,65.0f),GetAddress.sp2px(this,-80.0f));
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("rotationX",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh4 = PropertyValuesHolder.ofFloat(
                "rotationX", 0.0f, 360.0f, 0.0f);
        ObjectAnimator
                .ofPropertyValuesHolder(view1, pvh0, pvh1, pvh2, pvh3,pvh4)
                .setDuration(500).start();

        PropertyValuesHolder pvh5 = PropertyValuesHolder.ofFloat("alpha",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh6 = PropertyValuesHolder.ofFloat("translationX",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,30.0f),GetAddress.sp2px(this,50.0f),GetAddress.sp2px(this,60.0f),GetAddress.sp2px(this,70.0f));
        PropertyValuesHolder pvh7 = PropertyValuesHolder.ofFloat("translationY",
                GetAddress.sp2px(this,1.0f),GetAddress.sp2px(this,-40.0f),GetAddress.sp2px(this,55.0f),GetAddress.sp2px(this,65.0f),GetAddress.sp2px(this,-80.0f));
        PropertyValuesHolder pvh8 = PropertyValuesHolder.ofFloat("rotationX",
                1.0f, 0.2f, 1.0f);
        PropertyValuesHolder pvh9 = PropertyValuesHolder.ofFloat(
                "rotationX", 0.0f, 360.0f, 0.0f);
        ObjectAnimator
                .ofPropertyValuesHolder(view2, pvh5, pvh6, pvh7, pvh8,pvh9)
                .setDuration(500).start();
    }

    //创建或者显示隐藏Fragment的方法
    private void createFragment(Fragment fr,String tag,Bundle savedInstanceState){
        if (savedInstanceState != null){
            homePageFragment = (HomePageFragment) fragmentManager.findFragmentByTag("homePageFragment");
            homePage1Fragment = (HomePager1Fragment) fragmentManager.findFragmentByTag("homePage1Fragment");
            discoverFragment = (DiscoverFragment) fragmentManager.findFragmentByTag("discoverFragment");
            aboutFragment = (AboutFragment) fragmentManager.findFragmentByTag("aboutFragment");
            myselfFragment = (MyselfFragment) fragmentManager.findFragmentByTag("myselfFragment");
        }
        if (!fr.isAdded() && savedInstanceState == null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_framelayout,fr,tag).hide(fr);
            fragmentTransaction.commit();
        }
        }
    private void showFragment(Fragment fr){

        if (fr.isAdded()){
            FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
            fragmentTransaction2.hide(homePageFragment);
            fragmentTransaction2.commit();
            FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
            fragmentTransaction3.hide(discoverFragment);
            fragmentTransaction3.commit();
            FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
            fragmentTransaction4.hide(myselfFragment);
            fragmentTransaction4.commit();
            FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
            fragmentTransaction5.hide(aboutFragment);
            fragmentTransaction5.commit();
            FragmentTransaction fragmentTransaction6 = fragmentManager.beginTransaction();
            fragmentTransaction6.hide(homePage1Fragment);
            fragmentTransaction6.commit();
            FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
            fragmentTransaction1.show(fr);
            fragmentTransaction1.commit();
        }
    }

    //改变选择图标效果的方法
    private void setSelectIcon(View v1){
        for (ImageView image : images){
            image.setSelected(false);
        }
        v1.setSelected(true);

    }
    private void setSelectText(TextView v2){
        for (int i = 0; i < texts.length; i++) {
            texts[i].setEnabled(false);
        }
        v2.setEnabled(true);
    }
}