package com.AceInAndroid.ZhihuDailyReport.ui.gold.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.AceInAndroid.ZhihuDailyReport.ui.gold.fragment.GoldPagerFragment;

import java.util.List;

/**
 * Created by AceInAndroid on 16/11/28.
 */

public class GoldPagerAdapter extends FragmentStatePagerAdapter {

    private List<GoldPagerFragment> fragments;

    public GoldPagerAdapter(FragmentManager fm, List<GoldPagerFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
