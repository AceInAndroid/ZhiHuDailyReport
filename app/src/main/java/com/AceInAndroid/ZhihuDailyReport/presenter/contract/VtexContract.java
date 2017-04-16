package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.TopicListBean;

import java.util.List;

/**
 * Created by AceInAndroid on 16/12/23.
 */

public interface VtexContract {

    interface View extends BaseView {

        void showContent(List<TopicListBean> mList);

    }

    interface Presenter extends BasePresenter<View> {

        void getContent(String type);

    }
}
