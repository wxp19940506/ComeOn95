package Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.comeon95.PersonalShuoShuoActivity;
import com.example.administrator.comeon95.R;
import com.example.administrator.comeon95.ShuoShuoXiangQingActivity;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javabeans.SerializableMap;

/**
 * Created by Administrator on 2016/11/19 0019.
 */

public class BaiCircleAdapter extends BaseAdapter implements View.OnClickListener {
    private List<Map<String,Object>> data;
    private Context context;
    public BaiCircleAdapter(Context context,List<Map<String, Object>> data ) {
        this.data = data;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        List<ImageView> images = new ArrayList<>();
        ViewHolder holder = null;
        if (holder == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.baiquan_item,parent,false);
            holder.icon = (ImageView) convertView.findViewById(R.id.personicon);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.info = (TextView) convertView.findViewById(R.id.text_info);
            holder.location = (TextView) convertView.findViewById(R.id.location);
            holder.pinglun_count = (TextView) convertView.findViewById(R.id.pinglun_count);
            holder.zan_count = (TextView) convertView.findViewById(R.id.zan_count);
            holder.image_contain = (LinearLayout) convertView.findViewById(R.id.pic_contain);
            holder.shuoshuoxq = (LinearLayout) convertView.findViewById(R.id.shuoshuoxq);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load((String) data.get(position).get("icon")).into(holder.icon);
        holder.name.setText((String) data.get(position).get("name"));
        holder.time.setText((String) data.get(position).get("time"));
        holder.info.setText((String) data.get(position).get("info"));
        holder.location.setText((String) data.get(position).get("location"));
        holder.pinglun_count.setText((String) data.get(position).get("comcount"));
        holder.zan_count.setText((String) data.get(position).get("zancount"));
        if (data.get(position).get("pic1") != null &&data.get(position).get("pic1") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic1")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic2") != null &&data.get(position).get("pic2") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic2")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic3") != null &&data.get(position).get("pic3") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic3")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic4") != null &&data.get(position).get("pic4") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic4")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic5") != null &&data.get(position).get("pic5") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic5")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic6") != null &&data.get(position).get("pic6") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic6")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic7") != null &&data.get(position).get("pic7") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic7")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic8") != null &&data.get(position).get("pic8") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic8")).into(imageView);
            images.add(imageView);
        }else if (data.get(position).get("pic9") != null &&data.get(position).get("pic9") != ""){
            ImageView imageView = new ImageView(context);
            Picasso.with(context).load((String) data.get(position).get("pic9")).into(imageView);
            images.add(imageView);
        }
        for (int i = 0; i < images.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            holder.image_contain.addView(images.get(i),params);
        }
        holder.shuoshuoxq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShuoShuoXiangQingActivity.class);
                SerializableMap map = new SerializableMap();
                map.setMap(data.get(position));
                intent.putExtra("data", map);
                context.startActivity(intent);
            }
        });
        holder.name.setOnClickListener(this);
        holder.time.setOnClickListener(this);
        holder.icon.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,PersonalShuoShuoActivity.class);
        context.startActivity(intent);
    }

    class ViewHolder{
        private ImageView icon;
        private TextView name,time,info,location,pinglun_count,zan_count;
        private LinearLayout image_contain,shuoshuoxq;
    }
}
