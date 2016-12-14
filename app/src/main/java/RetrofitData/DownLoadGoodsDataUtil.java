package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GoodsData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class DownLoadGoodsDataUtil {
    private Context context;

    public DownLoadGoodsDataUtil(Context context) {
        this.context = context;
    }
    public Observable<GoodsData> downLoadGoodsData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodsData>() {
            @Override
            public void call(final Subscriber<? super GoodsData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<GoodsData> call = service.getGoods();
                    call.enqueue(new Callback<GoodsData>() {
                        @Override
                        public void onResponse(Call<GoodsData> call, Response<GoodsData> response) {
                            if (response.isSuccessful()){
                                GoodsData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodsData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
