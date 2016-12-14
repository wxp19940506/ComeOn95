package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ServiceTitleActivity extends AppCompatActivity {
    private ImageView return1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_title);
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
    }

    private void initView() {
        return1 = (ImageView) findViewById(R.id.return1);
    }
}
