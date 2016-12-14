package com.example.administrator.comeon95;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import RetrofitData.DownLoadPersonalBackgroundDataUtil;
import javabeans.PersonalBackgroundData;
import retrofit2.http.PATCH;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

import static com.example.administrator.comeon95.R.id.text;

public class PersonalBackgroundActivity extends AppCompatActivity {
    private TextView wancheng;
    private GridView images_contains;
    private List<String> list;
    private ImageView fanhui;
    private Intent intent;
    String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_background);
        initView();
        initBackgroundImage();
        initLinister();
    }

    private void initLinister() {
        wancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = getIntent();
                if (url != null && !url.equals("")){
                    intent.putExtra("background",url);
                    setResult(1,intent);
                    finish();
                }
            }
        });
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        images_contains.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <parent.getChildCount() ; i++) {
                    RelativeLayout layout = (RelativeLayout) parent.getChildAt(i);
                    ImageView image = (ImageView) layout.getChildAt(1);
                    image.setVisibility(View.GONE);
                }
                RelativeLayout layout = (RelativeLayout) parent.getChildAt(position);
                ImageView image = (ImageView) layout.getChildAt(1);
                image.setVisibility(View.VISIBLE);
                if (list != null && !list.equals("")){
                    url = list.get(position);
                }
            }

        });
    }

    private void initBackgroundImage() {
        DownLoadPersonalBackgroundDataUtil backgroundDataUtil = new DownLoadPersonalBackgroundDataUtil(this);
        backgroundDataUtil.downBaiQuanData(GetAddress.PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PersonalBackgroundData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PersonalBackgroundData personalBackgroundData) {
                        for (int i = 0; i < personalBackgroundData.getData().size(); i++) {
                            list.add(personalBackgroundData.getData().get(i).getBackPic());
                        }
                        ImagesBaseAdapter adapter = new ImagesBaseAdapter(list);
                        images_contains.setAdapter(adapter);
                    }
                });
    }

    private void initView() {
        wancheng = (TextView) findViewById(R.id.wancheng);
        images_contains = (GridView) findViewById(R.id.images_contains);
        fanhui = (ImageView) findViewById(R.id.fanhui);
        list = new ArrayList<>();
    }
    class ImagesBaseAdapter extends BaseAdapter{
        private List<String> list;
        public ImagesBaseAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
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
                convertView = LayoutInflater.from(PersonalBackgroundActivity.this).inflate(R.layout.background_item,parent,false);
                holder.backImage = (ImageView) convertView.findViewById(R.id.imageview);
                holder.imageView0 = (ImageView) convertView.findViewById(R.id.imageview0);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(PersonalBackgroundActivity.this).load(list.get(position)).into(holder.backImage);
            Picasso.with(PersonalBackgroundActivity.this).load(R.mipmap.checked).into(holder.imageView0);
            return convertView;
        }
        class ViewHolder{
            private ImageView backImage,imageView0;
        }
    }
}
