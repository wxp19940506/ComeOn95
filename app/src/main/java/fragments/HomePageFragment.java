package fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.comeon95.BaiCircleActivity;
import com.example.administrator.comeon95.CarouselActivity;
import com.example.administrator.comeon95.ChairUseActivity;
import com.example.administrator.comeon95.GoodActivity;
import com.example.administrator.comeon95.GoodInfoActivity;
import com.example.administrator.comeon95.LaiBaiYouXuanActivity;
import com.example.administrator.comeon95.MainActivity;
import com.example.administrator.comeon95.PublicBenefitActivity;
import com.example.administrator.comeon95.R;
import com.example.administrator.comeon95.XianZhiActivity;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import RetrofitData.DownLoadGoodsDataUtil;
import RetrofitData.DownLoadOneToOneUtils;
import RetrofitData.DownLoadTalkAboutDataUtil;
import RetrofitData.DownLoadUtils;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;
import javabeans.BannerData;
import javabeans.GoodsData;
import javabeans.HomePagerData;
import javabeans.TalkAboutData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ThreadUtils;
import uiutils.ToastUtils;;

public class HomePageFragment extends Fragment implements View.OnClickListener {
    private ViewPager main_viewpager;
    private List<ImageView> imageViews;
    private LinearLayout goods,ll_point_container,baiquan,laibaiyouxuan,public_benefit,xianzhi,chairuse;
    private int previousSelectedPosition = 0;
    boolean isRunning = false;
    private ImageView model1,model2,model3,model4;
    private VerticalViewPager advertiseviewpager;
    private LinearLayout linearLayout;
    private String PATH = GetAddress.PATH;
    private int a = 0;
    private Intent intent;
    MainActivity mainActivity;

    public HomePageFragment() {
    }

    public HomePageFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_listheadview, container, false);
        //相关初始化
        init(view);
        //初始化数据源
        initData();
        initTexts();
        initGoods();
        //设置点击事件
        initLinister();
        //开启轮询
        return view;
    }

    private void initTexts() {
        DownLoadTalkAboutDataUtil goodsDataUtil = new DownLoadTalkAboutDataUtil(getContext());
        goodsDataUtil.downLoadTalkAboutData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TalkAboutData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TalkAboutData data) {
                        initAdvertiseViewPager(data);
                        //初始化上下滑动文本
                        initStartAdvertise();
                        initViewpager(data);
                    }
                });

    }

    private void initGoods() {
        DownLoadGoodsDataUtil goodsDataUtil = new DownLoadGoodsDataUtil(getContext());
        goodsDataUtil.downLoadGoodsData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<GoodsData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodsData data) {
                        addGoods(goods,data);

                    }
                });

    }

    private void initStartAdvertise() {
        ThreadUtils.runInUThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initViewpager(final TalkAboutData data) {
                        //初始化轮询适配器

        ThreadUtils.runInThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        isRunning = true;
                                        while(isRunning){
                                            try {
                                                synchronized (MainActivity.class){
                                                    Thread.sleep(3000);
                                                    ThreadUtils.runInUThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            advertiseviewpager.setCurrentItem(a%(data.getData().size()/ 2));
                                                            a++;
                                                        }
                                                    });
                                                }
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            // 往下跳一位
                                            ThreadUtils.runInUThread(new Runnable() {

                                                @Override
                                                public void run() {
                                                    main_viewpager.setCurrentItem(main_viewpager.getCurrentItem()+1);
                                                }
                                            });
                                        }
                                    }
                                }
        );
    }

    private void initLinister() {

        baiquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),BaiCircleActivity.class);
                startActivity(intent);
            }
        });
        laibaiyouxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),LaiBaiYouXuanActivity.class);
                startActivity(intent);
            }
        });
        public_benefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),PublicBenefitActivity.class);
                startActivity(intent);
            }
        });
        xianzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),XianZhiActivity.class);
                startActivity(intent);
            }
        });
        chairuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),ChairUseActivity.class);
                startActivity(intent);
                mainActivity.finish();
            }
        });
        model1.setOnClickListener(this);
        model2.setOnClickListener(this);
        model3.setOnClickListener(this);
        model4.setOnClickListener(this);
//        advertiseviewpager.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(),BaiCircleActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void initAdvertiseViewPager(TalkAboutData data) {
      List<View> views = new ArrayList<>();
        for (int i = 0; i <data.getData().size() ; i++) {
            if (i%2 == 0){
                linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                TextView textView1 = new TextView(getContext());
                textView1.setMaxLines(1);
                textView1.setEllipsize(TextUtils.TruncateAt.END);
                textView1.setText(data.getData().get(i).getTalkInfo());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),230),GetAddress.sp2px(getContext(),30));
                params.weight = 1;
                params.topMargin = GetAddress.sp2px(getContext(),8);
                params.gravity = Gravity.CENTER_VERTICAL;
                linearLayout.addView(textView1,0,params);
            }
            if (i%2 == 1){
                TextView textView2 = new TextView(getContext());
                textView2.setMaxLines(1);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),230),GetAddress.sp2px(getContext(),30));
                params1.weight = 1;
                params1.gravity = Gravity.CENTER_VERTICAL;
                params1.topMargin = GetAddress.sp2px(getContext(),8);
                textView2.setText(data.getData().get(i).getTalkInfo());
                linearLayout.addView(textView2,1,params1);
                views.add(linearLayout);
            }

        }
        if (views != null && !views.equals("")){
            AdvertiseAdapter adapter = new AdvertiseAdapter(views);
            advertiseviewpager.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }

    @Override
    public void onClick(View v) {
        intent =  new Intent(getContext(), GoodInfoActivity.class);
        switch (v.getId()){
            case R.id.model1:
                intent.putExtra("id", 1);
                break;
            case R.id.model2:
                intent.putExtra("id", 1);
                break;
            case R.id.model3:
                intent.putExtra("id", 1);
                break;
            case R.id.model4:
                intent.putExtra("id", 1);
                break;
        }
        startActivity(intent);
    }

    private class AdvertiseAdapter extends PagerAdapter{
        private List<View> views;

        public AdvertiseAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            views.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),BaiCircleActivity.class);
                    startActivity(intent);
                }
            });
            return views.get(position);
        }
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        // 3. 指定复用的判断逻辑, 固定写法
        @Override
        public boolean isViewFromObject(View view, Object object) {
//			System.out.println("isViewFromObject: "+(view == object));
            // 当划到新的条目, 又返回来, view是否可以被复用.
            // 返回判断规则
            return view == object;
        }

        // 1. 返回要显示的条目内容, 创建条目
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // container: 容器: ViewPager
            // position: 当前要显示条目的位置 0 -> 4
                int newPosition = position % imageViews.size();
                ImageView imageView = imageViews.get(newPosition);
                //解决白页问题
                ViewGroup viewGroup = (ViewGroup) imageView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                container.addView(imageView);
                return imageView;
        }

        // 2. 销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // object 要销毁的对象
            container.removeView((View)object);
        }
    }

    private void initData() {
        DownLoadUtils loadUtils = new DownLoadUtils(getContext());
        loadUtils.downLoadData(PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BannerData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BannerData banner) {
                        showAdvertiseMent(banner);
                    }
                });

    }

//    private void updateModel(List<String> modelImage) {
//        Picasso.with(getContext()).load(modelImage.get(0)).into(model1);
//        Picasso.with(getContext()).load(modelImage.get(1)).into(model2);
//        Picasso.with(getContext()).load(modelImage.get(2)).into(model3);
//        Picasso.with(getContext()).load(modelImage.get(3)).into(model4);
//    }

    private void addGoods(LinearLayout goodsView, final GoodsData data) {

        for (int i = 0; i <data.getData().size() ; i++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),120), ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView image = new ImageView(getContext());
            TextView brand = new TextView(getContext());
            TextView title = new TextView(getContext());
            brand.setSingleLine(true);
            brand.getEllipsize();
            title.setSingleLine(true);
            title.getEllipsize();
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(getContext()).load(data.getData().get(i).getMainPic()).into(image);
            LinearLayout.LayoutParams imageparams = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),115),GetAddress.sp2px(getContext(),140));
            LinearLayout.LayoutParams textparams = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),110),GetAddress.sp2px(getContext(),50));
            textparams.gravity = Gravity.CENTER;
            LinearLayout childLinearLayout = new LinearLayout(getContext());
            childLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams childParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams childParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            childParams1.gravity = Gravity.CENTER;
            childParams2.topMargin = GetAddress.sp2px(getContext(),5);
            childParams1.leftMargin = GetAddress.sp2px(getContext(),5);
            childParams1.rightMargin = GetAddress.sp2px(getContext(),8);
            brand.setText("");
            title.setText(data.getData().get(i).getName());
            childLinearLayout.addView(brand,childParams1);
            childLinearLayout.addView(title,childParams2);
            linearLayout.addView(image,imageparams);
            linearLayout.addView(childLinearLayout,textparams);
            goodsView.addView(linearLayout,param);
            final int finalI1 = i;
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),GoodActivity.class);
                    intent.putExtra("id",data.getData().get(finalI1).getId());
                    startActivity(intent);
                }
            });
        }

    }

    private void showAdvertiseMent(BannerData banner) {
        imageViews = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i <banner.getData().size() ; i++) {
                ImageView imageview = new ImageView(getContext());
                imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                Picasso.with(getContext()).load(banner.getData().get(i).getBannerPic()).into(imageview);
                imageViews.add(imageview);
                imageview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(),CarouselActivity.class);
                        startActivity(intent);

                    }
                });
                if (j == 1){
                    //指示器
                    View pointView = new View(getContext());
                    pointView.setBackgroundResource(R.drawable.selector_bg_point);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GetAddress.sp2px(getContext(),10),GetAddress.sp2px(getContext(),10));
                    layoutParams.leftMargin = GetAddress.sp2px(getContext(),10);
                    // 设置默认所有都不可用
                    pointView.setEnabled(false);
                    ll_point_container.addView(pointView, layoutParams);
                }

            }
        }
        // 设置适配器
        main_viewpager.setAdapter(new MyAdapter());

        previousSelectedPosition = 0;
        // 默认设置到中间的某个位置
        // int pos = Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2 % imageViews.size());
        // 2147483647 / 2 = 1073741823 - (1073741823 % 5)
        main_viewpager.setCurrentItem(5000000); // 设置到某个位置

        ll_point_container.getChildAt(0).setEnabled(true);
        main_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int newPosition = position % ((imageViews.size())/2);
                // 把之前的禁用, 把最新的启用, 更新指示器
                ll_point_container.getChildAt(previousSelectedPosition).setEnabled(false);
                ll_point_container.getChildAt(newPosition).setEnabled(true);

                // 记录之前的位置
                previousSelectedPosition  = newPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //initAdapter(imageViews);
    }

    private void init(View view) {
        ll_point_container = (LinearLayout) view.findViewById(R.id.ll_point_container);
        baiquan = (LinearLayout) view.findViewById(R.id.baiquan);
        public_benefit = (LinearLayout) view.findViewById(R.id.public_benefit);
        laibaiyouxuan = (LinearLayout) view.findViewById(R.id.laibaiyouxuan);
        xianzhi = (LinearLayout) view.findViewById(R.id.xianzhi);
        chairuse = (LinearLayout) view.findViewById(R.id.chairuse);
        main_viewpager = (ViewPager) view.findViewById(R.id.main_pager);
        advertiseviewpager = (VerticalViewPager) view.findViewById(R.id.advertiseviewpager);
        model1 = (ImageView) view.findViewById(R.id.model1);
        model2 = (ImageView) view.findViewById(R.id.model2);
        model3 = (ImageView) view.findViewById(R.id.model3);
        model4 = (ImageView) view.findViewById(R.id.model4);
        goods = (LinearLayout) view.findViewById(R.id.goods);
    }


}
