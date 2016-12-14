package RetrofitData;

import android.content.Context;
import android.util.Log;

import interfaces.Get;
import javabeans.BannerData;
import javabeans.HomePagerData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import uiutils.ToastUtils;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public class DownLoadUtils {
    private Context context;
    public DownLoadUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<BannerData> downLoadData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<BannerData>() {
            @Override
            public void call(final Subscriber<? super BannerData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<BannerData> call = service.getBannerData();
                    call.enqueue(new Callback<BannerData>() {
                        @Override
                        public void onResponse(Call<BannerData> call, Response<BannerData> response) {
                            if (response.isSuccessful()){
                                BannerData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<BannerData> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
