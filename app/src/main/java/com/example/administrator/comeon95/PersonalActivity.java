package com.example.administrator.comeon95;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import RetrofitData.UpdateNickNameWord;
import RetrofitData.UpdateSignWord;
import javabeans.SignStatue;
import javabeans.StatueData;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import uiutils.GetAddress;
import uiutils.ToastUtils;

public class PersonalActivity extends AppCompatActivity {
    private RelativeLayout qianming,update_background,select_icon;
    private EditText qianming_string,nicknamestring;
    private TextView cancel,enable,name,sex,birth,word;
    private PopupWindow popupWindow;
    private ImageView return_home,background,sex01,sex02;
    private String names,sexs,births,words,backgrounds;
    private LinearLayout sex1,sex2,update_image;
    private ImageView person_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        initLinister();
    }

    private void initLinister() {
        update_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex01.setEnabled(true);
                sex02.setEnabled(false);
            }
        });
        sex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sex01.setEnabled(false);
                sex02.setEnabled(true);
            }
        });
        return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        select_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parent =  LayoutInflater.from(PersonalActivity.this).inflate(R.layout.activity_personal,null);
                View view = LayoutInflater.from(PersonalActivity.this).inflate(R.layout.gexingnicheng,null);
                nicknamestring = (EditText) view.findViewById(R.id.nicknamestring);
                cancel = (TextView) view.findViewById(R.id.cancel);
                enable = (TextView) view.findViewById(R.id.enable);
                popupWindow =  new PopupWindow(view, GetAddress.sp2px(PersonalActivity.this,260),GetAddress.sp2px(PersonalActivity.this,220));
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation( parent,Gravity.CENTER,0,0);
                popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                enable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!nicknamestring.getText().equals("") && nicknamestring.getText() != null){
                            String text = String.valueOf(nicknamestring.getText());
                            int id = getIntent().getIntExtra("id",2);
                            UpdateNickNameWord signWord = new UpdateNickNameWord();
                            signWord.updateNickName(GetAddress.PATH,id,text)
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Action1<SignStatue>() {
                                        @Override
                                        public void call(SignStatue s) {
                                            if (s.getResult().equals("success") ){
                                                ToastUtils.showToastSafe(PersonalActivity.this,"修改昵称成功！");
                                            }else {
                                                ToastUtils.showToastSafe(PersonalActivity.this,"很遗憾，修改昵称失败！");
                                            }
                                        }
                                    }, new Action1<Throwable>() {
                                        @Override
                                        public void call(Throwable throwable) {
                                            Log.e("Login",throwable.toString());
                                        }
                                    });

                        }
                    }
                });
            }
        });
        update_background.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent  = new Intent(PersonalActivity.this,PersonalBackgroundActivity.class);
                        startActivityForResult(intent,0);
                    }
                }
        );
        qianming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(PersonalActivity.this).inflate(R.layout.gexingqianming,null);
                View rootview = LayoutInflater.from(PersonalActivity.this).inflate(R.layout.activity_personal,null);
                qianming_string = (EditText) view.findViewById(R.id.qianming_string);
                cancel = (TextView) view.findViewById(R.id.cancel);
                enable = (TextView) view.findViewById(R.id.enable);
                View parent =  LayoutInflater.from(PersonalActivity.this).inflate(R.layout.activity_personal,null);
                popupWindow =  new PopupWindow(view, GetAddress.sp2px(PersonalActivity.this,260),GetAddress.sp2px(PersonalActivity.this,220));
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation( parent,Gravity.CENTER,0,0);
                popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                //这里给它设置了弹出的时间，
//                imm.toggleSoftInput(1000, InputMethodManager.HIDE_NOT_ALWAYS);

                rootview.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.popup_background)));//设置背景不为空但是完全透明
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                enable.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!qianming_string.getText().equals("") && qianming_string.getText() != null){
                            String text = String.valueOf(qianming_string.getText());
                            int id = getIntent().getIntExtra("id",2);
                            UpdateSignWord signWord = new UpdateSignWord();
                            signWord.updateWord(GetAddress.PATH,id,text)
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Action1<SignStatue>() {
                                        @Override
                                        public void call(SignStatue s) {
                                            if (s.getResult().equals("success") ){
                                                ToastUtils.showToastSafe(PersonalActivity.this,"发布个性签名成功！");
                                            }else {
                                                ToastUtils.showToastSafe(PersonalActivity.this,"很遗憾，发布个性签名失败！");
                                            }
                                        }
                                    }, new Action1<Throwable>() {
                                        @Override
                                        public void call(Throwable throwable) {
                                        }
                                    });

                        }
                    }
                });

            }
        });

    }

    private void initView() {
        update_image = (LinearLayout) findViewById(R.id.update_image);
        background = (ImageView) findViewById(R.id.background);
        sex1 = (LinearLayout) findViewById(R.id.sex1);
        sex2 = (LinearLayout) findViewById(R.id.sex2);
        sex01 = (ImageView) findViewById(R.id.sex01);
        sex02 = (ImageView) findViewById(R.id.sex02);
        qianming = (RelativeLayout) findViewById(R.id.qianming);
        update_background = (RelativeLayout) findViewById(R.id.update_background);
        select_icon = (RelativeLayout) findViewById(R.id.select_icon);
        name = (TextView) findViewById(R.id.name);
        birth = (TextView) findViewById(R.id.birth);
        word = (TextView) findViewById(R.id.word);
        return_home = (ImageView) findViewById(R.id.return_home);
        names = getIntent().getStringExtra("name");
        sexs = getIntent().getStringExtra("sex");
        births = getIntent().getStringExtra("birth");
        words = getIntent().getStringExtra("word");
        backgrounds = getIntent().getStringExtra("background");
        name.setText(names);
        //sex.setText(sexs);
        birth.setText(births);
        word.setText(words);
        sex01.setEnabled(true);
        sex02.setEnabled(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode ==1){
            String url = data.getStringExtra("background");
            Picasso.with(PersonalActivity.this).load(url).into(background);
        }
    }

}
