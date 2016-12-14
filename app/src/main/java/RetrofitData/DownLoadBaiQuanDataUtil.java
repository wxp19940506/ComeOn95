package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.BaiQuanData;
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

public class DownLoadBaiQuanDataUtil {
    private Context context;
    public DownLoadBaiQuanDataUtil(Context context) {
        this.context = context;
    }
    public Observable<BaiQuanData> downBaiQuanData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<BaiQuanData>() {
            @Override
            public void call(final Subscriber<? super BaiQuanData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<BaiQuanData> call = service.getBaiQuanData();
                    call.enqueue(new Callback<BaiQuanData>() {
                        @Override
                        public void onResponse(Call<BaiQuanData> call, Response<BaiQuanData> response) {
                            if (response.isSuccessful()){
                                BaiQuanData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<BaiQuanData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
