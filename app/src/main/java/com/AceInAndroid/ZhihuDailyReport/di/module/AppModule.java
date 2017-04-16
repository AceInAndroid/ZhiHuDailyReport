package com.AceInAndroid.ZhihuDailyReport.di.module;

import com.AceInAndroid.ZhihuDailyReport.app.App;
import com.AceInAndroid.ZhihuDailyReport.model.db.RealmHelper;
import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.GoldApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.MyApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.VtexApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.ZhihuApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.GankApis;
import com.AceInAndroid.ZhihuDailyReport.model.http.api.WeChatApis;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper(ZhihuApis zhihuApiService, GankApis gankApiService, WeChatApis wechatApiService,
                                         MyApis myApiService, GoldApis goldApiService, VtexApis vtexApiService) {
        return new RetrofitHelper(zhihuApiService, gankApiService, wechatApiService,
                myApiService, goldApiService, vtexApiService);
    }

    @Provides
    @Singleton
    RealmHelper provideRealmHelper() {
        return new RealmHelper();
    }
}
