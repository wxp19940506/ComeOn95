package com.example.administrator.comeon95;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import RetrofitData.DownLoadMenuDataUtils;
import RetrofitData.DownLoadMenuGridDataUtils;
import RetrofitData.DownLoadUtils;
import javabeans.GridData;
import javabeans.HomePagerData;
import javabeans.MenuData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

import static com.example.administrator.comeon95.R.id.texts;

public class
MenuActivity extends AppCompatActivity {
    ImageView menu;
    GridView menuGrid;
    ListView menuList;
    private String PATH = GetAddress.PATH;
    private List<Map<String,Object>> data,itemsstring;
    List<Map<String,Object>>  list,gridlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
        //初始化数据源
        initData();
        initFirstItem();
        initLinister();

    }

    private void initLinister() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // listView每一项的点击事件
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i <parent.getChildCount() ; i++) {
                     LinearLayout layout = (LinearLayout) parent.getChildAt(i);
                     TextView text = (TextView) layout.getChildAt(0);
                     text.setTextColor(getResources().getColor(R.color.textColor1));
                }
                LinearLayout layout = (LinearLayout)view;
                TextView text = (TextView) layout.getChildAt(0);
                text.setTextColor(getResources().getColor(R.color.text_red1));
                DownLoadMenuGridDataUtils gridDataUtils = new DownLoadMenuGridDataUtils(MenuActivity.this, (Integer) ((Map)list.get(position)).get("id"));
                gridDataUtils.downLoadData(PATH)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<GridData>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(GridData gridData) {
                                gridlist = new ArrayList();
                                for (int i = 0; i < gridData.getData().size(); i++) {
                                    Map map = new HashMap();
                                    map.put("menuName",gridData.getData().get(i).getMenuName());
                                    map.put("menuPic",gridData.getData().get(i).getMenuPic());
                                    gridlist.add(map);

                                }
                                initGridAdapter(gridlist);
                            }
                        });
            }
        });
    }

    private void initView() {
        menu = (ImageView) findViewById(R.id.menu);
        menuGrid = (GridView) findViewById(R.id.menu_grid);
        menuList = (ListView) findViewById(R.id.menu_list);
        data = new ArrayList<>();
        itemsstring = new ArrayList<>();
    }

    private void initData() {
        DownLoadMenuDataUtils loadUtils = new DownLoadMenuDataUtils(this);
        loadUtils.downLoadData(PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MenuData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MenuData menuData) {
                        list = new ArrayList();
                        for (int i = 0; i < menuData.getData().size(); i++) {
                            Map  map = new HashMap();
                            map.put("id",menuData.getData().get(i).getId());
                            map.put("name",menuData.getData().get(i).getMenuName());
                            list.add(map);

                        }
                            initListAdapter(list);
                    }
                });

    }

    private void initListAdapter(final List list) {
        MenuListAdapter adapter = new MenuListAdapter(list);
            // 给ListView设置适配器
        menuList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        LinearLayout linearlayout = (LinearLayout) menuList.getChildAt(0);
        TextView text = (TextView) linearlayout.getChildAt(0);
        text.setTextColor(getResources().getColor(R.color.text_red1));
    }

    private void initGridAdapter(List<Map<String, Object>> list) {
        GridAdapter gridAdapter = new GridAdapter(list);
        menuGrid.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();
    }
    class GridAdapter extends BaseAdapter{
        private List list;
        public GridAdapter(List list) {
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
                convertView = LayoutInflater.from(MenuActivity.this).inflate(R.layout.grid_item,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.menu_icon);
                holder.texts = (TextView) convertView.findViewById(R.id.menu_text);
                convertView.setTag(convertView);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(MenuActivity.this).load((String) ((Map)(list.get(position))).get("menuPic")).into(holder.icon);
            holder.texts.setText(((Map)list.get(position)).get("menuName")+"");
            return convertView;
        }
        class ViewHolder{
            private ImageView icon;
            private TextView texts;
        }
    }
    class MenuListAdapter extends BaseAdapter{
        List list ;
        public MenuListAdapter(List list) {
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
                convertView = LayoutInflater.from(MenuActivity.this).inflate(R.layout.list_text,null);
                holder.text = (TextView) convertView.findViewById(R.id.item_text);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.text.setText(((Map)list.get(position)).get("name")+"");
            if (position == 0){
                holder.text.setTextColor(getResources().getColor(R.color.text_red1));
            }
            return convertView;
        }
       class ViewHolder{
           private TextView text;
       }
    }
    public  void initFirstItem (){
        DownLoadMenuGridDataUtils gridDataUtils = new DownLoadMenuGridDataUtils(MenuActivity.this, 1);
        gridDataUtils.downLoadData(PATH)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GridData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GridData gridData) {
                        gridlist = new ArrayList();
                        for (int i = 0; i < gridData.getData().size(); i++) {
                            Map map = new HashMap();
                            map.put("menuName",gridData.getData().get(i).getMenuName());
                            map.put("menuPic",gridData.getData().get(i).getMenuPic());
                            gridlist.add(map);

                        }
                        initGridAdapter(gridlist);
                    }
                });

    }
}
