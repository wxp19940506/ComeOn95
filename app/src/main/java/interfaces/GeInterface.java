package interfaces;

import javabeans.BaiQuanData;
import javabeans.GoodInfoImages;
import javabeans.GoodInfoPingLun;
import javabeans.GoodInfoUser;
import javabeans.GuiGeData;
import javabeans.HotChair;
import javabeans.HotChairBanner;
import javabeans.KuanshiData;
import javabeans.PersonShuoData;
import javabeans.PersonalBackgroundData;
import javabeans.PublicBenefitOneToOneImage;
import javabeans.YouXuanImagesData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/11/9 0009.
 */

public interface GeInterface {
    @GET("/laibai/betterPic/betterPic_findAllById.action")
    Call<YouXuanImagesData> getYouXuanImagesData(@Query("better.id") int id);
    @GET("/laibai/betterPic/betterPic_findInfoPicById.action")
    Call<GoodInfoImages> getGoodInfoImages(@Query("better.id") int id);
    @GET("/laibai/better/better_findInfoById.action")
    Call<GoodInfoUser> getGoodInfoUser(@Query("id") int id);
   @GET("/laibai/betterComment/betterComment_findAllById.action")
    Call<GoodInfoPingLun> getGoodInfoPingLun(@Query("better.id") int id);
    @GET("/laibai/talk/talk_findAll.action")
    Call<BaiQuanData> getBaiQuanData();
    @GET("/laibai/betterRule/betterRule_findAllById.action")
    Call<GuiGeData> getGuiGeData(@Query("better.id") int id);
    @GET("/laibai/betterType/betterType_findAllById.action")
    Call<KuanshiData> getKuanshiData(@Query("better.id") int id);
    @GET("/laibai/background/background_findAll.action")
    Call<PersonalBackgroundData> getBackground();
    @GET("/laibai/chairBanner/chairBanner_findAll.action")
    Call<HotChairBanner> getHotChairBanner();
    @GET("/laibai/chair/chair_findAll.action")
    Call<HotChair> getHotChair();
    @GET("/laibai/talk/talk_findAllByUserId.action")
    Call<PersonShuoData> getPersonalShuo(@Query("user.id") int id);
}
