package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RentActivity extends AppCompatActivity {
    private ImageView return1;
    private RelativeLayout myyaoqing,myticket,youhuiquan,dianzibaodan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        initView();
        initLinister();
    }

    private void initLinister() {
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        myyaoqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentActivity.this,YaoQingActivity.class);
                startActivity(intent);
            }
        });
        myticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentActivity.this,MyRentActivity.class);
                startActivity(intent);
            }
        });
        youhuiquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentActivity.this,SelectYouHuiActivity.class);
                startActivity(intent);
            }
        });
        dianzibaodan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentActivity.this,DianZiBaoDanActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        return1 = (ImageView) findViewById(R.id.return1);
        myyaoqing = (RelativeLayout) findViewById(R.id.myyaoqing);
        myticket = (RelativeLayout) findViewById(R.id.myticket);
        youhuiquan = (RelativeLayout) findViewById(R.id.youhuiquan);
        dianzibaodan = (RelativeLayout) findViewById(R.id.dianzibaodan);
    }
}
