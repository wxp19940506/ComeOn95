package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.HotChair;
import javabeans.HotChairBanner;
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

public class DownLoadHotChairBannerDataUtil {
    private Context context;
    public DownLoadHotChairBannerDataUtil(Context context) {
        this.context = context;
    }
    public Observable<HotChairBanner> downHotChairBannerData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<HotChairBanner>() {
            @Override
            public void call(final Subscriber<? super HotChairBanner> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<HotChairBanner> call = service.getHotChairBanner();
                    call.enqueue(new Callback<HotChairBanner>() {
                        @Override
                        public void onResponse(Call<HotChairBanner> call, Response<HotChairBanner> response) {
                            if (response.isSuccessful()){
                                HotChairBanner data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<HotChairBanner> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
