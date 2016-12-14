package com.example.administrator.comeon95;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class DiscoverSplash extends AppCompatActivity {
    private VerticalViewPager verticalViewPager;
    private ImageView entry;
    private List<View> viewList;
    private LinearLayout return_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_splash);
        initView();
        initVerticalViewPager();
        initVerticalViewPagerLinister();
        initLinister();
    }

    private void initView() {
        return_home = (LinearLayout) findViewById(R.id.return_home);
    }

    private void initLinister() {
        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newItem = verticalViewPager.getCurrentItem() + 1;
                verticalViewPager.setCurrentItem(newItem);
            }
        });
        return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initVerticalViewPagerLinister() {

    }

    private void initVerticalViewPager() {
        verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);
        viewList = new ArrayList<View>();
        View view1 = getLayoutInflater().inflate(R.layout.test_pager1, null);
        ImageView imageView = (ImageView) view1.findViewById(R.id.pager);
        ImageView entry1 = (ImageView) view1.findViewById(R.id.entry);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.character_test1).into(imageView);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.btn1).into(entry1);
        View view2 = getLayoutInflater().inflate(R.layout.test_pager2, null);
        ImageView imageView1 = (ImageView) view2.findViewById(R.id.pager);
        ImageView ques2 = (ImageView) view2.findViewById(R.id.ques2);
        ImageView ques1 = (ImageView) view2.findViewById(R.id.ques1);
        ImageView btn1 = (ImageView) view2.findViewById(R.id.btn1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question1).into(imageView1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question1_a).into(ques1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question1_b).into(ques2);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn1);
        initView2(view2);
        View view3 = getLayoutInflater().inflate(R.layout.test_pager3, null);
        ImageView imageView2 = (ImageView) view3.findViewById(R.id.pager);
        ImageView image1 = (ImageView) view3.findViewById(R.id.image1);
        ImageView image2 = (ImageView) view3.findViewById(R.id.image2);
        ImageView image3 = (ImageView) view3.findViewById(R.id.image3);
        ImageView image4 = (ImageView) view3.findViewById(R.id.image4);
        ImageView btn5 = (ImageView) view3.findViewById(R.id.btn1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question2).into(imageView2);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question2_a).into(image1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question2_b).into(image2);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question2_c).into(image3);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question2_d).into(image4);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn5);
        initView3(view3);
        View view4 = getLayoutInflater().inflate(R.layout.test_pager4, null);
        ImageView imageView3 = (ImageView) view4.findViewById(R.id.pager);
        ImageView image01 = (ImageView) view4.findViewById(R.id.image1);
        ImageView image02 = (ImageView) view4.findViewById(R.id.image2);
        ImageView image03 = (ImageView) view4.findViewById(R.id.image3);
        ImageView image04 = (ImageView) view4.findViewById(R.id.image4);
        ImageView btn6 = (ImageView) view4.findViewById(R.id.btn2);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn6);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question3_a).into(image01);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question3_b).into(image02);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question3_c).into(image03);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question3_d).into(image04);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question3).into(imageView3);
        initView4(view4);
        View view5 = getLayoutInflater().inflate(R.layout.test_pager5, null);
        ImageView imageView4 = (ImageView) view5.findViewById(R.id.pager);
        ImageView image11 = (ImageView) view5.findViewById(R.id.image1);
        ImageView image12 = (ImageView) view5.findViewById(R.id.image2);
        ImageView image13 = (ImageView) view5.findViewById(R.id.image3);
        ImageView image14 = (ImageView) view5.findViewById(R.id.image4);
        ImageView btn7 = (ImageView) view5.findViewById(R.id.btn1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4).into(imageView4);
//        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4).into(btn7);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4_a).into(image11);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4_b).into(image12);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4_c).into(image13);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question4_d).into(image14);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn7);
        initView5(view5);
        View view6 = getLayoutInflater().inflate(R.layout.test_pager6, null);
        ImageView imageView5 = (ImageView) view6.findViewById(R.id.pager);
        ImageView image21 = (ImageView) view6.findViewById(R.id.image1);
        ImageView image22 = (ImageView) view6.findViewById(R.id.image2);
        ImageView image23 = (ImageView) view6.findViewById(R.id.image3);
        ImageView image24 = (ImageView) view6.findViewById(R.id.image4);
        ImageView btn8 = (ImageView) view6.findViewById(R.id.btn1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5).into(imageView5);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_a).into(image21);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_b).into(image22);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_c).into(image23);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_d).into(image24);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn8);
        initView6(view6);
        View view7 = getLayoutInflater().inflate(R.layout.test_pager7, null);
        ImageView imageView6 = (ImageView) view7.findViewById(R.id.pager);
        ImageView image31 = (ImageView) view7.findViewById(R.id.image1);
        ImageView image32 = (ImageView) view7.findViewById(R.id.image2);
        ImageView image33 = (ImageView) view7.findViewById(R.id.image3);
        ImageView image34 = (ImageView) view7.findViewById(R.id.image4);
        ImageView btn9 = (ImageView) view7.findViewById(R.id.btn1);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5).into(imageView5);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_a).into(image21);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_b).into(image22);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_c).into(image23);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question5_d).into(image24);
        Picasso.with(DiscoverSplash.this).load(R.mipmap.question_next).into(btn8);
        initView7(view7);
        View view8 = getLayoutInflater().inflate(R.layout.test_pager8, null);
        initView8(view8);
        View view9 = getLayoutInflater().inflate(R.layout.test_pager9, null);
        initView9(view9);
        View view10 = getLayoutInflater().inflate(R.layout.test_pager10, null);
        initView10(view10);
        View view11 = getLayoutInflater().inflate(R.layout.test_pager11, null);
        initView11(view11);
        View view12 = getLayoutInflater().inflate(R.layout.test_pager12, null);
        initView12(view12);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        viewList.add(view5);
        viewList.add(view6);
        viewList.add(view7);
        viewList.add(view8);
        viewList.add(view9);
        viewList.add(view10);
        viewList.add(view11);
        viewList.add(view12);
        MyPagerAdapter adapter = new MyPagerAdapter(viewList) ;
        verticalViewPager.setAdapter(adapter);
        verticalViewPager.setOffscreenPageLimit(1);
        entry = (ImageView) view1.findViewById(R.id.entry);

    }

    private void initView12(View view12) {
        final LinearLayout linearLayout1 = (LinearLayout) view12.findViewById(R.id.select39);
        final LinearLayout linearLayout2 = (LinearLayout) view12.findViewById(R.id.select40);
        final LinearLayout linearLayout3 = (LinearLayout) view12.findViewById(R.id.select41);
        final LinearLayout linearLayout4 = (LinearLayout) view12.findViewById(R.id.select42);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView11(View view11) {
        final LinearLayout linearLayout1 = (LinearLayout) view11.findViewById(R.id.select35);
        final LinearLayout linearLayout2 = (LinearLayout) view11.findViewById(R.id.select36);
        final LinearLayout linearLayout3 = (LinearLayout) view11.findViewById(R.id.select37);
        final LinearLayout linearLayout4 = (LinearLayout) view11.findViewById(R.id.select38);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView10(View view10) {
        final LinearLayout linearLayout1 = (LinearLayout) view10.findViewById(R.id.select31);
        final LinearLayout linearLayout2 = (LinearLayout) view10.findViewById(R.id.select32);
        final LinearLayout linearLayout3 = (LinearLayout) view10.findViewById(R.id.select33);
        final LinearLayout linearLayout4 = (LinearLayout) view10.findViewById(R.id.select34);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView9(View view9) {
        final LinearLayout linearLayout1 = (LinearLayout) view9.findViewById(R.id.select27);
        final LinearLayout linearLayout2 = (LinearLayout) view9.findViewById(R.id.select28);
        final LinearLayout linearLayout3 = (LinearLayout) view9.findViewById(R.id.select29);
        final LinearLayout linearLayout4 = (LinearLayout) view9.findViewById(R.id.select30);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView8(View view8) {
        final LinearLayout linearLayout1 = (LinearLayout) view8.findViewById(R.id.select23);
        final LinearLayout linearLayout2 = (LinearLayout) view8.findViewById(R.id.select24);
        final LinearLayout linearLayout3 = (LinearLayout) view8.findViewById(R.id.select25);
        final LinearLayout linearLayout4 = (LinearLayout) view8.findViewById(R.id.select26);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView7(View view7) {
        final LinearLayout linearLayout1 = (LinearLayout) view7.findViewById(R.id.select19);
        final LinearLayout linearLayout2 = (LinearLayout) view7.findViewById(R.id.select20);
        final LinearLayout linearLayout3 = (LinearLayout) view7.findViewById(R.id.select21);
        final LinearLayout linearLayout4 = (LinearLayout) view7.findViewById(R.id.select22);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView6(View view6) {
        final LinearLayout linearLayout1 = (LinearLayout) view6.findViewById(R.id.select15);
        final LinearLayout linearLayout2 = (LinearLayout) view6.findViewById(R.id.select16);
        final LinearLayout linearLayout3 = (LinearLayout) view6.findViewById(R.id.select17);
        final LinearLayout linearLayout4 = (LinearLayout) view6.findViewById(R.id.select18);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView5(View view5) {
        final LinearLayout linearLayout1 = (LinearLayout) view5.findViewById(R.id.select11);
        final LinearLayout linearLayout2 = (LinearLayout) view5.findViewById(R.id.select12);
        final LinearLayout linearLayout3 = (LinearLayout) view5.findViewById(R.id.select13);
        final LinearLayout linearLayout4 = (LinearLayout) view5.findViewById(R.id.select14);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView4(View view4) {
        final LinearLayout linearLayout1 = (LinearLayout) view4.findViewById(R.id.select7);
        final LinearLayout linearLayout2 = (LinearLayout) view4.findViewById(R.id.select8);
        final LinearLayout linearLayout3 = (LinearLayout) view4.findViewById(R.id.select9);
        final LinearLayout linearLayout4 = (LinearLayout) view4.findViewById(R.id.select10);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }

    private void initView3(View view3) {
        final LinearLayout linearLayout1 = (LinearLayout) view3.findViewById(R.id.select3);
        final LinearLayout linearLayout2 = (LinearLayout) view3.findViewById(R.id.select4);
        final LinearLayout linearLayout3 = (LinearLayout) view3.findViewById(R.id.select5);
        final LinearLayout linearLayout4 = (LinearLayout) view3.findViewById(R.id.select6);
        final LinearLayout[] layouts = {linearLayout1,linearLayout2,linearLayout3,linearLayout4};
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout2);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout3);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < layouts.length; i++) {
                    layouts[i].getChildAt(1).setEnabled(false);
                }
                SelectOption(linearLayout4);
            }
        });
    }
    private void SelectOption(LinearLayout linearLayout){
        linearLayout.getChildAt(1).setEnabled(true);
        int newItem = verticalViewPager.getCurrentItem() + 1;
        verticalViewPager.setCurrentItem(newItem);
    }

    private void initView2(View view2) {
        final LinearLayout select1 = (LinearLayout) view2.findViewById(R.id.select1);
        final LinearLayout select2 = (LinearLayout) view2.findViewById(R.id.select2);
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select2.setFocusable(false);
                select1.getChildAt(1).setEnabled(true);
                select2.getChildAt(1).setEnabled(false);
                int newItem = verticalViewPager.getCurrentItem() + 1;
                verticalViewPager.setCurrentItem(newItem);
            }
        });
        select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select1.setFocusable(false);
                select2.getChildAt(1).setEnabled(true);
                select1.getChildAt(1).setEnabled(false);
                int newItem = verticalViewPager.getCurrentItem() + 1;
                verticalViewPager.setCurrentItem(newItem);
            }
        });
    }

    class MyPagerAdapter extends PagerAdapter{
        private List<View> viewList;
        public MyPagerAdapter(List<View> viewList) {
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }
    }
}
