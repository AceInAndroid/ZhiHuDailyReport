package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.NodeListBean;
import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.model.bean.RealmLikeBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.RepliesListBean;

import java.util.List;

/**
 * Created by AceInAndroid on 16/12/23.
 */

public interface RepliesContract {

    interface View extends BaseView {

        void showContent(List<RepliesListBean> mList);

        void showTopInfo(NodeListBean mTopInfo);
    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String topic_id);

        void getTopInfo(String topic_id);

        void insert(RealmLikeBean bean);

        void delete(String id);

        boolean query(String id);
    }
}
