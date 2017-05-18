package com.AceInAndroid.ZhihuDailyReport.model.http.api;

import com.AceInAndroid.ZhihuDailyReport.model.bean.VersionBean;
import com.AceInAndroid.ZhihuDailyReport.model.http.response.MyHttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by AceInAndroid on 16/10/10.
 * https://github.com/AceInAndroidX/my-restful-api
 */

public interface MyApis {

    String HOST = "http://AceInAndroid.me/api/ZhihuDailyReport/";

    String APK_DOWNLOAD_URL = "http://AceInAndroid.me/apk/ZhihuDailyReport.apk";

    /**
     * 获取最新版本信息
     * @return
     */
    @GET("version")
    Flowable<MyHttpResponse<VersionBean>> getVersionInfo();

}
