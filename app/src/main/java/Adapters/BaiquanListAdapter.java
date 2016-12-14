package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.comeon95.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/20 0020.
 */

public class BaiquanListAdapter extends BaseAdapter {
    private Context context;
    private List<Map> data;
    public BaiquanListAdapter(Context context, List data) {
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
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_command,parent,false);
            holder.icon = (ImageView) convertView.findViewById(R.id.icon);
            holder.imageView = (ImageView) convertView.findViewById(R.id.images);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.texts = (TextView) convertView.findViewById(R.id.texts);
            //holder.address = (TextView) convertView.findViewById(R.id.name);
            //holder.zan = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.icon.setBackgroundResource((Integer) data.get(position).get("icon"));
            holder.icon.setBackgroundResource((Integer) data.get(position).get("image"));
            holder.name.setText((String) data.get(position).get("name"));
            holder.texts.setText((String) data.get(position).get("texts"));

        return convertView;
    }
    class ViewHolder{
        private ImageView icon,imageView;
        private TextView name,texts,address,zan;

    }
}
