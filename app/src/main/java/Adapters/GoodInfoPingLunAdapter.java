package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.comeon95.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

import javabeans.GoodInfoPingLun;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class GoodInfoPingLunAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, String>> data;
    public GoodInfoPingLunAdapter(Context context, List<Map<String, String>> data) {
        this.context = context;
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
        if (holder == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.good_info_pinglun,parent,false);
            holder.person_icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(data.get(position).get("pic")).into(holder.person_icon);
        holder.name.setText(data.get(position).get("name"));
        holder.time.setText(data.get(position).get("time"));
        holder.content.setText(data.get(position).get("content"));
        return convertView;
    }
    class ViewHolder {
        private ImageView person_icon;
        private TextView name,content,time;
    }
}
