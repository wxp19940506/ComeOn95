package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.BaiQuanData;
import javabeans.HotChair;
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

public class DownLoadHotChairDataUtil {
    private Context context;
    public DownLoadHotChairDataUtil(Context context) {
        this.context = context;
    }
    public Observable<HotChair> downHotChairData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<HotChair>() {
            @Override
            public void call(final Subscriber<? super HotChair> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<HotChair> call = service.getHotChair();
                    call.enqueue(new Callback<HotChair>() {
                        @Override
                        public void onResponse(Call<HotChair> call, Response<HotChair> response) {
                            if (response.isSuccessful()){
                                HotChair data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<HotChair> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
