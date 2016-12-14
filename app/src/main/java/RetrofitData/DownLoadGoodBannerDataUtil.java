package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.BannerData;
import javabeans.GoodBannerData;
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

public class DownLoadGoodBannerDataUtil {
    private Context context;
    private int id;
    public DownLoadGoodBannerDataUtil(Context context,int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<GoodBannerData> downLoadGoodBannerData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodBannerData>() {
            @Override
            public void call(final Subscriber<? super GoodBannerData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<GoodBannerData> call = service.getGoodBanner(id);
                    call.enqueue(new Callback<GoodBannerData>() {
                        @Override
                        public void onResponse(Call<GoodBannerData> call, Response<GoodBannerData> response) {
                            if (response.isSuccessful()){
                                GoodBannerData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodBannerData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
