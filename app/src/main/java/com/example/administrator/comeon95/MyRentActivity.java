package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyRentActivity extends AppCompatActivity {
    private ImageView about_return;
    private TextView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rent);
        initView();
        initLinister();
    }

    private void initLinister() {
        about_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    private void initView() {
        about_return = (ImageView) findViewById(R.id.about_return);
        home = (TextView) findViewById(R.id.home);
    }
}
