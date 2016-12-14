package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.OneToOneData;
import javabeans.PublicBenefitData;
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

public class DownLoadOneToOneUtils {
    private Context context;
    public DownLoadOneToOneUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<OneToOneData> downOneToOneData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<OneToOneData>() {
            @Override
            public void call(final Subscriber<? super OneToOneData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<OneToOneData> call = service.getOneToOneData();
                    call.enqueue(new Callback<OneToOneData>() {
                        @Override
                        public void onResponse(Call<OneToOneData> call, Response<OneToOneData> response) {
                            if (response.isSuccessful()){
                                OneToOneData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<OneToOneData> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
