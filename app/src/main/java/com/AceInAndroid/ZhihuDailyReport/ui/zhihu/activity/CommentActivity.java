package com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.adapter.CommentMainAdapter;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.fragment.CommentFragment;
import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.base.SimpleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by AceInAndroid on 17/4/18.
 */

public class CommentActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.tab_comment)
    TabLayout mTabLayout;
    @BindView(R.id.vp_comment)
    ViewPager mViewPager;

    CommentMainAdapter mAdapter;
    List<CommentFragment> fragments = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_comment;
    }

    @Override
    protected void initEventAndData() {
        Intent intent = getIntent();
        int allNum = intent.getExtras().getInt("allNum");
        int shortNum = intent.getExtras().getInt("shortNum");
        int longNum = intent.getExtras().getInt("longNum");
        int id = intent.getExtras().getInt("id");
        intent.getExtras().getInt("shortNum");
        setToolBar(toolBar,String.format("%d条评论",allNum));

        CommentFragment shortCommentFragment = new CommentFragment();
        Bundle shortBundle = new Bundle();
        shortBundle.putInt("id", id);
        shortBundle.putInt("kind", 0);
        shortCommentFragment.setArguments(shortBundle);
        CommentFragment longCommentFragment = new CommentFragment();
        Bundle longBundle = new Bundle();
        longBundle.putInt("id", id);
        longBundle.putInt("kind", 1);
        longCommentFragment.setArguments(longBundle);
        fragments.add(shortCommentFragment);
        fragments.add(longCommentFragment);
        mAdapter = new CommentMainAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.addTab(mTabLayout.newTab().setText(String.format("短评论(%d)",shortNum)));
        mTabLayout.addTab(mTabLayout.newTab().setText(String.format("长评论(%d)",longNum)));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(String.format("短评论(%d)",shortNum));
        mTabLayout.getTabAt(1).setText(String.format("长评论(%d)",longNum));
    }
}
