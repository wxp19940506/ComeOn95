package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.GoodInfoPingLun;
import javabeans.GoodInfoUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class DownLoadGoodInfoPingLun {
    private Context context;
    private int id;
    public DownLoadGoodInfoPingLun(Context context, int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<GoodInfoPingLun> downLoadGoodPingLun(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodInfoPingLun>() {
            @Override
            public void call(final Subscriber<? super GoodInfoPingLun> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<GoodInfoPingLun> call = service.getGoodInfoPingLun(id);
                    call.enqueue(new Callback<GoodInfoPingLun>() {
                        @Override
                        public void onResponse(Call<GoodInfoPingLun> call, Response<GoodInfoPingLun> response) {
                            if (response.isSuccessful()){
                                GoodInfoPingLun data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodInfoPingLun> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
