package com.example.administrator.comeon95;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.BDNotifyListener;//假如用到位置提醒功能，需要import该类
import com.baidu.location.Poi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uiutils.ToastUtils;

import static com.baidu.location.LocationClientOption.LocationMode.Hight_Accuracy;

public class AddAddressActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private EditText editloc,edit_address_specific,shouhuoren,phone;
    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;
    private TextView relocation;
    private TextView enable;
    private Bundle bundle;
    private StringBuffer stringBuffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        init();
        initLinister();
    }

    private void initLinister() {
        editloc.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           mLocationClient.stop();
                                           Intent intent = new Intent(AddAddressActivity.this,SelectAddressActivity.class);
                                           if (stringBuffer.toString() != "" && stringBuffer != null){
                                               intent.putExtra("address",stringBuffer.toString());
                                           }
                                           startActivityForResult(intent,REQUEST_CODE);
                                       }
                                   }
        );
        edit_address_specific.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           mLocationClient.stop();
                                       }
                                   }
        );
        relocation.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           mLocationClient.start();
                                       }
                                   }
        );
        enable.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (TextUtils.isEmpty(editloc.getText().toString().trim())){
                                               ToastUtils.showToastSafe(AddAddressActivity.this,"省市区不能为空");

                                               return;
                                           }else if (TextUtils.isEmpty(shouhuoren.getText().toString().trim())){
                                               ToastUtils.showToastSafe(AddAddressActivity.this,"收货人不能为空");
                                               return;
                                           } else if (TextUtils.isEmpty(phone.getText().toString().trim())){
                                               ToastUtils.showToastSafe(AddAddressActivity.this,"手机号不能为空");
                                               return;
                                           }else if (TextUtils.isEmpty(edit_address_specific.getText().toString().trim())){
                                               ToastUtils.showToastSafe(AddAddressActivity.this,"详细地址不能为空");
                                               return;
                                           }else if (bundle != null){
                                               ToastUtils.showToastSafe(AddAddressActivity.this,"Toast"+editloc.getText());
                                               Intent intent = new Intent(AddAddressActivity.this,ManageAddressActivity.class);
                                                intent.putExtras(bundle);
                                                setResult(0,intent);
                                                finish();
                                           }
//                                           if (editloc.getText().equals("") || shouhuoren.getText().equals("")|| phone.getText().equals("") || editloc.getText() == null || shouhuoren.getText() == null|| phone.getText() == null){
//                                               ToastUtils.showToastSafe(AddAddressActivity.this,"选项不能为空");
//                                               return;
//                                           }else if(bundle != null && !bundle.equals("")){
//                                                Intent intent = new Intent(AddAddressActivity.this,ManageAddressActivity.class);
//                                                intent.putExtras(bundle);
//                                                setResult(0,intent);
//                                                finish();
//                                            };
                                       }
                                   }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String address = data.getStringExtra("address");
            editloc.setText(address);
        }
    }

    private void init() {
        getPersimmions();
        editloc = (EditText) findViewById(R.id.editloc);
        shouhuoren = (EditText) findViewById(R.id.shouhuoren);
        phone = (EditText) findViewById(R.id.phone);
        relocation = (TextView) findViewById(R.id.relocation);
        edit_address_specific = (EditText) findViewById(R.id.edit_address_specific);
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        initLocation();
        mLocationClient.start();
        enable = (TextView) findViewById(R.id.enable);
        bundle = new Bundle();
        stringBuffer = new StringBuffer();


    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);
//            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation){// GPS定位结果
//                sb.append("\nspeed : ");
//                sb.append(location.getSpeed());// 单位：公里每小时
//                sb.append("\nsatellite : ");
//                sb.append(location.getSatelliteNumber());
//                sb.append("\nheight : ");
//                sb.append(location.getAltitude());// 单位：米
//                sb.append("\ndirection : ");
//                sb.append(location.getDirection());// 单位度
//                sb.append("\naddr : ");
//                sb.append(location.getAddrStr());
//                sb.append("\ndescribe : ");
//                sb.append("gps定位成功");
                ToastUtils.showToastSafe(AddAddressActivity.this,"定位成功！");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation){// 网络定位结果
//                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
//                //运营商信息
//                sb.append("\noperationers : ");
//                sb.append(location.getOperators());
//                sb.append("\ndescribe : ");
//                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
//                sb.append("\ndescribe : ");
//                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
//                sb.append("\ndescribe : ");
//                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
//                sb.append("\ndescribe : ");
//                sb.append("网络不同导致定位失败，请检查网络是否通畅");
                editloc.setText("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
//                sb.append("\ndescribe : ");
//                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                editloc.setText("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
//            sb.append("\nlocationdescribe : ");
//            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
//                sb.append("\npoilist size = : ");
//                sb.append(list.size());
                for (Poi p : list) {
//                    sb.append("\npoi= : ");
//                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());
            String shengshiqu = sb.toString().substring(2,5)+" "+sb.toString().substring(5,8)+" "+sb.toString().substring(8,11);
            editloc.setText(shengshiqu);
            String address_specific = sb.toString().substring(11);
            edit_address_specific.setText(address_specific);
            bundle.putString("editloc",shengshiqu);
            stringBuffer.append(shengshiqu);
            bundle.putString("address_specific",address_specific);
            if (shouhuoren != null){
                bundle.putString("shouhuoren",shouhuoren.getText().toString());
                Log.e("shouhuoren",shouhuoren.getText().toString());
            }else {
                ToastUtils.showToastSafe(AddAddressActivity.this,"收货人不能为空");
            }
            if (phone != null){
                bundle.putString("phone",phone.getText().toString());
                Log.e("phone",phone.getText().toString());
            }else {
                ToastUtils.showToastSafe(AddAddressActivity.this,"联系电话不能为空");
            }
        }
    }
    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
			/*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)){
                return true;
            }else{
                permissionsList.add(permission);
                return false;
            }
        }else{
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

}
