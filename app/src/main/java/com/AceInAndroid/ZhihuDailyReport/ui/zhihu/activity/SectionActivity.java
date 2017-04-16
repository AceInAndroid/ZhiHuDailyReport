package com.AceInAndroid.ZhihuDailyReport.ui.zhihu.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.base.BaseActivity;
import com.AceInAndroid.ZhihuDailyReport.model.bean.SectionChildListBean;
import com.AceInAndroid.ZhihuDailyReport.presenter.SectionChildPresenter;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.SectionChildContract;
import com.AceInAndroid.ZhihuDailyReport.ui.zhihu.adapter.SectionChildAdapter;
import com.AceInAndroid.ZhihuDailyReport.util.SnackbarUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.ProgressImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by AceInAndroid on 17/4/28.
 */

public class SectionActivity extends BaseActivity<SectionChildPresenter> implements SectionChildContract.View {

    @BindView(R.id.rv_section_content)
    RecyclerView rvSectionContent;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.iv_progress)
    ProgressImageView ivProgress;

    List<SectionChildListBean.StoriesBean> mList;
    SectionChildAdapter mAdapter;

    int id;
    String title;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_section;
    }

    @Override
    protected void initEventAndData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        title = intent.getStringExtra("title");
        setToolBar(mToolBar,title);
        mList = new ArrayList<>();
        mAdapter = new SectionChildAdapter(mContext, mList);
        rvSectionContent.setLayoutManager(new LinearLayoutManager(mContext));
        rvSectionContent.setAdapter(mAdapter);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getThemeChildData(id);
            }
        });
        mAdapter.setOnItemClickListener(new SectionChildAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position, View shareView) {
                mPresenter.insertReadToDB(mList.get(position).getId());
                mAdapter.setReadState(position, true);
                mAdapter.notifyItemChanged(position);
                Intent intent = new Intent();
                intent.setClass(mContext, ZhihuDetailActivity.class);
                intent.putExtra("id", mList.get(position).getId());
                if (shareView != null) {
                    mContext.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(mContext, shareView, "shareView").toBundle());
                } else {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(mContext).toBundle());
                }
            }
        });
        mPresenter.getThemeChildData(id);
        ivProgress.start();
    }

    @Override
    public void showContent(SectionChildListBean sectionChildListBean) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        mList.clear();
        mList.addAll(sectionChildListBean.getStories());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        SnackbarUtil.showShort(getWindow().getDecorView(),msg);
    }
}
