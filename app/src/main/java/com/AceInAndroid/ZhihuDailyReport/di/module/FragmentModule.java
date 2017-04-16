package com.AceInAndroid.ZhihuDailyReport.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.AceInAndroid.ZhihuDailyReport.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AceInAndroid on 17/4/7.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
