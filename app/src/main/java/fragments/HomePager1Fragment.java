package fragments;

import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.comeon95.CarouselActivity;
import com.example.administrator.comeon95.CommonProblemActivity;
import com.example.administrator.comeon95.GoodActivity;
import com.example.administrator.comeon95.HowGetChairActivity;
import com.example.administrator.comeon95.MainActivity;
import com.example.administrator.comeon95.MenDianActivity;
import com.example.administrator.comeon95.R;
import com.example.administrator.comeon95.TuiYongLiuChActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import Adapters.BannerAdapter;
import RetrofitData.DownLoadHotChairBannerDataUtil;
import RetrofitData.DownLoadHotChairDataUtil;
import javabeans.HotChair;
import javabeans.HotChairBanner;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ThreadUtils;
import uiutils.ToastUtils;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public class HomePager1Fragment extends Fragment implements View.OnClickListener {
    private ChairUseAdapter adapter;
    private ViewPager main1_pager;
    private List<ImageView> chairsBanner;
    private LinearLayout ll_point_container,howuse,liucheng,mendian,problem;
    private ListView hot_chairs;
    private List<Map<String,Object>> chairs;
    private boolean isRunning = false;
    private int a = 0;
    private int previousSelectedPosition = 0;

    public HomePager1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chair_fee_use, container, false);
        initView(view);
        addHeadView();
        initHotChairData();
        initLinister();
        return view;
    }

    private void openViewPager(final HotChairBanner data) {
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
                                                            main1_pager.setCurrentItem(a%(data.getData().size()/ 2));
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
                                                    main1_pager.setCurrentItem(main1_pager.getCurrentItem()+1);
                                                }
                                            });
                                        }
                                    }
                                }
        );
    }

    private void initLinister() {
        howuse.setOnClickListener(this);
        liucheng.setOnClickListener(this);
        mendian.setOnClickListener(this);
        problem.setOnClickListener(this);

    }

    private void initHotChairData() {
        DownLoadHotChairDataUtil chairDataUtil = new DownLoadHotChairDataUtil(getContext());
        chairDataUtil.downHotChairData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotChair>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotChair hotChair) {
                        chairs = new ArrayList<Map<String, Object>>();
                        HashMap<String, Object> map = null;
                        for (int i = 0; i < hotChair.getData().size(); i++) {
                            if (i %2 == 0){
                                map = new HashMap<String, Object>();
                                map.put("id1",hotChair.getData().get(i).getId());
                                map.put("image1",hotChair.getData().get(i).getMainPic());
                                map.put("title1",hotChair.getData().get(i).getName());
                                map.put("price1",hotChair.getData().get(i).getDeposit()+"");
                            }else if(i % 2 == 1){
                                map.put("image2",hotChair.getData().get(i).getMainPic());
                                map.put("title2",hotChair.getData().get(i).getName());
                                map.put("price2",hotChair.getData().get(i).getDeposit()+"");
                                map.put("id2",hotChair.getData().get(i).getId());
                                chairs.add(map);
                            }
                        }
                        hot_chairs.setAdapter(new ChairUseAdapter(chairs));
                    }
                });
    }

    private void addHeadView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.hot_chair_headview,null);
        howuse = (LinearLayout) view.findViewById(R.id.howuse);
        liucheng = (LinearLayout) view.findViewById(R.id.liucheng);
        mendian = (LinearLayout) view.findViewById(R.id.mendian);
        problem = (LinearLayout) view.findViewById(R.id.problem);
        main1_pager = (ViewPager) view.findViewById(R.id.main1_pager);
        ll_point_container = (LinearLayout) view.findViewById(R.id.ll_point_container);
        initHotChairBanner();
        if (view != null){
            hot_chairs.addHeaderView(view);
        }
    }

    private void initHotChairBanner() {
        DownLoadHotChairBannerDataUtil chairBannerDataUtil = new DownLoadHotChairBannerDataUtil(getContext());
        chairBannerDataUtil.downHotChairBannerData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HotChairBanner>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HotChairBanner hotChairBanner) {
                        chairsBanner = new ArrayList();
                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i <hotChairBanner.getData().size() ; i++) {
                                ImageView imageview = new ImageView(getContext());
                                imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                                Picasso.with(getContext()).load(hotChairBanner.getData().get(i).getBnnerPic()).into(imageview);
                                chairsBanner.add(imageview);
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
                        main1_pager.setAdapter(new BannerAdapter(chairsBanner));
                        ll_point_container.getChildAt(0).setEnabled(true);
                       // openViewPager(hotChairBanner);
                        //addViewPagerLinister(hotChairBanner);
                    }
                });
    }

//    private void addViewPagerLinister(final HotChairBanner hotChairBanner) {
//        main1_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                int newPosition = position % ((hotChairBanner.getData().size())/2);
//                // 把之前的禁用, 把最新的启用, 更新指示器
//                ll_point_container.getChildAt(position).setEnabled(false);
//                ll_point_container.getChildAt(newPosition).setEnabled(true);
//
//                // 记录之前的位置
//                previousSelectedPosition  = newPosition;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//    }


    private void initView(View view) {
        //liucheng,mendian,problem
        hot_chairs = (ListView) view.findViewById(R.id.hot_chairs);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.howuse:
                 intent = new Intent(getContext(),HowGetChairActivity.class);
                break;
            case R.id.liucheng:
                 intent = new Intent(getContext(),TuiYongLiuChActivity.class);
                break;
            case R.id.mendian:
                intent = new Intent(getContext(),MenDianActivity.class);
                break;
            case R.id.problem:
                intent = new Intent(getContext(),CommonProblemActivity.class);
                break;

        }
        startActivity(intent);
    }

    class ChairUseAdapter extends BaseAdapter{
        private List<Map<String, Object>>  chairs;
        public ChairUseAdapter(List<Map<String, Object>> chairs) {
            this.chairs = chairs;
        }

        @Override
        public int getCount() {
            return chairs.size();
        }

        @Override
        public Object getItem(int position) {
            return chairs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (holder == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.hotchair,parent,false);
                holder.imageView1  = (ImageView) convertView.findViewById(R.id.image1);
                holder.imageView2  = (ImageView) convertView.findViewById(R.id.image2);
                holder.title1  = (TextView) convertView.findViewById(R.id.title1);
                holder.title2  = (TextView) convertView.findViewById(R.id.title2);
                holder.price1  = (TextView) convertView.findViewById(R.id.price1);
                holder.price2  = (TextView) convertView.findViewById(R.id.price2);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(getContext()).load((String) chairs.get(position).get("image1")).into(holder.imageView1);
            Picasso.with(getContext()).load((String)chairs.get(position).get("image2")).into(holder.imageView2);
            holder.title1.setText((String)chairs.get(position).get("title1"));
            holder.title2.setText((String)chairs.get(position).get("title2"));
            holder.price1.setText((String)chairs.get(position).get("price1"));
            holder.price2.setText((String)chairs.get(position).get("price2"));
            addLinister(holder.imageView1,holder.imageView2,position);
            return convertView;
        }
        class ViewHolder{
            private ImageView imageView1,imageView2;
            private TextView title1,title2;
            private TextView price1,price2;
        }
    }

    private void addLinister(ImageView imageView1, ImageView imageView2, final int position) {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),GoodActivity.class);
                intent.putExtra("id",(Integer) chairs.get(position).get("id1"));
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),GoodActivity.class);
                intent.putExtra("id",(Integer) chairs.get(position).get("id2"));
                startActivity(intent);
            }
        });
    }
}
