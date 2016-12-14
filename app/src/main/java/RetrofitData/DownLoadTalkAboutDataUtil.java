package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GoodsData;
import javabeans.TalkAboutData;
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

public class DownLoadTalkAboutDataUtil {
    private Context context;

    public DownLoadTalkAboutDataUtil(Context context) {
        this.context = context;
    }
    public Observable<TalkAboutData> downLoadTalkAboutData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<TalkAboutData>() {
            @Override
            public void call(final Subscriber<? super TalkAboutData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<TalkAboutData> call = service.getTalkAboutData();
                    call.enqueue(new Callback<TalkAboutData>() {
                        @Override
                        public void onResponse(Call<TalkAboutData> call, Response<TalkAboutData> response) {
                            if (response.isSuccessful()){
                                TalkAboutData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<TalkAboutData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
