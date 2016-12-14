package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.BannerData;
import javabeans.PublicBenefitOneToOneImage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public class DownLoadOneToOneImageUtils {
    private Context context;
    public DownLoadOneToOneImageUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<PublicBenefitOneToOneImage> downLoadImageData(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PublicBenefitOneToOneImage>() {
            @Override
            public void call(final Subscriber<? super PublicBenefitOneToOneImage> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<PublicBenefitOneToOneImage> call = service.getImageData(id);
                    call.enqueue(new Callback<PublicBenefitOneToOneImage>() {
                        @Override
                        public void onResponse(Call<PublicBenefitOneToOneImage> call, Response<PublicBenefitOneToOneImage> response) {
                            if (response.isSuccessful()){
                                PublicBenefitOneToOneImage data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PublicBenefitOneToOneImage> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
