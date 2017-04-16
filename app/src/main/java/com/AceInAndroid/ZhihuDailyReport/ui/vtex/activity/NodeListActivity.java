package com.AceInAndroid.ZhihuDailyReport.ui.vtex.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.AceInAndroid.ZhihuDailyReport.app.Constants;
import com.AceInAndroid.ZhihuDailyReport.base.BaseActivity;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeListBean;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.NodeContract;
import com.AceInAndroid.ZhihuDailyReport.ui.vtex.adapter.NodeListAdapter;
import com.AceInAndroid.ZhihuDailyReport.util.SnackbarUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.ProgressImageView;
import com.AceInAndroid.ZhihuDailyReport.R;
import com.AceInAndroid.ZhihuDailyReport.presenter.NodePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by AceInAndroid on 16/12/19.
 */

public class NodeListActivity extends BaseActivity<NodePresenter> implements NodeContract.View {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.iv_progress)
    ProgressImageView ivProgress;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private NodeListAdapter mAdapter;
    private String nodeName;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_replies;
    }

    @Override
    protected void initEventAndData() {
        nodeName = getIntent().getStringExtra(Constants.IT_VTEX_NODE_NAME);
        setToolBar(toolBar, nodeName);
        mAdapter = new NodeListAdapter(mContext, new ArrayList<NodeListBean>());
        rvContent.setLayoutManager(new LinearLayoutManager(mContext));
        rvContent.setAdapter(mAdapter);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getContent(nodeName);
            }
        });
        ivProgress.start();
        mPresenter.getContent(nodeName);
        mPresenter.getTopInfo(nodeName);
    }

    @Override
    public void showError(String msg) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        SnackbarUtil.showShort(toolBar, msg);
    }

    @Override
    public void showContent(List<NodeListBean> mList) {
        if(swipeRefresh.isRefreshing()) {
            swipeRefresh.setRefreshing(false);
        } else {
            ivProgress.stop();
        }
        mAdapter.setContentData(mList);
    }

    @Override
    public void showTopInfo(NodeBean mTopInfo) {
        mAdapter.setTopData(mTopInfo);
    }
}
