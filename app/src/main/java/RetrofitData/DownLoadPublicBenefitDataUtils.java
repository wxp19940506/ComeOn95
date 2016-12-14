package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.MenuData;
import javabeans.PublicBenefitData;
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

public class DownLoadPublicBenefitDataUtils {
    private Context context;
    public DownLoadPublicBenefitDataUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<PublicBenefitData> downPublicBenefitData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PublicBenefitData>() {
            @Override
            public void call(final Subscriber<? super PublicBenefitData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<PublicBenefitData> call = service.getPublicBenefitData();
                    call.enqueue(new Callback<PublicBenefitData>() {
                        @Override
                        public void onResponse(Call<PublicBenefitData> call, Response<PublicBenefitData> response) {
                            if (response.isSuccessful()){
                                PublicBenefitData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PublicBenefitData> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
