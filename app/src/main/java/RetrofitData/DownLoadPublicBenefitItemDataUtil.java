package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GoodBannerData;
import javabeans.PublicBenefitItemdata;
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

public class DownLoadPublicBenefitItemDataUtil {
    private Context context;
    private int id;
    public DownLoadPublicBenefitItemDataUtil(Context context, int id) {
        this.context = context;
        this.id = id;
    }
    public Observable<PublicBenefitItemdata> downLoadPublicBenefitItemdata(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PublicBenefitItemdata>() {
            @Override
            public void call(final Subscriber<? super PublicBenefitItemdata> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Get service = retrofit.create(Get.class);
                    Call<PublicBenefitItemdata> call = service.getPublicBenefitItemdata(id);
                    call.enqueue(new Callback<PublicBenefitItemdata>() {
                        @Override
                        public void onResponse(Call<PublicBenefitItemdata> call, Response<PublicBenefitItemdata> response) {
                            if (response.isSuccessful()){
                                PublicBenefitItemdata data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PublicBenefitItemdata> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
