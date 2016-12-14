package Adapters;

import android.content.Context;
import android.graphics.Paint;
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

import static com.example.administrator.comeon95.R.string.price;

/**
 * Created by Administrator on 2016/10/21 0021.
 */

public class LaibaiYouXuanAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> data;
    public LaibaiYouXuanAdapter(Context context, List data) {
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
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_laibaiyouxuan,parent,false);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.discountprice = (TextView) convertView.findViewById(R.id.discount_price);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load((String) data.get(position).get("image")).into(holder.image);
        holder.title.setText((CharSequence) data.get(position).get("title"));
        holder.discountprice.setText(data.get(position).get("discountprice")+"");
        holder.price.setText( data.get(position).get("price")+"");
        holder.price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
        return convertView;
    }
    class ViewHolder{
        private ImageView image;
        private TextView title,discountprice,price;
    }
}
