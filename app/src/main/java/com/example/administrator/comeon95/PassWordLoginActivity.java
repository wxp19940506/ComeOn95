package com.example.administrator.comeon95;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import RetrofitData.LoginPassWord;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import javabeans.StatueData;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ToastUtils;

public class PassWordLoginActivity extends AppCompatActivity {

    @Bind(R.id.phone_num)
    EditText phoneNum;
    @Bind(R.id.pass_word)
    EditText passWord;
    @Bind(R.id.loginnow)
    Button loginnow;
    @Bind(R.id.mainpager)
    TextView mainpager;
    private int id;
    private boolean isBlue0 = false;
    private boolean isBlue1 = false;
    private SharedPreferences preferences;
    private SharedPreferences.Editor islogin_edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        preferences = getSharedPreferences("comeon95_namepass",0);
        if (preferences != null) {
            phoneNum.setText(preferences.getString("name",""));
            passWord.setText(preferences.getString("password",""));
        }
    }

    @OnClick({R.id.phone_num, R.id.pass_word})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.phone_num:
                if (!phoneNum.getText().equals("")){
                    isBlue0 = true;
                }
                if (isBlue0 && isBlue1) {
                    loginnow.setBackgroundColor(getResources().getColor(R.color.text_red1));
                }
                break;
            case R.id.pass_word:
                if (!passWord.getText().equals("")){
                    isBlue1 = true;
                }
                if (isBlue0 && isBlue1) {
                    loginnow.setBackgroundColor(getResources().getColor(R.color.text_red1));
                }
                break;
        }
    }

    @OnClick(R.id.loginnow)
    public void onClick() {
        final String phone = phoneNum.getText().toString();
        final String password = passWord.getText().toString();
        LoginPassWord loginPassWord = new LoginPassWord();
        loginPassWord.downLoadUrlPost(GetAddress.PATH, phone, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<StatueData>() {
                    @Override
                    public void call(StatueData s) {
                        if (s.getResult().equals("true")) {
                            ToastUtils.showToastSafe(PassWordLoginActivity.this, "登录成功！");
                            preferences.edit().putString("name",phone).putString("password",password).commit();
                            BaseApplication application = (BaseApplication) getApplication();
                            islogin_edit = application.getIslogin_edit();
                            islogin_edit.putBoolean("islogin",true).commit();
                            Intent intent = new Intent(PassWordLoginActivity.this, MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("key", "0");
                            bundle.putInt("id", s.getId());
                            bundle.putBoolean("yesorno", true);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        } else {
                            ToastUtils.showToastSafe(PassWordLoginActivity.this, "用户名或密码错误");
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("Login", throwable.toString());
                    }
                });
    }

    @OnClick(R.id.mainpager)
    public void onClickHome() {
        Intent intent = new Intent(PassWordLoginActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", "0");
        bundle.putInt("id", 0);
        bundle.putBoolean("yesorno", false);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
