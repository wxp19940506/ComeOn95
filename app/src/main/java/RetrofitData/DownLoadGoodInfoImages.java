package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import interfaces.Get;
import javabeans.GoodImagesData;
import javabeans.GoodInfoImages;
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

public class DownLoadGoodInfoImages {
    private Context context;
    public DownLoadGoodInfoImages(Context context ) {
        this.context = context;
    }
    public Observable<GoodInfoImages> downLoadGoodInfoImages(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodInfoImages>() {
            @Override
            public void call(final Subscriber<? super GoodInfoImages> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<GoodInfoImages> call = service.getGoodInfoImages(id);
                    call.enqueue(new Callback<GoodInfoImages>() {
                        @Override
                        public void onResponse(Call<GoodInfoImages> call, Response<GoodInfoImages> response) {
                            if (response.isSuccessful()){
                                GoodInfoImages data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodInfoImages> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
