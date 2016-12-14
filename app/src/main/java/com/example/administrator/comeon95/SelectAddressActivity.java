package com.example.administrator.comeon95;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;;import uiutils.ThreadUtils;

public class SelectAddressActivity extends AppCompatActivity {
    private ListView provinces_list,cities_list,districts_list;
    List<Map<String,String>> provice;
    List<Map<String,String>> city_list;
    List<Map<String,String>> district_list;
    private String id;
    private StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);
        initView();
        initData();
        initAdapter();
        initLinister();
    }

    private void initLinister() {
        provinces_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                stringBuffer.append(provice.get(position-1).get("name")+" ");
                try {
                    provinces_list.setVisibility(View.GONE);
                    cities_list.setVisibility(View.VISIBLE);
                    city_list = getCityFromXml(provice.get(position -1).get("id"));
                    if (city_list != null && !cities_list.equals( "")) {
                        SimpleAdapter adapter = new SimpleAdapter(SelectAddressActivity.this,city_list,R.layout.provice_list,new String[]{"city"},new int[]{R.id.provice});
                        cities_list.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        cities_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stringBuffer.append(city_list.get(position-1).get("city")+" ");
                cities_list.setVisibility(View.GONE);
                districts_list.setVisibility(View.VISIBLE);
                try {
                    district_list  = getDistrictFromXml(city_list.get(position -1).get("cid"));
                    SimpleAdapter adapter = new SimpleAdapter(SelectAddressActivity.this,district_list,R.layout.provice_list,new String[]{"district"},new int[]{R.id.provice});
                    districts_list.setAdapter(adapter);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        districts_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                stringBuffer.append(district_list.get(position-1).get("district"));
                Intent intent = new Intent(SelectAddressActivity.this,AddAddressActivity.class);
                intent.putExtra("address",stringBuffer.toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void initAdapter() {
        SimpleAdapter adapter = new SimpleAdapter(this,  provice,R.layout.provice_list,new String[]{"name"},new int[]{R.id.provice});
        provinces_list.setAdapter(adapter);
        View view = LayoutInflater.from(this).inflate(R.layout.city_headview,null);
        TextView address_text = (TextView) view.findViewById(R.id.address);
        address_text.setText(getIntent().getStringExtra("address"));
        provinces_list.addHeaderView(view);
        cities_list.addHeaderView(view);
        districts_list.addHeaderView(view);
    }

    private void initData() {
        try {
            provice = getProviceFromXml();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        provinces_list = (ListView) findViewById(R.id.provinces_list);
        cities_list = (ListView) findViewById(R.id.cities_list);
        districts_list = (ListView) findViewById(R.id.districts_list);
        provice = new ArrayList<>();
        city_list = new ArrayList<>();
        district_list = new ArrayList<>();
        stringBuffer = new StringBuffer();
    }
    private List<Map<String,String>> getProviceFromXml() throws XmlPullParserException, IOException {
        List<Map<String,String>> list = null;
        XmlResourceParser parser = getResources().getXml(R.xml.provinces);
        int event = parser.getEventType();
        while (event != XmlResourceParser.END_DOCUMENT){
            switch (event){
                case XmlResourceParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;
                case XmlResourceParser.START_TAG:
                    Map map = null;
                    if ("Province".equals(parser.getName())){
                        map = new HashMap();
                        if("ID".equals(parser.getAttributeName(0))){
                            map.put("id",parser.getAttributeValue(0));
                        }
                        list.add(map);
                        String prov = parser.nextText();
                        map.put("name",prov);
                    }
                    break;
            }
            event = parser.next();
        }
        return list;
    }
    private List<Map<String,String>> getCityFromXml(String id) throws XmlPullParserException, IOException {
        List<Map<String,String>> list = null;
        Log.e("TAGid",id+"");
        XmlResourceParser parser = getResources().getXml(R.xml.cities);
        int event = parser.getEventType();
        while (event != XmlResourceParser.END_DOCUMENT){
            switch (event){
                case XmlResourceParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;
                case XmlResourceParser.START_TAG:
                    if ("City".equals(parser.getName())  ){
                        Map<String,String> map = new HashMap<>();
                        if (id.equals(parser.getAttributeValue(null, "PID"))){
                            map.put("cid",parser.getAttributeValue(null,"ID"));
                            String city = parser.nextText();
                            map.put("city",city);
                            list.add(map);
                        }
                    }
                break;
            }
            event = parser.next();
        }
        return list;
    }
    private List<Map<String,String>> getDistrictFromXml(String id) throws XmlPullParserException, IOException {
        Log.e("TAG_cityid",id);
        List<Map<String,String>> list = null;
        XmlResourceParser parser = getResources().getXml(R.xml.districts);
        int event = parser.getEventType();
        while (event != XmlResourceParser.END_DOCUMENT){
            switch (event){
                case XmlResourceParser.START_DOCUMENT:
                    list = new ArrayList<>();
                    break;
                case XmlResourceParser.START_TAG:
                    if ("District".equals(parser.getName()) ){
                        if (id .equals(parser.getAttributeValue(null, "CID"))){
                            String district = parser.nextText();
                            Map<String,String> map = new HashMap();
                            map.put("district",district);
                            list.add(map);
                        }
                    }
                    break;
            }
            event = parser.next();
        }

        return list;
    }
}
