package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.YouXunData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class DownLoadYouXuanUtil {
    private Context context;

    public DownLoadYouXuanUtil(Context context) {
        this.context = context;
    }
    public Observable<YouXunData> downLoadData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<YouXunData>() {
            @Override
            public void call(final Subscriber<? super YouXunData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<YouXunData> call = service.geYouXuanData();
                    call.enqueue(new Callback<YouXunData>() {
                        @Override
                        public void onResponse(Call<YouXunData> call, Response<YouXunData> response) {
                            if(response.isSuccessful()){
                                YouXunData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<YouXunData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
