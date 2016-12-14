package com.example.administrator.comeon95;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class BaseActivity extends AppCompatActivity {
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        initLinister();
    }

    private void initView() {
        // 创建退出对话框
        dialog = new AlertDialog.Builder(BaseActivity.this);

    }

    private void initLinister() {
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {

            // 设置对话框标题
            dialog.setTitle("退出提示");
            // 设置对话框消息
            dialog.setMessage("确定要退出程序吗？");
            // 添加选择按钮并注册监听
            dialog.create();
            // 显示对话框
            dialog.show();

        }

        return false;
    }



}
