package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GoodImagesData;
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

public class DownLoadGoodImagesDataUtil {
    private Context context;
    private int id;
    public DownLoadGoodImagesDataUtil(Context context, int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<GoodImagesData> downLoadGoodImagesData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GoodImagesData>() {
            @Override
            public void call(final Subscriber<? super GoodImagesData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<GoodImagesData> call = service.getGoodImagesData(id);
                    call.enqueue(new Callback<GoodImagesData>() {
                        @Override
                        public void onResponse(Call<GoodImagesData> call, Response<GoodImagesData> response) {
                            if (response.isSuccessful()){
                                GoodImagesData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GoodImagesData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
