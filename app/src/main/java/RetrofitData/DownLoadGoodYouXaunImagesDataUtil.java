package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import interfaces.Get;
import javabeans.GoodBannerData;
import javabeans.YouXuanImagesData;
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

public class DownLoadGoodYouXaunImagesDataUtil {
    private Context context;
    public DownLoadGoodYouXaunImagesDataUtil(Context context) {
        this.context = context;
    }
    public Observable<YouXuanImagesData> downLoadYouXuanImagesData(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<YouXuanImagesData>() {
            @Override
            public void call(final Subscriber<? super YouXuanImagesData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<YouXuanImagesData> call = service.getYouXuanImagesData(id);
                    call.enqueue(new Callback<YouXuanImagesData>() {
                        @Override
                        public void onResponse(Call<YouXuanImagesData> call, Response<YouXuanImagesData> response) {
                            if (response.isSuccessful()){
                                YouXuanImagesData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<YouXuanImagesData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
