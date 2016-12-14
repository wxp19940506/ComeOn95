package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.PublicBenefitData;
import javabeans.PublicBenefitOneToOneItemData;
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

public class DownLoadPublicBenefitOneToOneItemDataUtils {
    private Context context;
    public DownLoadPublicBenefitOneToOneItemDataUtils(Context context) {
        this.context = context;
    }


    //首页数据GET请求
    public Observable<PublicBenefitOneToOneItemData> downPublicBenefitOneToOneItemData(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PublicBenefitOneToOneItemData>() {
            @Override
            public void call(final Subscriber<? super PublicBenefitOneToOneItemData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<PublicBenefitOneToOneItemData> call = service.getPublicBenefitOneToOnedata(id);
                    call.enqueue(new Callback<PublicBenefitOneToOneItemData>() {
                        @Override
                        public void onResponse(Call<PublicBenefitOneToOneItemData> call, Response<PublicBenefitOneToOneItemData> response) {
                            if (response.isSuccessful()){
                                PublicBenefitOneToOneItemData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PublicBenefitOneToOneItemData> call, Throwable t) {
                            //ToastUtils.showToastSafe(context,"网络暂时无连接");
                        }
                    });
                }
            }
        });
    }

}
