package Adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class BannerAdapter extends PagerAdapter {
    private List<ImageView> list;
    public BannerAdapter(List<ImageView> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition = position % list.size();
        ImageView imageView = list.get(newPosition);
        //解决白页问题
        ViewGroup viewGroup = (ViewGroup) imageView.getParent();
//        if (viewGroup != null) {
//            viewGroup.removeAllViews();
//        }
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
