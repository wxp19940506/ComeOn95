package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageAddressActivity extends AppCompatActivity {
    private TextView add_address,addresstext;
    private static final int REQUEST_CODE = 1;//请求的请求码
    private ListView addresslistview;
    private List<Map> addresslist;
    private ImageView nullicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);
        initView();
        initLinister();
    }

    private void initView() {
        add_address = (TextView) findViewById(R.id.add_address);
        addresstext = (TextView) findViewById(R.id.addresstext);
        nullicon = (ImageView) findViewById(R.id.nullicon);
        addresslistview = (ListView) findViewById(R.id.addresslist);
        addresslist = new ArrayList();
    }

    private void initLinister() {
        add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageAddressActivity.this,AddAddressActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == 0 && data != null){
            addresstext.setVisibility(View.INVISIBLE);
            nullicon.setVisibility(View.INVISIBLE);
            Bundle bundle = data.getExtras();
            String editloc = bundle.getString("editloc")+bundle.getString("address_specific");
            String shouhuoren = bundle.getString("shouhuoren");
            String phone = bundle.getString("phone");
            Map map = new HashMap();
            map.put("shouhuoren",shouhuoren);
            map.put("phone",phone);
            map.put("editloc",editloc);
            addresslist.add(map);
            AddressAdapter addressAdapter = new AddressAdapter(addresslist);
            addresslistview.setAdapter(addressAdapter);

        }
    }
    class AddressAdapter extends BaseAdapter{
        private List<Map> addresslist;

        public AddressAdapter(List<Map> addresslist) {
            this.addresslist = addresslist;
        }

        @Override
        public int getCount() {
            return addresslist.size();
        }

        @Override
        public Object getItem(int position) {
            return addresslist.get(position);
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
                convertView = View.inflate(ManageAddressActivity.this,R.layout.addressitem,null);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.phone = (TextView) convertView.findViewById(R.id.phonenum);
                holder.address = (TextView) convertView.findViewById(R.id.address);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.name.setText((String) addresslist.get(position).get("shouhuoren"));
            holder.phone.setText((String) addresslist.get(position).get("phone"));
            holder.address.setText((String) addresslist.get(position).get("editloc"));
            return convertView;
        }
        class ViewHolder{
            private TextView name,phone,address;
        }
    }
}
