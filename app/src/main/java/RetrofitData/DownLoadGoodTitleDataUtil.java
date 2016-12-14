package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GoodBannerData;
import javabeans.GoodTitleData;
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

public class DownLoadGoodTitleDataUtil {
    private Context context;
    private int id;
    public DownLoadGoodTitleDataUtil(Context context, int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<GoodTitleData> downLoadGoodTitleData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodTitleData>() {
            @Override
            public void call(final Subscriber<? super GoodTitleData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<GoodTitleData> call = service.getGoodTitleData(id);
                    call.enqueue(new Callback<GoodTitleData>() {
                        @Override
                        public void onResponse(Call<GoodTitleData> call, Response<GoodTitleData> response) {
                            if (response.isSuccessful()){
                                GoodTitleData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodTitleData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
