package com.AceInAndroid.ZhihuDailyReport.di.component;

import com.AceInAndroid.ZhihuDailyReport.app.App;
import com.AceInAndroid.ZhihuDailyReport.di.module.AppModule;
import com.AceInAndroid.ZhihuDailyReport.di.module.HttpModule;
import com.AceInAndroid.ZhihuDailyReport.model.db.RealmHelper;
import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类
}
