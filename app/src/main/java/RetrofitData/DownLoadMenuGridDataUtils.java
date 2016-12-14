package RetrofitData;

import android.content.Context;

import interfaces.Get;
import javabeans.GridData;
import javabeans.MenuData;
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

public class DownLoadMenuGridDataUtils {
    private Context context;
    private int id;
    public DownLoadMenuGridDataUtils(Context context,int id) {
        this.context = context;
        this.id = id;
    }


    //首页数据GET请求
    public Observable<GridData> downLoadData(String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GridData>() {

            @Override
            public void call(final Subscriber<? super GridData> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    Get service = retrofit.create(Get.class);
                    Call<GridData> call = service.getGridData(id);
                    call.enqueue(new Callback<GridData>() {
                        @Override
                        public void onResponse(Call<GridData> call, Response<GridData> response) {
                            if (response.isSuccessful()){
                                GridData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GridData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
