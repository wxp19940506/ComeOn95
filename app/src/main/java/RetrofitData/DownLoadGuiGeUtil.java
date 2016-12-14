package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.GoodInfoImages;
import javabeans.GuiGeData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/10 0010.
 */

public class DownLoadGuiGeUtil {
    private Context context;
    public DownLoadGuiGeUtil(Context context ) {
        this.context = context;
    }
    public Observable<GuiGeData> downLoadGuiGeUtil(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<GuiGeData>() {
            @Override
            public void call(final Subscriber<? super GuiGeData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<GuiGeData> call = service.getGuiGeData(id);
                    call.enqueue(new Callback<GuiGeData>() {
                        @Override
                        public void onResponse(Call<GuiGeData> call, Response<GuiGeData> response) {
                            if (response.isSuccessful()){
                                GuiGeData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<GuiGeData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
