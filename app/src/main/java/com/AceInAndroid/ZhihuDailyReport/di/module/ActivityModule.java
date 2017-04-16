package com.AceInAndroid.ZhihuDailyReport.di.module;

import android.app.Activity;

import com.AceInAndroid.ZhihuDailyReport.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
