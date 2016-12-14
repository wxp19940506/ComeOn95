package com.example.administrator.comeon95;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import RetrofitData.UpdatePassWord;
import javabeans.SignStatue;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ToastUtils;

public class ResetPasswordActivity extends AppCompatActivity {
    private EditText password1,password2;
    private Button enable;
    private int id;
    private ImageView return1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
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
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1_string = String.valueOf(password1.getText());
                String password2_string = String.valueOf(password2.getText());
                if (password1_string == password2_string){
                    UpdatePassWord updatePassWord = new UpdatePassWord();
                    updatePassWord.updatePassWord(GetAddress.PATH,id,password1_string)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<SignStatue>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(SignStatue signStatue) {
                                    if (signStatue.getResult().equals("true") ){
                                        ToastUtils.showToastSafe(ResetPasswordActivity.this,"修改密码成功！");

                                    }else {
                                        ToastUtils.showToastSafe(ResetPasswordActivity.this,"修改密码失败！");
                                    }
                                }
                            });
                }else if (password1_string != password2_string){
                    ToastUtils.showToastSafe(ResetPasswordActivity.this,"密码输入不一致");
                }
            }
        });
    }

    private void initView() {
        enable = (Button) findViewById(R.id.enable);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        return1 = (ImageView) findViewById(R.id.return1);
        id = getIntent().getIntExtra("id",2);
    }

}
