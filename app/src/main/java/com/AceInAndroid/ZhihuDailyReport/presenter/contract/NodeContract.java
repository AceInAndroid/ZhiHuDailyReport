package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeListBean;
import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.base.BaseView;

import java.util.List;

/**
 * Created by AceInAndroid on 16/12/23.
 */

public interface NodeContract {

    interface View extends BaseView {

        void showContent(List<NodeListBean> mList);

        void showTopInfo(NodeBean mTopInfo);
    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String node_name);

        void getTopInfo(String node_name);
    }
}
