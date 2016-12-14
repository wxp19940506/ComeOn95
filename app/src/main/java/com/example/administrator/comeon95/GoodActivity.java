package com.example.administrator.comeon95;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Adapters.BannerAdapter;
import RetrofitData.DownLoadGoodBannerDataUtil;
import RetrofitData.DownLoadGoodImagesDataUtil;
import RetrofitData.DownLoadGoodTitleDataUtil;
import javabeans.GoodBannerData;
import javabeans.GoodImagesData;
import javabeans.GoodTitleData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ThreadUtils;
import uiutils.ToastUtils;

public class GoodActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager xiangqing_good;
    private TextView title,yajin,shichangjia,homepager;
    private RelativeLayout guige,lingyong;
    private LinearLayout add_xiangqing,point_container;
    private Intent intent;
    private ImageView discove_return;
    private int id;
    private GoodTitleData goodTitleData;
    private  boolean isRunning = false;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        initView();
        //轮播
        initGoodBanner();
        //标题文字以及popupwindow
        initTitleAndPrice();
        //详情图片
        initImages();
        openTimer();
        initLinister();
    }

    private void initLinister() {
        homepager.setOnClickListener(this);
        discove_return.setOnClickListener(this);
        lingyong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(GoodActivity.this);
                View view = LayoutInflater.from(GoodActivity.this).inflate(R.layout.dialog_title,null);
                dialog.setCustomTitle(view);
                dialog.setMessage("请选择产品规格");
                dialog.setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (GoodActivity.this.goodTitleData != null && !GoodActivity.this.goodTitleData.equals("")){
                            showPopupWindow(GoodActivity.this.goodTitleData);
                        }
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }

    private void initImages() {
        DownLoadGoodImagesDataUtil goodImagesDataUtil = new DownLoadGoodImagesDataUtil(this,id);
        goodImagesDataUtil.downLoadGoodImagesData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodImagesData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodImagesData goodImagesData) {
                        for (int i = 0; i <goodImagesData.getData().size() ; i++) {
                                ImageView imageView = new ImageView(GoodActivity.this);
                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                Picasso.with(GoodActivity.this).load(goodImagesData.getData().get(i).getPic()).into(imageView);
                                add_xiangqing.addView(imageView);
                        }
                    }
                });
    }

    private void initTitleAndPrice() {
        DownLoadGoodTitleDataUtil goodTitleDataUtil = new DownLoadGoodTitleDataUtil(this,id);
        goodTitleDataUtil.downLoadGoodTitleData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodTitleData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final GoodTitleData goodTitleData) {
                        title.setText(goodTitleData.getData().get(0).getName());
                        yajin.setText("￥"+goodTitleData.getData().get(0).getPrice()+"0");
                        shichangjia.setText("(市场价 ￥"+goodTitleData.getData().get(0).getPrice()+"0)");
                        guige.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                GoodActivity.this.goodTitleData = goodTitleData;
                                showPopupWindow(goodTitleData);
                            }
                        });
                    }
                });
    }

    private void showPopupWindow(final GoodTitleData goodTitleData) {
        View view = GoodActivity.this.getLayoutInflater().inflate(R.layout.popup_view,null);
        TextView goodprice = (TextView) view.findViewById(R.id.goodprice);
        TextView cankaoprice = (TextView) view.findViewById(R.id.cankaoprice);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView enable_color = (TextView) view.findViewById(R.id.enable_color);
        final TextView count1 = (TextView) view.findViewById(R.id.count1);
        final TextView add_prices = (TextView) view.findViewById(R.id.add_prices);
        ImageView dismiss = (ImageView) view.findViewById(R.id.dismiss);
        GridView color_types = (GridView) view.findViewById(R.id.color_type);
        TextView jian = (TextView) view.findViewById(R.id.jian);
        TextView add = (TextView) view.findViewById(R.id.add);
        goodprice.setText("￥"+goodTitleData.getData().get(0).getPrice()+"0");
        cankaoprice.setText("(参考价： ￥"+goodTitleData.getData().get(0).getDeposit()+"0）");
        name.setText(goodTitleData.getData().get(0).getName());
        add_prices.setText("￥"+goodTitleData.getData().get(0).getPrice()+"0");
        handleSelectColorGood(goodTitleData,enable_color,color_types);
        final PopupWindow popupWindow = new PopupWindow(view,lingyong.getWidth(),GetAddress.sp2px(GoodActivity.this,GetAddress.sp2px(GoodActivity.this,110)));
        popupWindow.setOutsideTouchable(false);
        int[] location = new int[2];
        lingyong.getLocationOnScreen(location);
        popupWindow.showAtLocation(lingyong, Gravity.TOP, location[0], location[1]-popupWindow.getHeight());
        final int[] a = {1};
        jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a[0] ==1){
                    ToastUtils.showToastSafe(GoodActivity.this,"选择的商品至少为1件");
                }else {
                    a[0]--;
                    count1.setText(a[0]+"");
                    add_prices.setText("￥"+(goodTitleData.getData().get(0).getPrice())* a[0] +"0");
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0]++;
                count1.setText(a[0]+"");
                add_prices.setText("￥"+(goodTitleData.getData().get(0).getPrice())* a[0] +"0");
            }
        });
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void handleSelectColorGood(GoodTitleData goodTitleData, final TextView enable_color, GridView color_types) {
        final List<GoodTitleData.DataBean> data = goodTitleData.getData();
        ColorBaseAdapter colorBaseAdapter = new ColorBaseAdapter(data);
        color_types.setAdapter(colorBaseAdapter);
        color_types.setSelector(new ColorDrawable(Color.TRANSPARENT));
        color_types.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                enable_color.setText("已选： "+data.get(position).getColor());
                for (int i = 0; i <parent.getChildCount() ; i++) {
                    RelativeLayout layout = (RelativeLayout) parent.getChildAt(i);
                    TextView text = (TextView) layout.getChildAt(0);
                    text.setTextColor(getResources().getColor(R.color.textColor1));
                    text.setEnabled(false);
                }
                RelativeLayout layout = (RelativeLayout) parent.getChildAt(position);
                TextView text = (TextView) layout.getChildAt(0);
                text.setEnabled(true);
                text.setTextColor(getResources().getColor(R.color.homeback_color));
            }
        });
    }

    private void initGoodBanner() {

        DownLoadGoodBannerDataUtil bannerDataUtil = new DownLoadGoodBannerDataUtil(this,id);
        bannerDataUtil.downLoadGoodBannerData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GoodBannerData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GoodBannerData goodBannerData) {
                        splashBanner(goodBannerData);
                        initPoint(goodBannerData);
                    }

                    private void initPoint(GoodBannerData goodBannerData) {
                        //添加小圆点
                        for (int i = 0; i <goodBannerData.getData().size() ; i++) {
                            View pointView = new View(GoodActivity.this);
                            pointView.setBackgroundResource(R.drawable.selector_bg_point);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GetAddress.sp2px(GoodActivity.this,10),GetAddress.sp2px(GoodActivity.this,10));
                            layoutParams.leftMargin = GetAddress.sp2px(GoodActivity.this,10);
                            // 设置默认所有都不可用
                            pointView.setEnabled(false);
                            point_container.addView(pointView, layoutParams);
                        }
                        point_container.getChildAt(0).setEnabled(true);
                    }

                    private void splashBanner(final GoodBannerData goodBannerData) {
                        Log.e("DATA",goodBannerData.toString());
                        List<ImageView> views = new ArrayList<ImageView>();
                        for (int j = 0; j <2 ; j++) {
                            for (int i = 0; i < goodBannerData.getData().size(); i++) {
                                ImageView image = new ImageView(GoodActivity.this);
                                image.setScaleType(ImageView.ScaleType.FIT_XY);
                                Picasso.with(GoodActivity.this).load(goodBannerData.getData().get(i).getPic()).into(image);
                                views.add(image);
                            }
                        }

                        if (views != null) {
                            BannerAdapter adapter = new BannerAdapter(views);
                            xiangqing_good.setAdapter(adapter);
                        }

                        xiangqing_good.setCurrentItem(1);

                        xiangqing_good.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                                int newposition = position % (goodBannerData.getData().size());
                                for (int i = 0; i < point_container.getChildCount(); i++) {
                                    point_container.getChildAt(i).setEnabled(false);
                                }
                                point_container.getChildAt(newposition).setEnabled(true);
                            }

                            @Override
                            public void onPageSelected(int position) {

                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {

                            }
                        });

                    }


                });

    }

    private void initView() {
        xiangqing_good = (ViewPager) findViewById(R.id.xiangqing_good);
        title = (TextView) findViewById(R.id.title);
        yajin = (TextView) findViewById(R.id.yajin);
        homepager = (TextView) findViewById(R.id.homepager);
        shichangjia = (TextView) findViewById(R.id.shichangjia);
        discove_return = (ImageView) findViewById(R.id.discove_return);
        guige = (RelativeLayout) findViewById(R.id.guige);
        lingyong = (RelativeLayout) findViewById(R.id.lingyong);
        add_xiangqing = (LinearLayout) findViewById(R.id.add_xiangqing);
        point_container = (LinearLayout) findViewById(R.id.point_container);
        intent = getIntent();
        id = intent.getIntExtra("id",1);
    }
    private void openTimer() {
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while(isRunning){
                    synchronized (GoodActivity.class){
                        try {
                            Thread.sleep(3000);
                            ThreadUtils.runInUThread(new Runnable() {
                                @Override
                                public void run() {
                                    xiangqing_good.setCurrentItem(xiangqing_good.getCurrentItem()+1);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    class  ColorBaseAdapter extends BaseAdapter{
        private List<GoodTitleData.DataBean> data;
        public ColorBaseAdapter(List<GoodTitleData.DataBean> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position).getColor();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (holder == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(GoodActivity.this).inflate(R.layout.color_type_item,null);
                holder.color = (TextView) convertView.findViewById(R.id.color_type);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.color.setText(data.get(position).getColor());
            return convertView;
        }
        class  ViewHolder{
            private TextView color;
        }
    }
}
