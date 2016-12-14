package RetrofitData;

import android.util.Log;

import java.util.Objects;

import interfaces.Post;
import javabeans.StatueData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public class LoginPassWord {
    public Observable<StatueData> downLoadUrlPost(String url, final String phone, final String password){
        final Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<StatueData>() {
            @Override
            public void call(final Subscriber<? super StatueData> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Post post = retrofit.create(Post.class);
                    Call<StatueData> model = post.form(phone,password);
                    model.enqueue(new Callback<StatueData>() {
                        @Override
                        public void onResponse(Call<StatueData> call, Response<StatueData> response) {
                            if (response.isSuccessful()){
                                StatueData data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<StatueData> call, Throwable t) {

                        }

                    });
                }
            }
        });
    }
}
