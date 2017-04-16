package com.AceInAndroid.ZhihuDailyReport.ui.zhihu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.CommentFragment;

import java.util.List;

/**
 * Created by AceInAndroid on 17/4/19.
 */

public class CommentMainAdapter extends FragmentPagerAdapter{

    private List<CommentFragment> fragments;

    public CommentMainAdapter(FragmentManager fm,List<CommentFragment> fragments) {
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
