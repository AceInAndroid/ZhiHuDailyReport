package com.AceInAndroid.ZhihuDailyReport.presenter.contract;

import com.AceInAndroid.ZhihuDailyReport.base.BasePresenter;
import com.AceInAndroid.ZhihuDailyReport.base.BaseView;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GoldManagerBean;
import com.AceInAndroid.ZhihuDailyReport.model.bean.GoldManagerItemBean;

import java.util.List;

/**
 * Created by AceInAndroid on 16/11/28.
 */

public interface GoldMainContract {

    interface View extends BaseView {

        void updateTab(List<GoldManagerItemBean> mList);

        void jumpToManager(GoldManagerBean mBean);
    }

    interface Presenter extends BasePresenter<View> {

        void initManagerList();

        void setManagerList();
    }
}
