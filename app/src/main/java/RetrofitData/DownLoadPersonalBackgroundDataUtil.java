package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.BaiQuanData;
import javabeans.PersonalBackgroundData;
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

public class DownLoadPersonalBackgroundDataUtil {
    private Context context;
    public DownLoadPersonalBackgroundDataUtil(Context context) {
        this.context = context;
    }
    public Observable<PersonalBackgroundData> downBaiQuanData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PersonalBackgroundData>() {
            @Override
            public void call(final Subscriber<? super PersonalBackgroundData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<PersonalBackgroundData> call = service.getBackground();
                    call.enqueue(new Callback<PersonalBackgroundData>() {
                        @Override
                        public void onResponse(Call<PersonalBackgroundData> call, Response<PersonalBackgroundData> response) {
                            if (response.isSuccessful()){
                                PersonalBackgroundData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PersonalBackgroundData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
