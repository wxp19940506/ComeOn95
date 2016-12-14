package com.example.administrator.comeon95;

import android.app.Application;
import android.content.SharedPreferences;

import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2016/11/24 0024.
 */

public class BaseApplication extends Application {
    public SharedPreferences getIsloginsp() {
        return isloginsp;
    }

    public void setIsloginsp(SharedPreferences isloginsp) {
        this.isloginsp = isloginsp;
    }

    public SharedPreferences isloginsp;
    public SharedPreferences.Editor islogin_edit;

    public SharedPreferences.Editor getIslogin_edit() {
        return islogin_edit;
    }

    public void setIslogin_edit(SharedPreferences.Editor islogin_edit) {
        this.islogin_edit = islogin_edit;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ShareSDK.initSDK(this);
        SMSSDK.initSDK(this,"1829158f545e3","a1bc71cb81145cbba091891ae2aed0da");
//        SMSSDK.initSDK(this,"19637bbfc0184","27333266dcf97f3e9c118885323109d8");
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    ((Throwable)data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
        init();
    }

    private void init() {
        isloginsp = getSharedPreferences("islogin",0);
        islogin_edit = isloginsp.edit();
        setIslogin_edit(islogin_edit);
        setIsloginsp(isloginsp);
    }

}
