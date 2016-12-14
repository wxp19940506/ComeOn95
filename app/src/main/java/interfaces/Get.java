package interfaces;

import javabeans.BannerData;
import javabeans.GoodBannerData;
import javabeans.GoodImagesData;
import javabeans.GoodTitleData;
import javabeans.GoodsData;
import javabeans.GridData;
import javabeans.HomePagerData;
import javabeans.MenuData;
import javabeans.OneToOneData;
import javabeans.PersonData;
import javabeans.PublicBenefitData;
import javabeans.PublicBenefitItemdata;
import javabeans.PublicBenefitOneToOneData;
import javabeans.PublicBenefitOneToOneImage;
import javabeans.PublicBenefitOneToOneItemData;
import javabeans.TalkAboutData;
import javabeans.YouXunData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/13 0013.
 */

public interface Get {
    @GET("/laibai/mainBanner/mainBanner_findAll.action")
    Call<BannerData> getBannerData();
    @GET("/laibai/allMenu/allMenu_findAll.action")
    Call<MenuData> getMenurData();
    @GET("/laibai/allMenu/allMenu_findById.action")
    Call<GridData> getGridData(@Query("parentId")int id);
    @GET("/laibai/better/better_findAll.action")
    Call<YouXunData> geYouXuanData();
    @GET("/laibai/chair/chair_findHotChair.action")
    Call<GoodsData> getGoods();
    @GET("/laibai/chairPic/chairPic_findBannerById.action")//chairPic_findBannerById.action
    Call<GoodBannerData> getGoodBanner(@Query("chair.id") int id);
    @GET("/laibai/chairColor/chairColor_findAllById.action")//chairPic_findBannerById.action
    Call<GoodTitleData> getGoodTitleData(@Query("chair.id") int id);
    @GET("/laibai/chairPic/chairPic_findAllById.action")
    Call<GoodImagesData> getGoodImagesData(@Query("chair.id") int id);
    @GET("/laibai/loveProject/loveProject_findAll.action")
    Call<PublicBenefitData> getPublicBenefitData();
    @GET("/laibai/love/love_findAll.action")
    Call<OneToOneData> getOneToOneData();
    @GET("/laibai/loveProjectPic/loveProjectPic_findAllById.action")
    Call<PublicBenefitItemdata> getPublicBenefitItemdata(@Query("loveProject.id")int id);
    @GET("/laibai/talk/talk_findAll.action")
    Call<TalkAboutData> getTalkAboutData();
    @GET("/laibai/love/love_findById.action")
    Call<PublicBenefitOneToOneItemData> getPublicBenefitOneToOnedata(@Query("id")int id);
    @GET("/laibai/user/user_findById.action")
    Call<PersonData> getPersonData(@Query("id")int id);
    @GET("/laibai/lovePic/lovePic_findAllById.action")
    Call<PublicBenefitOneToOneImage> getImageData(@Query("love.id") int id);
}
