package com.AceInAndroid.ZhihuDailyReport.di.component;

import android.app.Activity;

import com.AceInAndroid.ZhihuDailyReport.di.scope.ActivityScope;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity.SectionActivity;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity.ZhihuDetailActivity;
import com.AceInAndroid.ZhihuDailyReport.di.module.ActivityModule;
import com.AceInAndroid.ZhihuDailyReport.ui.main.activity.MainActivity;
import com.AceInAndroid.ZhihuDailyReport.ui.main.activity.WelcomeActivity;
import com.AceInAndroid.ZhihuDailyReport.ui.vtex.activity.NodeListActivity;
import com.AceInAndroid.ZhihuDailyReport.ui.vtex.activity.RepliesActivity;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity.ThemeActivity;

import dagger.Component;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

    void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);

    void inject(RepliesActivity repliesActivity);

    void inject(NodeListActivity nodeListActivity);
}
