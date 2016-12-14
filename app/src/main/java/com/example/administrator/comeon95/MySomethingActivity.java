package com.example.administrator.comeon95;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MySomethingActivity extends AppCompatActivity {
    private TextView sometitle,shuoming;
    private ImageView return1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_something);
        init();
        initData();
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

    private void initData() {
        String titlestring = getIntent().getStringExtra("title");
        String shuomingstring = getIntent().getStringExtra("shuoming");
        Log.e("TAG",titlestring+""+shuomingstring);
        sometitle.setText(titlestring);
        shuoming.setText(shuomingstring);
    }

    private void init() {
        sometitle = (TextView) findViewById(R.id.sometitle);
        shuoming = (TextView) findViewById(R.id.shuoming);
        return1 = (ImageView) findViewById(R.id.return1);
    }
}
