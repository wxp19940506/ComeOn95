package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.MenuData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public class DownLoadMenuDataUtils {
    private Context context;
    public DownLoadMenuDataUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<MenuData> downLoadData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<MenuData>() {
            @Override
            public void call(final Subscriber<? super MenuData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<MenuData> call = service.getMenurData();
                    call.enqueue(new Callback<MenuData>() {
                        @Override
                        public void onResponse(Call<MenuData> call, Response<MenuData> response) {
                            if (response.isSuccessful()){
                                MenuData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<MenuData> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
