package com.AceInAndroid.ZhihuDailyReport.di.component;

import android.app.Activity;

import com.AceInAndroid.ZhihuDailyReport.di.module.FragmentModule;
import com.AceInAndroid.ZhihuDailyReport.ui.gold.fragment.GoldMainFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.main.fragment.SettingFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.vtex.fragment.VtexPagerFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.CommentFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.SectionFragment;
import com.AceInAndroid.ZhihuDailyReport.di.scope.FragmentScope;
import com.AceInAndroid.ZhihuDailyReport.ui.gank.fragment.GirlFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.gank.fragment.TechFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.gold.fragment.GoldPagerFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.main.fragment.LikeFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.wechat.fragment.WechatMainFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.DailyFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.HotFragment;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.ThemeFragment;

import dagger.Component;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(DailyFragment dailyFragment);

    void inject(ThemeFragment themeFragment);

    void inject(SectionFragment sectionFragment);

    void inject(HotFragment hotFragment);

    void inject(CommentFragment longCommentFragment);

    void inject(TechFragment techFragment);

    void inject(GirlFragment girlFragment);

    void inject(LikeFragment likeFragment);

    void inject(WechatMainFragment wechatMainFragment);

    void inject(SettingFragment settingFragment);

    void inject(GoldMainFragment goldMainFragment);

    void inject(GoldPagerFragment goldPagerFragment);

    void inject(VtexPagerFragment vtexPagerFragment);
}
