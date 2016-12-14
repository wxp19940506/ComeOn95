package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.comeon95.HelppingActivity;
import com.example.administrator.comeon95.MySomethingActivity;
import com.example.administrator.comeon95.PersonalActivity;
import com.example.administrator.comeon95.PersonalBackgroundActivity;
import com.example.administrator.comeon95.PersonalShuoShuoActivity;
import com.example.administrator.comeon95.R;
import com.example.administrator.comeon95.RentActivity;
import com.example.administrator.comeon95.SettingActivity;
import com.squareup.picasso.Picasso;

import RetrofitData.DownLoadPersonData;
import javabeans.PersonData;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;

import static com.example.administrator.comeon95.R.id.user_icon;

public class MyselfFragment extends Fragment implements View.OnClickListener {
    private RelativeLayout setting,helpping,myslf_rel1,myslf_rel2,myslf_rel3,myslf_rel4,myslf_rel5;
    private ImageView background ,personicon;
    private TextView nickname;
    private int id;

    public MyselfFragment(int id) {
        this.id = id;
    }

    public MyselfFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myself, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        DownLoadPersonData personData = new DownLoadPersonData(getContext());
        personData.downPersonData(GetAddress.PATH,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PersonData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PersonData personData) {
                        downPersonInfo(personData);
                        initLinister(personData);
                    }
                });
    }

    private void downPersonInfo(PersonData personData) {
        nickname.setText(personData.getObj().getNickName());
        Picasso.with(getContext()).load(personData.getObj().getBackground()).into(background);
        Picasso.with(getContext()).load(personData.getObj().getHeadPic()).into(personicon);
    }

    private void initLinister(final PersonData personData) {
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SettingActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",personData.getObj().getNickName());
                intent.putExtra("sex",personData.getObj().getSex());
                intent.putExtra("birth",personData.getObj().getBirth());
                intent.putExtra("pic",personData.getObj().getHeadPic());
                intent.putExtra("word",personData.getObj().getWord());
                intent.putExtra("location",personData.getObj().getLocation());
                intent.putExtra("background",personData.getObj().getBackground());
                intent.putExtra("guanzhu",personData.getObj().getCareNum());
                intent.putExtra("zan",personData.getObj().getZanNum());
                startActivity(intent);
            }
        });
        helpping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),HelppingActivity.class);
                startActivity(intent);
            }
        });
        myslf_rel1.setOnClickListener(this);
        myslf_rel2.setOnClickListener(this);
        myslf_rel3.setOnClickListener(this);
        myslf_rel4.setOnClickListener(this);
        myslf_rel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),RentActivity.class);
                startActivity(intent);
            }
        });
        personicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PersonalShuoShuoActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",personData.getObj().getNickName());
                intent.putExtra("sex",personData.getObj().getSex());
                intent.putExtra("birth",personData.getObj().getBirth());
                intent.putExtra("pic",personData.getObj().getHeadPic());
                intent.putExtra("word",personData.getObj().getWord());
                intent.putExtra("location",personData.getObj().getLocation());
                intent.putExtra("background",personData.getObj().getBackground());
                intent.putExtra("guanzhu",personData.getObj().getCareNum());
                intent.putExtra("zan",personData.getObj().getZanNum());
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        setting = (RelativeLayout) view.findViewById(R.id.myslf_rel7);
        helpping = (RelativeLayout) view.findViewById(R.id.myslf_rel8);
        myslf_rel1 = (RelativeLayout) view.findViewById(R.id.myslf_rel1);
        myslf_rel2 = (RelativeLayout) view.findViewById(R.id.myslf_rel2);
        myslf_rel3 = (RelativeLayout) view.findViewById(R.id.myslf_rel3);
        myslf_rel4 = (RelativeLayout) view.findViewById(R.id.myslf_rel4);
        myslf_rel5 = (RelativeLayout) view.findViewById(R.id.myslf_rel5);
        nickname = (TextView) view.findViewById(R.id.nickname);
        background = (ImageView) view.findViewById(R.id.background);
        personicon = (ImageView) view.findViewById(R.id.personicon);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),MySomethingActivity.class);
        switch (v.getId()){
            case R.id.myslf_rel1:
                intent.putExtra("title","我的说说");
                intent.putExtra("shuoming","你还没有发布说说");
                break;
            case R.id.myslf_rel2:
                intent.putExtra("title","我的闲置");
                intent.putExtra("shuoming","还没有闲置哦");
                break;
            case R.id.myslf_rel3:
                intent.putExtra("title","我卖出的");
                intent.putExtra("shuoming","您暂时还没有卖出的宝贝");
                break;
            case R.id.myslf_rel4:
                intent.putExtra("title","我买到的");
                intent.putExtra("shuoming","你还没有买到的宝贝");
                break;
            case R.id.myslf_rel5:
                intent.putExtra("title","我的租赁");
                intent.putExtra("shuoming","我的租赁");
                break;
        }
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
