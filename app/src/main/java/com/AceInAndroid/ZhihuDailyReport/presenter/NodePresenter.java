package com.AceInAndroid.ZhihuDailyReport.presenter;

import com.AceInAndroid.ZhihuDailyReport.base.RxPresenter;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeListBean;
import com.AceInAndroid.ZhihuDailyReport.model.http.RetrofitHelper;
import com.AceInAndroid.ZhihuDailyReport.presenter.contract.NodeContract;
import com.AceInAndroid.ZhihuDailyReport.util.RxUtil;
import com.AceInAndroid.ZhihuDailyReport.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by AceInAndroid on 16/12/23.
 */

public class NodePresenter extends RxPresenter<NodeContract.View> implements NodeContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public NodePresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getContent(String node_name) {
        addSubscribe(mRetrofitHelper.fetchTopicList(node_name)
                .compose(RxUtil.<List<NodeListBean>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<List<NodeListBean>>(mView) {
                    @Override
                    public void onNext(List<NodeListBean> nodeListBeen) {
                        mView.showContent(nodeListBeen);
                    }
                })
        );
    }

    @Override
    public void getTopInfo(String node_name) {
        addSubscribe(mRetrofitHelper.fetchNodeInfo(node_name)
                .compose(RxUtil.<NodeBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<NodeBean>(mView) {
                    @Override
                    public void onNext(NodeBean nodeBean) {
                        mView.showTopInfo(nodeBean);
                    }
                })
        );
    }
}
