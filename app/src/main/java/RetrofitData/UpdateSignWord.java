package RetrofitData;

import interfaces.Post;
import javabeans.SignStatue;
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

public class UpdateSignWord {
    public Observable<SignStatue> updateWord(String url, final int id, final String word){
        final Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return Observable.create(new Observable.OnSubscribe<SignStatue>() {
            @Override
            public void call(final Subscriber<? super SignStatue> subscriber) {
                if (!subscriber.isUnsubscribed()){
                    Post post = retrofit.create(Post.class);
                    Call<SignStatue> model = post.sign(id,word);
                    model.enqueue(new Callback<SignStatue>() {
                        @Override
                        public void onResponse(Call<SignStatue> call, Response<SignStatue> response) {
                            if (response.isSuccessful()){
                                SignStatue data = response.body();
                                if (data != null){
                                    subscriber.onNext(data);
                                }
                            }
                            subscriber.onCompleted();
                        }

                        @Override
                        public void onFailure(Call<SignStatue> call, Throwable t) {

                        }

                    });
                }
            }
        });
    }
}
