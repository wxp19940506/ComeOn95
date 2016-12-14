package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XianZhiActivity extends AppCompatActivity {
    private ListView xianzhilistview;
    private List<Map<String,Object>> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_zhi);
        initView();
        initData();
        initAdapter();
        addHeadView();
    }

    private void addHeadView() {
        View view = LayoutInflater.from(this).inflate(R.layout.xianzhi_headview,null);
        xianzhilistview.addHeaderView(view);
    }

    private void initAdapter() {
        XianZhiAdapter adapter = new XianZhiAdapter(data);
        Log.e("AAA",data.toString());
        xianzhilistview.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i <20 ; i++) {
            if (i%2 == 0){
                Map<String,Object> map = new HashMap();
                map.put("name","默默文文");
                map.put("time",(i*5)+"小时前");
                map.put("price","￥"+(70+i*5));
                map.put("decripte","这件商品特别棒");
                map.put("address","来自临沂市");
                data.add(map);
            }else if (i%2 == 1){
                Map<String,Object> map = new HashMap();
                map.put("name","182****4721");
                map.put("time",(i*6)+"小时前");
                map.put("price","￥"+(125+i*3));
                map.put("decripte","这件商品特别棒");
                map.put("address","来自济南市");
                data.add(map);
            }
        }
    }

    private void initView() {
        data = new ArrayList<>();
        xianzhilistview = (ListView) findViewById(R.id.xianzhilistview);
    }
    class XianZhiAdapter extends BaseAdapter{
        private List<Map<String,Object>> data;
        public XianZhiAdapter(List<Map<String,Object>> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView ==null){
                holder = new ViewHolder();
                convertView = getLayoutInflater().inflate(R.layout.xianzhi_item,null);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon);
                holder.image = (ImageView) convertView.findViewById(R.id.image);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.time = (TextView) convertView.findViewById(R.id.time);
                holder.price = (TextView) convertView.findViewById(R.id.price);
                holder.decripte = (TextView) convertView.findViewById(R.id.decripte);
                holder.address = (TextView) convertView.findViewById(R.id.address);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            Picasso.with(XianZhiActivity.this).load((String) data.get(position).get("icon")).into(holder.icon);
            Picasso.with(XianZhiActivity.this).load((String) data.get(position).get("image")).into(holder.image);
           //holder.icon.setImageResource((Integer) data.get(position).get("icon"));
//            holder.image.setImageResource((Integer) data.get(position).get("image"));
            holder.name.setText((String)data.get(position).get("name"));
            holder.time.setText((String)data.get(position).get("time"));
            holder.price.setText((String)data.get(position).get("price"));
            holder.decripte.setText((String)data.get(position).get("decripte"));
            holder.address.setText((String)data.get(position).get("address"));
            return convertView;
        }
        class ViewHolder{
            private ImageView icon,image;
            private TextView name,time,price,decripte,address;
        }
    }
}
