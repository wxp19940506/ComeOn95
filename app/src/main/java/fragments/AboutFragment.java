package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.comeon95.R;


public class AboutFragment extends Fragment {
    private TextView about_laibai,about_beike,about_beiquan,about_safezuoyi,about_laibaiyouxuan,about_xianzhi,about_gonfyi,about_vip,about_tuihuan,about_fahuo,about_shouhuo,about_tuihuo,about_enable_tuihuo;
    String about_laibai_string;
    String about_beike_string ;
    String about_beiquan_string;
    String about_safezuoyi_string;
    String about_laibaiyouxuan_string;
    String about_xianzhi_string;
    String about_gonfyi_string;
    String about_vip_string;
    String about_tuihuan_string;
    String about_fahuo_string;
    String about_shouhuo_string;
    String about_tuihuo_string;
    String about_enable_tuihuo_string;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        init(view);
        initTextView();
        return view;
    }

    private void initTextView() {
        setMuliTextColor(0,5,about_laibai,about_laibai_string);
        setMuliTextColor(0,5,about_beike,about_beike_string);
        setMuliTextColor(0,5,about_beiquan,about_beiquan_string);
        setMuliTextColor(0,8,about_safezuoyi,about_safezuoyi_string);
        setMuliTextColor(0,6,about_laibaiyouxuan,about_laibaiyouxuan_string);
        setMuliTextColor(0,5,about_xianzhi,about_xianzhi_string);
        setMuliTextColor(0,5,about_gonfyi,about_gonfyi_string);
        setMuliTextColor(0,5,about_vip,about_vip_string);
        setMuliTextColor(0,6,about_tuihuan,about_tuihuan_string);
        setMuliTextColor(0,2,about_fahuo,about_fahuo_string);
        setMuliTextColor(0,2,about_shouhuo,about_shouhuo_string);
        setMuliTextColor(0,2,about_tuihuo,about_tuihuo_string);
        setMuliTextColor(0,5,about_enable_tuihuo,about_enable_tuihuo_string);
    }
    //设置一段文本中颜色不同
    private void setMuliTextColor(int a,int b,TextView text,String s){
        SpannableString styledText = new SpannableString(s);
        styledText.setSpan(new TextAppearanceSpan(getContext(), R.style.style0), a, b, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(styledText, TextView.BufferType.SPANNABLE);
    }
    private void init(View view) {
        about_laibai = (TextView) view.findViewById(R.id.about_laibai);
        about_beike = (TextView) view.findViewById(R.id.about_beike);
        about_beiquan = (TextView) view.findViewById(R.id.about_beiquan);
        about_safezuoyi = (TextView) view.findViewById(R.id.about_safezuoyi);
        about_laibaiyouxuan = (TextView) view.findViewById(R.id.about_laibaiyouxuan);
        about_xianzhi = (TextView) view.findViewById(R.id.about_xianzhi);
        about_gonfyi = (TextView) view.findViewById(R.id.about_gonfyi);
        about_vip = (TextView) view.findViewById(R.id.about_vip);
        about_tuihuan = (TextView) view.findViewById(R.id.about_tuihuan);
        about_fahuo = (TextView) view.findViewById(R.id.about_fahuo);
        about_shouhuo = (TextView) view.findViewById(R.id.about_shouhuo);
        about_tuihuo = (TextView) view.findViewById(R.id.about_tuihuo);
        about_enable_tuihuo = (TextView) view.findViewById(R.id.about_enable_tuihuo);

        about_laibai_string = getContext().getResources().getString(R.string.about_laibai_string);
        about_beike_string = getContext().getResources().getString(R.string.about_beike_string);
        about_beiquan_string = getContext().getResources().getString(R.string.about_beiquan_string);
        about_safezuoyi_string = getContext().getResources().getString(R.string.about_safezuoyi_string);
        about_laibaiyouxuan_string = getContext().getResources().getString(R.string.about_laibaiyouxuan_string);
        about_xianzhi_string = getContext().getResources().getString(R.string.about_xianzhi_string);
        about_gonfyi_string = getContext().getResources().getString(R.string.about_gonfyi_string);
        about_vip_string = getContext().getResources().getString(R.string.about_vip_string);
        about_tuihuan_string = getContext().getResources().getString(R.string.about_tuihuan_string);
        about_fahuo_string = getContext().getResources().getString(R.string.about_fahuo_string);
        about_shouhuo_string = getContext().getResources().getString(R.string.about_shouhuo_string);
        about_tuihuo_string = getContext().getResources().getString(R.string.about_tuihuo_string);
        about_enable_tuihuo_string = getContext().getResources().getString(R.string.about_enable_tuihuo_string);

    }

}
