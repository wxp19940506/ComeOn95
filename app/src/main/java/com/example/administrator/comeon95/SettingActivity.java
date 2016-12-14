package com.example.administrator.comeon95;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import uiutils.ToastUtils;

public class SettingActivity extends BaseActivity {
    private ImageView returnForest;
    private RelativeLayout update_password,setting_address,servicetitle,setting_rel1,setting_rel3;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initLinister();
    }

    private void initLinister() {
        setting_rel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,BindWeChatActivity.class);
                startActivity(intent);
            }
        });
        returnForest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        update_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,ResetPasswordActivity.class);
                intent.putExtra("id",getIntent().getIntExtra("id",2));
                startActivity(intent);
            }
        });
        setting_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,ManageAddressActivity.class);
                startActivity(intent);
            }
        });
        servicetitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,ServiceTitleActivity.class);
                startActivity(intent);
            }
        });
        setting_rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this,PersonalActivity.class);
                intent.putExtra("id",getIntent().getIntExtra("id",2));
                intent.putExtra("name",getIntent().getStringExtra("name"));
                intent.putExtra("sex",getIntent().getStringExtra("sex"));
                intent.putExtra("word",getIntent().getStringExtra("word"));
                intent.putExtra("background",getIntent().getStringExtra("background"));
                intent.putExtra("birth",getIntent().getStringExtra("birth"));
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToastSafe(SettingActivity.this,"退出账号成功！");
                BaseApplication baseApplication = (BaseApplication) getApplication();
                SharedPreferences.Editor islogin_edit = baseApplication.getIslogin_edit();
                islogin_edit.putBoolean("islogin",false).commit();
                Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void initView() {
        returnForest = (ImageView) findViewById(R.id.return1);
        update_password = (RelativeLayout) findViewById(R.id.update_password);
        setting_address = (RelativeLayout) findViewById(R.id.setting_address);
        servicetitle = (RelativeLayout) findViewById(R.id.servicetitle);
        setting_rel1 = (RelativeLayout) findViewById(R.id.setting_rel1);
        setting_rel3 = (RelativeLayout) findViewById(R.id.setting_rel3);
        exit = (Button) findViewById(R.id.exit);
    }
}
