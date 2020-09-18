package com.example.arttower.Frame;

import com.example.arttower.bean.BaseTestBean;
import com.example.arttower.other.AliPayOrderInfoBean;
import com.example.arttower.bean.AlterBitmapBean;
import com.example.arttower.bean.AlterUserBean;
import com.example.arttower.bean.AlterphoneBean;
import com.example.arttower.bean.CarryOutAdvertisingBean;
import com.example.arttower.bean.ClassBean;
import com.example.arttower.bean.CollectBean;
import com.example.arttower.bean.CourseBanner;
import com.example.arttower.bean.CouserCommentBean;
import com.example.arttower.bean.CouserDetailsBean;
import com.example.arttower.bean.FenSiBean;
import com.example.arttower.bean.HistroyLabelBean;
import com.example.arttower.bean.HotSearchBena;
import com.example.arttower.bean.HuoDongBean;
import com.example.arttower.bean.InlandBanner;
import com.example.arttower.bean.ItKechengbean;
import com.example.arttower.bean.JianchapasswordBean;
import com.example.arttower.bean.LoginMobileCodeBean;
import com.example.arttower.bean.LoginPasswordBean;
import com.example.arttower.bean.MineBean;
import com.example.arttower.bean.MobileCodeBean;
import com.example.arttower.bean.MyAttentionBean;
import com.example.arttower.bean.MyMineBannerBean;
import com.example.arttower.bean.OthersNewsBean;
import com.example.arttower.bean.ParticularsBean;
import com.example.arttower.bean.PressFabulousBean;
import com.example.arttower.bean.QueryLabelBean;
import com.example.arttower.bean.RSApsdWordBean;
import com.example.arttower.bean.TaGuanzhuBean;
import com.example.arttower.bean.TeacherAnswerBean;
import com.example.arttower.bean.TeacherAppraiseBean;
import com.example.arttower.bean.TestDimSeekInfo;
import com.example.arttower.bean.ToUpWuBiBean;
import com.example.arttower.bean.UpLikeBean;
import com.example.arttower.bean.UserDimSeekBean;
import com.example.arttower.bean.VideoRetrievalBean;
import com.example.arttower.bean.ZhanghuInitBean;
import com.example.arttower.falsedata.CommentBean;
import com.example.arttower.fragment.CoursePage.CourseDataBean;
import com.example.arttower.fragment.HomePage.bean.HomeBean;
import com.example.arttower.fragment.LocalPage.bean.InlandTeacherBean;
import com.example.arttower.fragment.LocalPage.bean.TeacherCouserBean;
import com.example.arttower.fragment.LocalPage.bean.TeacherDataBean;
import com.example.arttower.fragment.TestPage.view.TestFragmentBean;
import com.example.arttower.other.HomeAddCommentBean;
import com.example.arttower.other.HomeCommentListBean;

import java.io.File;

import io.reactivex.Observable;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by l on 2019/6/27.
 */
public interface INetService {
    /*  // TODO 三方登录
    @POST("ypt/login/loginThirdParty")
    @FormUrlEncoded
    Observable<> getMobileCodeInfo(@Field("thirdPartyId") String thirdPartyId);*/

/*
    //  首页视频数据
    @POST("ypt/video/queryVideos")
    Observable<VideoInfo> getVideoInfo(@Query("userId") String userId, @Query("rows") int rows); */

    //  首页视频数据
    @POST("ypt/video/queryVideos")
    Observable<HomeBean> getVideoInfo(@Query("offset") int offset, @Query("rows") int rows);

    //  短信登录获取验证码
    @GET("ypt/login/getMobileCodeNew")
    Observable<MobileCodeBean> getCodeInfo(@Query("mobile") String mobile);

    //  手机验证码登录接口
    @POST("user/checkPasswordMobileCode")
    @FormUrlEncoded
    Observable<LoginMobileCodeBean> getMobileCodeInfo(@Field("mobile") String mobile, @Field("mobileCode") String mobileCode);

    //  手机登录或注册验证码登录接口
    @POST("ypt/login/loginMobileCodeNew")
    @FormUrlEncoded
    Observable<LoginMobileCodeBean> getMobileCodeNewInfo(@Field("mobile") String mobile, @Field("mobileCode") String mobileCode, @Field("lastLoginAddress") String lastLoginAddress, @Field("longitude") String longitude, @Field("latitude") String latitude, @Field("deviceNumber") String deviceNumber, @Field("deviceType") String deviceType, @Field("version") String version);

    //  用户名密码登录接口
    @POST("ypt/login/loginPassword")
    @FormUrlEncoded
    Observable<LoginPasswordBean> getLoginPassWordInfo(@Field("username") String username, @Field("password") String password);

    //  初次设置密码接口
    @POST("user/editPasswordByMobile")
    @FormUrlEncoded
    Observable<LoginPasswordBean> getSetPasswordInfo(@Field("mobile") String mobile, @Field("password") String password);

    //  当前登录的用户信息
    @GET("user/getMyInfo")
    Observable<MineBean> getMyInfo();

    //  当前登录的用户的账户资料信息
    @GET("user/getUserInfo")
    Observable<ZhanghuInitBean> getMyzhanghuInitInfo();

    //修改账户昵称
    @POST("user/editUserSetting")
    @FormUrlEncoded
    Observable<AlterUserBean> getAlterUserNameInfo(@Field("nickName") String nickName);

    //修改账户个性签名
    @POST("user/editUserSetting")
    @FormUrlEncoded
    Observable<AlterUserBean> getAlterUserPSAInfo(@Field("content") String content);

    //修改账户生日
    @POST("user/editUserSetting")
    @FormUrlEncoded
    Observable<AlterUserBean> getAlterUserBirthdayInfo(@Field("birthday") String birthday);


    //  课程Banner数据
    @GET("ypt/banner/queryCourseBanners")
    Observable<CourseBanner> getCourseBannerInfo();

    //  同城Banner数据
    @GET("ypt/banner/queryGradeBanners")
    Observable<InlandBanner> getInlandteacherBannerInfo();

    //  我的页面Banner数据
    @GET("ypt/banner/queryMyBanners")
    Observable<MyMineBannerBean> getMyBanner();

    //  课程页面推荐课程接口
    @GET("ypt/course/queryRecommentTag")
    Observable<CourseDataBean> getCourseInfo(@Query("offset") int offset, @Query("rows") int rows);

    //  同城国内教师接口
    @GET("ypt/authentication/queryLocationTeacher")
    Observable<InlandTeacherBean> getInlandTeacherInfo(@Query("offset") int offset, @Query("rows") int rows);

   /* //  课程页面课程库全部课程
    @GET("ypt/course/queryCourseList")
    Observable<ClassBean> getCourseInfo();*/

    //课程页面详情课程接口
    @GET("ypt/course/queryTagRecommentCourse")
    Observable<ParticularsBean> getParti(@Query("offset") int offset, @Query("rows") int rows);


    //  课程页面课程库全部课程
    @POST("ypt/course/queryCourseList")
    @FormUrlEncoded
    Observable<ClassBean> getCourse(@Field("offset") int offset, @Field("rows") int rows);

    //  活动课程数据
    @POST("ypt/course/queryActivityCourse")
    @FormUrlEncoded
    Observable<HuoDongBean> getHuoDong(@Field("offset") int offset, @Field("rows") int rows);


    /*  // 首页短视频评论列表
      @GET("ypt/video/queryCommentList")
      Observable<CommentBean> getCommentInfo(@Query("userId") String userId, @Query("videoId") String videoId, @Query("offset") int offset, @Query("rows") int rows);
  */
    // 首页短视频评论列表
    @GET("ypt/video/queryCommentList")
    Observable<CommentBean> getCommentInfo(@Query("offset") int offset, @Query("rows") int rows, @Query("userId") String userId, @Query("videoId") String videoId);


    // 他人主页用户消息
    @POST("user/getSomeoneInfo")
    @FormUrlEncoded
    Observable<OthersNewsBean> getOthersNewsInfo(@Field("someoneId") String someoneId);

    //TODO 首页点赞
    @POST("ypt/video/updateThumbsUp")
    @FormUrlEncoded
    Observable<PressFabulousBean> getPressFabulousInfo(@Field("userId") String userId, @Field("videoId") String videoId, @Field("uid") String uid);


    // TODO 修改头像图片
    @POST("user/editUserHeadImg")
    @FormUrlEncoded
    Observable<AlterBitmapBean> getAlterBitmap(@Field("multipartFile") File multipartFile);


    //查询全部标签
    @POST("ypt/tag/queryAllTag")
    Observable<QueryLabelBean> getQueryLabelInfo();

    //历史使用标签
    @POST("ypt/tag/queryMyUseTags")
    @FormUrlEncoded
    Observable<HistroyLabelBean> getHistoryLabelInfo(@Field("offset") int offset, @Query("rows") int rows);


    //收藏查询
    @POST("ypt/collect/queryUserCollect")
    @FormUrlEncoded
    Observable<CollectBean> getCollectInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("userId") String userId);

    /* //他人收藏
      @POST("ypt/collect/queryUserCollect")
      @FormUrlEncoded
      Observable<CollectBean> getItCollectInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("userId") String userId);*/
    //他人收藏
    @POST("ypt/collect/queryUserCollect")
    @FormUrlEncoded
    Observable<CollectBean> getItCollectInfo(@Field("offset") int offset, @Field("rows") int rows);

    //他人关注
    @POST("ypt/focus/querySomeoneFocus")
    @FormUrlEncoded
    Observable<TaGuanzhuBean> getTaGuanzhuInfo(@Field("offset") int offset, @Field("rows") int rows,@Field("someoneId")String someoneId);

    //我的关注
    @POST("ypt/focus/queryMyFocus")
    @FormUrlEncoded
    Observable<MyAttentionBean> getMyAttentiodInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("userId") String userId);


    //粉丝
    @POST("ypt/focus/queryFans")
    @FormUrlEncoded
    Observable<FenSiBean> getTafensiInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("userId") String userId);


    //他人课程
    @POST("ypt/course/queryHisCourseStuding")
    @FormUrlEncoded
    Observable<ItKechengbean> getTAKechengInfo(@Field("offset") int offset, @Field("rows") int rows);

    //设置 --安全隐私 -- 修改手机号 -- 获取验证码
    @GET("user/getEditMobileCode")
    Observable<AlterUserBean> getAlterPhoneCode(@Query("mobile") String mobile);

    //设置 --安全隐私 -- 修改手机号
    @POST("user/editMobile")
    @FormUrlEncoded
    Observable<AlterphoneBean> getAlterPhoneInfo(@Field("mobile") String mobile, @Field("mobileCode") String mobileCode, @Field("token") String token);


    //密码登陆 --> 找回密码 --> 验证码检查
    @POST("user/checkPasswordMobileCode")
    @FormUrlEncoded
    Observable<AlterUserBean> getAlterForPsdCodeEqust(@Field("mobile") String mobile, @Field("mobileCode") String mobileCode);

    //考级院校信息
    @GET("ypt/grade/queryGradeInfo")
    Observable<TestFragmentBean> getTheTestInfo();

    //教师课程
    @POST("ypt/course/queryTeacherCourse")
    @FormUrlEncoded
    Observable<TeacherCouserBean> getTeacherCouserInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("uid") String uid);

    //教师个人介绍
    @POST("user/queryTeacherInfo")
    @FormUrlEncoded
    Observable<TeacherDataBean> getTeacherdataInfo(@Field("uid") String uid);

    //查询教师答疑列表
    @POST("ypt/course/queryAllAnswerQuestions")
    @FormUrlEncoded
    Observable<TeacherAnswerBean> getTeacherAnswerInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("uid") String uid);

    //查询教师评价列表
    @POST("user/queryTeacherEvaInfo")
    @FormUrlEncoded
    Observable<TeacherAppraiseBean> getTeacherAppraiseInfo(@Field("offset") int offset, @Field("rows") int rows, @Field("uid") String uid);

    //设置 --> 安全隐私 --> 修改密码
    @POST("user/editPassword")
    @FormUrlEncoded
    Observable<AlterUserBean> getAlterPasswordInfo(@Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

    //教师新增答疑
    @POST("ypt/course/insertCourseAnonymous")
    @FormUrlEncoded
    Observable<AlterUserBean> insertCourseAnonymous(@Field("uid") String uid, @Field("content") String content, @Field("isAnonymity") int isAnonymity);

    //我的页面————消息通知————回复我的
    @GET("user/getUserMessageNotify")
    Observable<AlterUserBean> getNewsReplyMyInfo(@Query("offset") int offset, @Query("rows") int rows);

    //我的页面————消息通知————点赞我的
    @GET("user/queryPraiseMe")
    Observable<AlterUserBean> GiveThetHumbSupInfo(@Query("offset") int offset, @Query("rows") int rows);

    //关注和取消关注
    @POST("ypt/focus/addFocus")
    @FormUrlEncoded
    //userid  自己的id   someoneid点击的用户的id
    Observable<AlterUserBean> AttentionInfo(@Field("userId") String userId, @Field("someoneId") String someoneId);


    //获取我的订单信息集合
    @GET("ypt/order/queryOrderList")
    Observable<AlterUserBean> getMyFormInfo(@Query("offset") int offset, @Query("rows") int rows);

    //获取我的课程的历史浏览记录
    @POST("ypt/course/queryMyCourseBrowse")
    @FormUrlEncoded
    Observable<AlterUserBean> getHistoryRecord(@Field("offset") int offset, @Field("rows") int rows);

    //获取课程详情信息
    @GET("ypt/course/queryCourseDetailsAndVideo")
    Observable<CouserDetailsBean> getouserDetails(@Query("courseId") String courseId);

    //课程点赞
    @POST("ypt/praiseCourse/praiseCourse")
    @FormUrlEncoded
    Observable<UpLikeBean> getUpLikeInfo(@Field("courseId") String courseId);

    //取消课程点赞
    @HTTP(method = "DELETE", path = "ypt/praiseCourse/cancelPraiseCourse", hasBody = true)
    Observable<UpLikeBean> getDownLikeInfo(@Query("courseId") String courseId);


    //课程收藏
    @POST("ypt/collect/collectCourse")
    @FormUrlEncoded
    Observable<UpLikeBean> getUpCollectInfo(@Field("courseVideoId") String courseVideoId);


    //取消课程收藏
    @HTTP(method = "DELETE", path = "ypt/collect/cancelCollectCourse", hasBody = true)
    @FormUrlEncoded
    Observable<UpLikeBean> getDownCollectInfo(@Field("courseVideoId") String courseVideoId);


    //试听课程中的评价查询
    @GET("ypt/course/queryComment")
    Observable<CouserCommentBean> getCouserCommitInfo(@Query("courseId") String couserId, @Query("offset") int offset);

    //课程视频   发布评论
    @POST("ypt/course/addCourseComment")
    @FormUrlEncoded
    Observable<AlterUserBean>getcouserUpcommentInfo(@Field("couserId") String couserId, @Field("content") String content);

    //课程视频   回复评论
    @POST("ypt/course/addCourseComment")
    @FormUrlEncoded
    Observable<AlterUserBean>getAddCouserCommentInfo(@Field("couserId") String couserId,@Field("content")String content);

    //视频搜索
    @GET("ypt/esVideo/getEsVideoBool")
    Observable<VideoRetrievalBean> getVideoReteievalInfo(@Query("keyword") String keyword);

    //用户搜索
    @GET("ypt/esUser/getEsUsesBool")
    Observable<UserDimSeekBean> getUserDimSeekInfo(@Query("keyword") String keyword);

    //课程搜索
    @GET("ypt/esUser/getEsUsesBool")
    Observable<TestDimSeekInfo> getTestDimSeekInfo(@Query("keyword") String keyword);

    //热门搜索
    @POST("ypt/label/hotSearch")
    Observable<HotSearchBena> getHotSearch();

    //获取支付宝支付订单
    @POST("ypt/alipay/accountAliPay")
    @FormUrlEncoded
    Observable<AliPayOrderInfoBean> accountAliPay(@Field("moneyId") String moneyId);

    //获取支付的公钥
    @GET("ypt/account/getPayPasswordPK")
    Observable<RSApsdWordBean>getRSApasswordInfo();

    //检查支付密码
    @POST("ypt/account/checkPayPassword")
    @FormUrlEncoded
    Observable<JianchapasswordBean>ExaminepassowrdInfo(@Field("payPassword")String payPassword);

   /* //课程购买订单创建
    @POST("ypt/order/purchaseCourseOrder")
    @FormUrlEncoded
    Observable<>testindentsetupInfo(@Field("courseId")String courseId,@Field("token")String token);*/

    //开屏广告页
    @GET("ypt/banner/queryADBanners")
    Observable<CarryOutAdvertisingBean>getCarryoutAdvertisingInfo();

    //获取充值金额舞币对照信息
    @GET("ypt/account/queryDanceMoney")
    Observable<ToUpWuBiBean> gettoupWubInfo(@Query("deviceType") String deviceType);

    //首页评论列表
    @GET("ypt/video/queryCommentList")
    Observable<HomeCommentListBean> queryCommentList(@Query("offset") int offset, @Query("rows") int rows, @Query("userId") String userId,
                                                     @Query("videoId") String videoId, @Query("uid") String uid,
                                                     @Query("content") String content);

    //首页视频新增评论
    @POST("ypt/video/addComment")
    @FormUrlEncoded
    Observable<HomeAddCommentBean> addHomeComment(@Field("offset") int offset, @Field("rows") int rows, @Field("userId") String userId,
                                                  @Field("videoId") String videoId, @Field("uid") String uid,
                                                  @Field("content") String content);
}
