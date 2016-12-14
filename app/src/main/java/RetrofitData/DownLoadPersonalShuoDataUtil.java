package RetrofitData;

import android.content.Context;

import interfaces.GeInterface;
import javabeans.GuiGeData;
import javabeans.PersonShuoData;
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

public class DownLoadPersonalShuoDataUtil {
    private Context context;
    public DownLoadPersonalShuoDataUtil(Context context ) {
        this.context = context;
    }
    public Observable<PersonShuoData> downLoadPersonalShuoDataUtil(String url, final int id){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<PersonShuoData>() {
            @Override
            public void call(final Subscriber<? super PersonShuoData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    GeInterface service = retrofit.create(GeInterface.class);
                    Call<PersonShuoData> call = service.getPersonalShuo(id);
                    call.enqueue(new Callback<PersonShuoData>() {
                        @Override
                        public void onResponse(Call<PersonShuoData> call, Response<PersonShuoData> response) {
                            if (response.isSuccessful()){
                                PersonShuoData data = response.body();
                                if (data != null) {
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<PersonShuoData> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
}
