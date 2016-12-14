package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
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

public class DownLoadGoodInfoUser {
    private Context context;
    private int id;
    public DownLoadGoodInfoUser(Context context, int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<GoodInfoUser> downLoadGoodInfoUser(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodInfoUser>() {
            @Override
            public void call(final Subscriber<? super GoodInfoUser> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<GoodInfoUser> call = service.getGoodInfoUser(id);
                    call.enqueue(new Callback<GoodInfoUser>() {
                        @Override
                        public void onResponse(Call<GoodInfoUser> call, Response<GoodInfoUser> response) {
                            if (response.isSuccessful()){
                                GoodInfoUser data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodInfoUser> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
