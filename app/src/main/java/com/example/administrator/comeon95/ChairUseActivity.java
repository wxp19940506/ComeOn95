package com.example.administrator.comeon95;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import uiutils.ThreadUtils;

public class ChairUseActivity extends AppCompatActivity {
    private ImageView image1;
    private TextView num;
    int a = 3;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chair_use);
        initView();
        initLinister();
        initThread();
    }

    private void initLinister() {
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnHomePager();
            }
        });
    }

    private void initThread() {
        timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ThreadUtils.runInUThread(new Runnable() {
                    @Override
                    public void run() {
                        num.setText(a+"");
                        a --;
                        if (a < 0){
                            timer.cancel();
                            turnHomePager();
                        }
                    }
                });

            }
        };
        timer.schedule(task, 1000, 1000);
    }
    private void turnHomePager(){
        if (isForeground(ChairUseActivity.this,"com.example.administrator.comeon95.ChairUseActivity")) {
            Intent intent = new Intent(ChairUseActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("key","1");
            intent.putExtras(bundle);
            startActivity(intent);
            ChairUseActivity.this.finish();
        }else {
            return;
        }

    }



    private void initView() {
        image1 = (ImageView) findViewById(R.id.image1);
        num = (TextView) findViewById(R.id.num);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }
    private boolean isForeground(Context context, String className) {
        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(1);
        if (list != null && list.size() > 0) {
            ComponentName cpn = list.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }

        return false;
    }

}
