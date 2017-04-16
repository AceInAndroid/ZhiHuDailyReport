package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.WXItemBean;
import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;

import java.util.List;

/**
 * Created by AceInAndroid on 17/4/29.
 */

public interface WechatContract {

    interface View extends BaseView {

        void showContent(List<WXItemBean> mList);

        void showMoreContent(List<WXItemBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getWechatData();

        void getMoreWechatData();
    }
}
