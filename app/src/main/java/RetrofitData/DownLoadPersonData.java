package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.PersonData;
import javabeans.PublicBenefitData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import uiutils.ToastUtils;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public class DownLoadPersonData {
    private Context context;
    public DownLoadPersonData(Context context) {
        this.context = context;
    }
    public Observable<PersonData> downPersonData(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PersonData>() {
            @Override
            public void call(final Subscriber<? super PersonData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<PersonData> call = service.getPersonData(id);
                    call.enqueue(new Callback<PersonData>() {
                        @Override
                        public void onResponse(Call<PersonData> call, Response<PersonData> response) {
                            if (response.isSuccessful()){
                                PersonData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PersonData> call, Throwable t) {
                            ToastUtils.showToastSafe(context,"我的网络暂时无连接");
                        }
                    });
                }
            }
        });
    }
}
