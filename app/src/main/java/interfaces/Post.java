package interfaces;

import java.util.Objects;

import javabeans.SignStatue;
import javabeans.StatueData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/11/8 0008.
 */

public interface Post {
    @FormUrlEncoded
    @POST("/laibai/user/user_login.action")
    Call<StatueData> form(@Field("phone") String username, @Field("password") String password);
    @FormUrlEncoded
    @POST("/laibai/user/user_updateWord.action")
    Call<SignStatue> sign (@Field("id") int id, @Field("word") String word);
    @FormUrlEncoded
    @POST("/laibai/user/user_updateNickName.action")
    Call<SignStatue> updatename (@Field("id") int id, @Field("nickName") String word);
    @FormUrlEncoded
    @POST("/laibai/user/user_updatePassword.action")
    Call<SignStatue> updatepassword (@Field("id") int id, @Field("password") String word);
}
