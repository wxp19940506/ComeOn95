package com.example.administrator.comeon95;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import uiutils.ThreadUtils;

public class SplashActivity extends BaseActivity {
    private BaseApplication application;
    private SharedPreferences sharedPreferences;
    private boolean islogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Intent intent = null;
                    Thread.sleep(3000);
                    if (!islogin){
                        intent = new Intent(SplashActivity.this,LoginActivity.class);
                    }else {
                        intent= new Intent(SplashActivity.this, MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("key", "0");
                        intent.putExtras(bundle);
                    }
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void initView(){
        application = (BaseApplication) getApplication();
        sharedPreferences = application.getIsloginsp();
        islogin = sharedPreferences.getBoolean("islogin",false);
    }
}
