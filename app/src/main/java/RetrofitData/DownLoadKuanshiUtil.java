package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.KuanshiData;
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

public class DownLoadKuanshiUtil {
    private Context context;
    public DownLoadKuanshiUtil(Context context ) {
        this.context = context;
    }
    public Observable<KuanshiData> downLoadKuanshiUtil(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<KuanshiData>() {
            @Override
            public void call(final Subscriber<? super KuanshiData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<KuanshiData> call = service.getKuanshiData(id);
                    call.enqueue(new Callback<KuanshiData>() {
                        @Override
                        public void onResponse(Call<KuanshiData> call, Response<KuanshiData> response) {
                            if (response.isSuccessful()){
                                KuanshiData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<KuanshiData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
