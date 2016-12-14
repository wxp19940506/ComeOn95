package Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.comeon95.PublicBenefitItemActivity;
import com.example.administrator.comeon95.PublicBenefitOneToOneActivity;
import com.example.administrator.comeon95.R;
import com.squareup.picasso.Picasso;
import java.util.List;
import java.util.Map;
public class PublicBenefitAdapter1 extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> data;
    public PublicBenefitAdapter1(Context context, List data) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.public_benefit_convert2,null);
            holder.titles = (TextView) convertView.findViewById(R.id.titles);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load((String) data.get(position).get("image")).into(holder.image);
        holder.title.setText((CharSequence) data.get(position).get("title"));
        holder.titles.setText((CharSequence) data.get(position).get("titles"));
        LinstenConvertView(convertView,position);
        return convertView;
    }

    private void LinstenConvertView(View convertView, final int position) {
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PublicBenefitOneToOneActivity.class);
                intent.putExtra("id",(Integer)data.get(position).get("id"));
                context.startActivity(intent);
            }
        });

    }

    class ViewHolder{
        private ImageView image;
        private TextView title,titles;
    }

}
